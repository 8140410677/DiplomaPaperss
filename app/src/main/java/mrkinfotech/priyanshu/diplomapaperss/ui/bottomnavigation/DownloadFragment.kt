package mrkinfotech.priyanshu.diplomapaperss.ui.bottomnavigation

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import mrkinfotech.priyanshu.diplomapaperss.databinding.FragmentDownloadBinding
import mrkinfotech.priyanshu.diplomapaperss.ui.Adapter.DownloadAdapter
import mrkinfotech.priyanshu.diplomapaperss.ui.ModelClass.DownloadStore

class DownloadsFragment : Fragment() {
    private lateinit var binding: FragmentDownloadBinding
    private lateinit var adapter: DownloadAdapter

    private val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            loadDownloads()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDownloadBinding.inflate(inflater, container, false)
        adapter = DownloadAdapter(mutableListOf()) { filePath ->
            openPdf(filePath)
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        loadDownloads()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requireActivity().registerReceiver(
                receiver,
                IntentFilter(DownloadStore.ACTION_DOWNLOADS_UPDATED),
                Context.RECEIVER_EXPORTED
            )
        } else {
            ContextCompat.registerReceiver(
                requireActivity(),
                receiver,
                IntentFilter(DownloadStore.ACTION_DOWNLOADS_UPDATED),
                ContextCompat.RECEIVER_NOT_EXPORTED
            )
        }

    }

    override fun onPause() {
        super.onPause()
        requireActivity().unregisterReceiver(receiver)
    }

    private fun loadDownloads() {
        val list = DownloadStore.getAll(requireContext())
        adapter.updateList(list)
    }

    private fun openPdf(filePath: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(Uri.parse(filePath), "application/pdf")
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

package mrkinfotech.priyanshu.diplomapaperss.ui.Home

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.snackbar.Snackbar
import mrkinfotech.priyanshu.diplomapaperss.R
import mrkinfotech.priyanshu.diplomapaperss.databinding.ActivityMainBinding
import mrkinfotech.priyanshu.diplomapaperss.ui.bottomnavigation.DepartFragment
import mrkinfotech.priyanshu.diplomapaperss.ui.login.LoginFragment

class HomeMainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_home_content_main, HomeFragment())
                .commit()
        }

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.Search -> {
                    loadFragment(DepartFragment())
                    true
                }
                R.id.Proflie -> {
                    loadFragment(LoginFragment())
                    true
                }
                else -> false
            }
        }

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_home_content_main) as NavHostFragment
        val navController = navHostFragment.navController

    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_home_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_home_content_main, fragment)
            .commit()
    }
}
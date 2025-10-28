package mrkinfotech.priyanshu.diplomapaperss.ui.ModelClass

data class DownloadedPaper(
    val name: String,
    val filePath: String,
    val downloadedAt: Long = System.currentTimeMillis()
)

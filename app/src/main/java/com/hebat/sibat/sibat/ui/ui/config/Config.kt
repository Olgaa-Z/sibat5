package com.hebat.sibat.sibat.ui.ui.config

object Config {

    private const val Host="http://192.168.43.93/newss/" //yang bakal berganti
    const val url_berita= Host+"index.php/Webservice/select_berita"
    const val url_gambar= Host+"assets/upload_berita/"
    const val id="id"
    const val url_detail_berita= Host+"index.php/Webservice/select_by_get_berita/"
    const val url_galerifoto= Host+"assets/upload_berita/"
    val DATA_ARRAY = "data"
    val URL_CARI_BERITA =   "index.php/json/cari_berita?s="
}
package com.hebat.sibat.sibat.ui.ui.config

object Config {

    private const val Host="http://192.168.43.93/desalauwba/" //yang bakal berganti
//    const val url_berita= Host+"index.php/Webservice/select_berita"
////    const val url_gambar= Host+"assets/upload_berita/"
////    const val id="id"
////    const val url_detail_berita= Host+"index.php/Webservice/select_by_get_berita/"
////    const val url_galerifoto= Host+"assets/upload_berita/"
////    val url_login =  Host+"index.php/Login/select/"
////    val DATA_ARRAY = "data"
////    val URL_CARI_BERITA =   "index.php/json/cari_berita?s="

    const val url_pengumuman= Host+"index.php/Webservice/select_pengumuman"
    const val url_gambar= Host+"assets/upload_pengumuman/"
    const val id="id"
    const val url_detail_pengumuman= Host+"index.php/Webservice/select_by_get_pengumuman/"
    val url_layanan = Host+"index.php/Webservice/select_layanan/"
    val url_detail_layanan = Host+"index.php/Webservice/select_by_get_layanan/"
    val url_detail_berita = Host+"index.php/Webservice/select_by_get_berita/"
    val url_berita = Host+"index.php/Webservice/select_berita/"
    val url_programdesa = Host+"index.php/Webservice/select_programdesa/"
    val url_potensidesa = Host+"index.php/Webservice/select_potensidesa/"
    val  url_detail_potensi = Host+"index.php/Webservice/select_by_get_potensidesa/"
    val url_detail_programdesa = Host+"index.php/Webservice/select_by_get_programdesa/"
    val url_galeri = Host+"index.php/Webservice/select_galeri/"
    const val url_galerifoto= Host+"assets/upload/"
    val url_login =  Host+"index.php/Login/select/"
    val url_lembaga = Host+"index.php/Webservice/select_lembaga/"
    val url_detail_lembaga = Host+"index.php/Webservice/select_by_get_lembaga/"
    val url_pengaduan= Host+"index.php/Webservice/insert_pengaduan"
    val url_datadesawebview= Host+"index.php/Programdesavbiew/"
    val url_programdesawebview= Host+"index.php/Programdesaview/"
    val url_privacywebview= Host+"index.php/Privacy/"
    val url_register = Host+"api/register.php/"
}
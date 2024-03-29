package com.hebat.sibat.sibat.ui.ui.layanan

import android.app.ProgressDialog
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.hebat.sibat.sibat.R
import com.hebat.sibat.sibat.ui.ui.RequestHandler
import com.hebat.sibat.sibat.ui.ui.config.Config
import kotlinx.android.synthetic.main.detail_layanan.*
import org.json.JSONObject

class DetailLayanan : AppCompatActivity() {


    private var id:String?=null
    private var pd: ProgressDialog?=null
    private var from :String?=null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_layanan)

//        setSupportActionBar(tToolbar)
//        supportActionBar?.setDisplayShowHomeEnabled(true)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        var t: String = intent.getStringExtra("Title")
//        supportActionBar?.title =t


        id=intent.getStringExtra(Config.id)
        from=intent.getStringExtra("from")
        Toast.makeText(this@DetailLayanan, from, Toast.LENGTH_SHORT).show()
        if (from.equals("berita",true)){
            getdetaillayanan().execute()
        }else{
            getdetaillayanan().execute()
        }

        val actionBar = supportActionBar
        actionBar!!.title = "Detail Layanan"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    inner class getdetaillayanan : AsyncTask<String, Void, String>(){

        override fun doInBackground(vararg params: String?): String {
            val request= RequestHandler()
            return request.sendGetRequest(Config.url_detail_berita+id)

        }

        override fun onPreExecute() {
            super.onPreExecute()
            pd= ProgressDialog.show(this@DetailLayanan,"","Wait...",false,true)
        }


        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            pd?.dismiss()
            val objek= JSONObject(result)
            if (objek.getInt("status")==1){
                Toast.makeText(this@DetailLayanan, "Tidak ada data!", Toast.LENGTH_SHORT).show()
            }
            else {
                val array = objek.getJSONArray("data")
                for (i in 0 until array.length()) {
                    val data = array.getJSONObject(i)
                    judul.text = data.getString("judul")
                    isi.text = data.getString("isi")
                    tanggal.text = data.getString("tanggal")
                    Glide.with(this@DetailLayanan)
                        .load(Config.url_gambar+ data.getString("gambar")).into(gambarberita)
                }
            }
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

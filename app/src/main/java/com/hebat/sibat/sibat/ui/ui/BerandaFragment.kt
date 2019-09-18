package com.hebat.sibat.sibat.ui.ui

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hebat.sibat.sibat.R
import com.hebat.sibat.sibat.ui.ui.berita.Berita
import kotlinx.android.synthetic.main.beranda_fragment.*

class BerandaFragment : Fragment() {

    private var pd: ProgressDialog? = null
    private var list: MutableList<String>? = null
    private var listid: MutableList<String>? = null

    companion object {
        val TAG: String = BerandaFragment::class.java.simpleName
        fun newInstance() = BerandaFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity?.title = getString(R.string.title_beranda)
        val view = inflater.inflate(R.layout.beranda_fragment, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        berita.setOnClickListener { startActivity(Intent(activity, Berita::class.java)) }

        maps.setOnClickListener { activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, PetanagariFragment())?.commit() }


            list = mutableListOf()
            listid = mutableListOf()
        }


}

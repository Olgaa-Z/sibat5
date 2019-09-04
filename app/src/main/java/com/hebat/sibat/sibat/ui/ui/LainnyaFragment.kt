package com.hebat.sibat.sibat.ui.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class LainnyaFragment : Fragment() {

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    activity?.title = getString(com.hebat.sibat.sibat.R.string.title_lainnya)
    val view = inflater.inflate(com.hebat.sibat.sibat.R.layout.lainnya_fragment, container, false)
    return view
  }

}
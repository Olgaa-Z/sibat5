package com.hebat.sibat.sibat.ui.ui

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.hebat.sibat.sibat.R

//class PetanagariFragment : Fragment(), OnMapReadyCallback, View.OnClickListener, GoogleMap.OnMyLocationButtonClickListener,
//    GoogleMap.OnMyLocationClickListener, GoogleMap.OnMarkerClickListener {
//
//    lateinit var pantai_menganti: LatLng
//    lateinit var tugu_lawet: LatLng
//    lateinit var pentulu_indah: LatLng
//
//    override fun onMarkerClick(p0: Marker?): Boolean {
//        val lokasi = p0?.getTitle()
//        if(lokasi.equals("Pantai Menganti")){
//            val intent = Intent(getActivity(),DetailPeta::class.java)
//            intent?.putExtra("Title", "Pantai Menganti")
//            intent?.putExtra("URL", "https://goo.gl/maps/A8ePoaKZAtH2")
//            intent?.putExtra("Detail", getString(R.string.pantai_menganti))
//            startActivity(intent)
//        }else if(lokasi.equals("Tugu Lawet")){
//            val intent = Intent(getActivity(),DetailPeta::class.java)
//            intent?.putExtra("Title", "Tugu Lawet")
//            intent?.putExtra("URL", "https://goo.gl/maps/1nNKMBsyee92")
//            intent?.putExtra("Detail", getString(R.string.tugu_lawet))
//            startActivity(intent)
//        }else if(lokasi.equals("Pentulu Indah")){
//            val intent = Intent(getActivity(),DetailPeta::class.java)
//            intent?.putExtra("Title", "Pentulu Indah")
//            intent?.putExtra("URL", "https://goo.gl/maps/62noxvGx2EH2")
//            intent?.putExtra("Detail", getString(R.string.pentulu_indah))
//            startActivity(intent)
//        }else{}
//        return true
//    }
//
//    override fun onMyLocationClick(p0: Location) {
//
//    }
//
//    override fun onMyLocationButtonClick(): Boolean {
//        return false
//    }
//
//    override fun onClick(v: View?) {
//        when(v!!.id){
//            R.id.button_Normal->{
//                map.mapType= GoogleMap.MAP_TYPE_NORMAL
//            }
//            R.id.button_Satellite->{
//                map.mapType= GoogleMap.MAP_TYPE_HYBRID
//            }
//        }
//    }
//
//    lateinit var map: GoogleMap
//    lateinit var mp: SupportMapFragment
//    lateinit var normal: Button
//    lateinit var satellite: Button
//    @SuppressLint("MissingPermission")
//
//    override fun onMapReady(p0: GoogleMap?) {
//        map=p0!!
//        val permission = this.context?.let {
//            ContextCompat.checkSelfPermission(
//                it,
//                Manifest.permission.ACCESS_FINE_LOCATION)
//        }
//
//        if (permission == PackageManager.PERMISSION_GRANTED) {
//            map.setMyLocationEnabled(true);
//            map.setOnMyLocationButtonClickListener(this);
//            map.setOnMyLocationClickListener(this);
//            map.uiSettings.setZoomControlsEnabled(true);
//        }
//
//        pantai_menganti= LatLng(-7.770181, 109.413023)
//        map.addMarker(MarkerOptions().position(pantai_menganti).title("Pantai Menganti"))
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(pantai_menganti,10F))
//
//        tugu_lawet= LatLng(-7.670917, 109.660838)
//        map.addMarker(MarkerOptions().position(tugu_lawet).title("Tugu Lawet"))
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(tugu_lawet,10F))
//
//        pentulu_indah= LatLng(-7.536018, 109.680097)
//        map.addMarker(MarkerOptions().position(pentulu_indah).title("Pentulu Indah"))
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(pentulu_indah,10F))
//
//
//        val builder = LatLngBounds.Builder()
//        builder.include(pantai_menganti)
//        builder.include(tugu_lawet)
//        builder.include(pentulu_indah)
//        val bounds = builder.build()
//        map.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 20))
//
//        map.setOnMarkerClickListener(this)
//    }
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        getActivity()?.setTitle("Peta Wisata");
//        return inflater.inflate(R.layout.petanagari_fragment,null)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        mp= childFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
//        mp.getMapAsync(this)
//        normal=view.findViewById(R.id.button_Normal)
//        satellite=view.findViewById(R.id.button_Satellite)
//
//        normal.setOnClickListener(this)
//        satellite.setOnClickListener(this)
//    }
//
//}

class PetanagariFragment : Fragment(),OnMapReadyCallback, View.OnClickListener,
    GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener, GoogleMap.OnMarkerClickListener {

    lateinit var map: GoogleMap
    lateinit var mp: SupportMapFragment
    lateinit var normal: Button
    lateinit var satelit: Button
    @SuppressLint("MissingPermission")

    lateinit var pantai_menganti : LatLng
    lateinit var tugu_lawet : LatLng

    override fun onMarkerClick(p0: Marker?): Boolean {
        val lokasi = p0?.getTitle()
        if(lokasi.equals("Pantai Menganti")){
            val intent = Intent(getActivity(),DetailPeta::class.java)
            intent?.putExtra("Title", "Pantai Menganti")
            intent?.putExtra("URL", "https://goo.gl/maps/A8ePoaKZAtH2")
            intent?.putExtra("Detail", getString(R.string.pantai_menganti))
            startActivity(intent)
        }
        else if(lokasi.equals("Tugu Lawet")) {
            val intent = Intent(getActivity(), DetailPeta::class.java)
            intent?.putExtra("Title", "Tugu Lawet")
            intent?.putExtra("URL", "https://goo.gl/maps/1nNKMBsyee92")
            intent?.putExtra("Detail", getString(R.string.tugu_lawet))
            startActivity(intent)
        }
        else{

        }
        return true
    }

    override fun onMyLocationClick(p0: Location) {

    }

    override fun onMyLocationButtonClick(): Boolean {
        return false
    }

    override fun onClick(v: View?){

        when (v!!.id){
            R.id.normal -> {
                map.mapType = GoogleMap.MAP_TYPE_NORMAL
            }

            R.id.satelit -> {
                map.mapType = GoogleMap.MAP_TYPE_SATELLITE
            }

        }

    }


    override fun onMapReady(p0: GoogleMap){

//        var pariaman: LatLng
//        var lubukalung: LatLng
        map= p0!!

        val permission = this.context?.let {
                        ContextCompat.checkSelfPermission(
                it,
                Manifest.permission.ACCESS_FINE_LOCATION)
        }

        if (permission == PackageManager.PERMISSION_GRANTED) {
            map.setMyLocationEnabled(true);
            map.setOnMyLocationButtonClickListener(this);
            map.setOnMyLocationClickListener(this);
            map.uiSettings.setZoomControlsEnabled(true);
        }

        pantai_menganti = LatLng(-0.625578,100.119668)
        map.addMarker(MarkerOptions().position(pantai_menganti).title("Tugu Tabuik"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(pantai_menganti, 10F))

        tugu_lawet = LatLng(-0.6847585,100.2141347)
        map.addMarker(MarkerOptions().position(tugu_lawet).title("Lubuak Aluang"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(tugu_lawet, 10F))

        val builder = LatLngBounds.Builder()
        builder.include(pantai_menganti)
        builder.include(tugu_lawet)
        val bounds = builder.build()
        map.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 20))

        map.setOnMarkerClickListener(this)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.petanagari_fragment,null);
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mp=childFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mp.getMapAsync(this)

        normal = view.findViewById(R.id.normal)
        satelit = view.findViewById(R.id.satelit)

        normal.setOnClickListener(this)
        satelit.setOnClickListener(this)

    }


}

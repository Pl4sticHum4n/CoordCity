package com.example.proyecto8

import android.Manifest
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.proyecto8.databinding.ActivityMainBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnUpdate.setOnClickListener {
            getlocation()
        }
    }

    fun getlocation(){
        val geocoder = Geocoder(this, Locale.getDefault())
        val addressList = geocoder.getFromLocationName(binding.getCiudad.text.toString(), 1)
        if(addressList[0].hasLatitude() && addressList[0].hasLongitude()){
            binding.city.setText("Ciudad: ${binding.getCiudad.text.toString()}")
            binding.latitud.setText("Latitud: ${addressList[0].latitude}")
            binding.longitud.setText("Longitud: ${addressList[0].longitude}")
            Log.d("LocationP", "Coordenadas: ${addressList[0].latitude}, ${addressList[0].latitude}")
            binding.getCiudad.text.clear()
        }
    }
}
package com.vicks.fbs

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.vicks.fbs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvTv1.text = "Text accessed from BuildConfig \n ${BuildConfig.BASE_URL} \n ${BuildConfig.FLAVOR}  \n" +
                " ${BuildConfig.APPLICATION_ID}"

        binding.tvTv2.setText(R.string.explain)
    }
}
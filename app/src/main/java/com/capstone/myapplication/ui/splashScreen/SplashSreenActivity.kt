package com.capstone.myapplication.ui.splashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.capstone.myapplication.MainActivity
import com.capstone.myapplication.R

class SplashSreenActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_splash_sreen)

		supportActionBar?.hide()  // untuk menghilangkan app bar

		Handler(Looper.getMainLooper()).postDelayed({
			startActivity(Intent(this, MainActivity::class.java))
			finish()
		}, 2000)
	}
}
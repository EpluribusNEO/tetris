package com.epluribusneo.tetris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.epluribusneo.tetris.storage.AppPreferences
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
	var tvHighScore: TextView? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

        // Убираем панель сверху
		val appBar: ActionBar? = supportActionBar
		if(appBar != null){
			appBar.hide()
		}


		val btnExit: Button = findViewById<Button>(R.id.btn_exit)
		val btnResetScare: Button = findViewById<Button>(R.id.btn_reset_score)
		val btnNewGame: Button = findViewById<Button>(R.id.btn_new_game)
		tvHighScore = findViewById<TextView>(R.id.tv_high_score)

		val preferences = AppPreferences(this)
		if(preferences != null){
			tvHighScore?.text = "High Score: ${preferences.getHighScore()}"
		}


		btnExit.setOnClickListener(this::onBtnExitClick)
		btnResetScare.setOnClickListener(this::onBtnResetScoreClick)
		btnNewGame.setOnClickListener(this::onBtnNewGameClick)
	}

	private fun onBtnExitClick(view: View): Unit{
		System.exit(0) //finish()
	}

	private fun onBtnNewGameClick(view: View): Unit {
		//START NEW GAME
		val intent = Intent(this, GameActivity::class.java)
		startActivity(intent)
	}

	private fun onBtnResetScoreClick(view: View): Unit {
		//Сброс рекорда очков
		val preferences = AppPreferences(this)
		preferences.clearHighScore()
		Snackbar.make(view, "Score successfully reset", Snackbar.LENGTH_SHORT).show()
		tvHighScore?.text = "High Score: ${preferences.getHighScore()}"
	}
}
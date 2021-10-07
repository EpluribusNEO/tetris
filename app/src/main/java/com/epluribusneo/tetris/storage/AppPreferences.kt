package com.epluribusneo.tetris.storage

import android.content.Context
import android.content.SharedPreferences

class AppPreferences(ctx: Context) {
	var data: SharedPreferences = ctx.getSharedPreferences(
		"APP_PREFERENCES", Context.MODE_PRIVATE )

	fun savedHighScore(highScore: Int): Unit{
		data.edit().putInt("HIGH_SCORE", highScore).apply()
	}

	fun getHighScore(): Int{
		//Возвращает сохранённые очки. По дефолту вернёт 0
		return data.getInt("HIGH_SCORE", 0)
	}

	fun clearHighScore(): Unit{
		data.edit().putInt("HIGH_SCORE", 0).apply()
	}
}
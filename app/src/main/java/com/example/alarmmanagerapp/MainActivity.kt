package com.example.alarmmanagerapp

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_IMMUTABLE
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*
class MainActivity : AppCompatActivity() {
    private lateinit var btnStart: Button
    private lateinit var btnStop: Button
    lateinit var pendingIntent: PendingIntent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnStart = findViewById(R.id.btnStartService)
        btnStop = findViewById(R.id.btnStopService)
        btnStart.setOnClickListener {
            val myIntent = Intent(this@MainActivity, MyAlarmService::class.java)
            pendingIntent = PendingIntent.getService(this@MainActivity, 0, myIntent, FLAG_IMMUTABLE)
            val alarmManager: AlarmManager = getSystemService(Context.ALARM_SERVICE) as
                    AlarmManager
            val calendar: Calendar = Calendar.getInstance()
            calendar.timeInMillis = System.currentTimeMillis()
            calendar.add(Calendar.SECOND, 3)
            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.timeInMillis,
                pendingIntent)
            Toast.makeText(baseContext, "Starting Service Alarm", Toast.LENGTH_LONG).show()
        }
        btnStop.setOnClickListener {
            val alarmManager: AlarmManager = getSystemService(Context.ALARM_SERVICE) as
                    AlarmManager
            alarmManager.cancel(pendingIntent)
            Toast.makeText(baseContext, "Service Cancelled", Toast.LENGTH_LONG).show()
        }
    }
}
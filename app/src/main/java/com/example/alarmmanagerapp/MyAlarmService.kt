package com.example.alarmmanagerapp

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
@Suppress("DEPRECATION")
class MyAlarmService : Service() {
    override fun onCreate() {
        Toast.makeText(this, "MyAlarmService.onCreate()", Toast.LENGTH_LONG).show()
        super.onCreate()
    }
    override fun onBind(intent: Intent?): IBinder? {
        Toast.makeText(this, "MyAlarmService.onBind()", Toast.LENGTH_LONG).show()
        return null
    }
    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "MyAlarmService.onDestroy()", Toast.LENGTH_LONG).show()
    }
    override fun onStart(intent: Intent?, startId: Int) {
        super.onStart(intent, startId)
        Toast.makeText(this, "MyAlarmService.onStart()", Toast.LENGTH_LONG).show()
    }
    override fun onUnbind(intent: Intent?): Boolean {
        Toast.makeText(this, "MyAlarmService.onUnbind()", Toast.LENGTH_LONG).show()
        return super.onUnbind(intent)
    }
}

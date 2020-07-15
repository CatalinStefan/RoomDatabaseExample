package com.devtides.roomdatabaseexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.devtides.roomdatabaseexample.db.User
import com.devtides.roomdatabaseexample.db.UserDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var db: UserDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Room.databaseBuilder(applicationContext, UserDatabase::class.java, "database-name")
            .build()

        val user1 = User("James", "Bond", 35, true)
        val user2 = User("Alice", "Smith", 28, true)
        val user3 = User("Michael", "M.", 25, false)

        GlobalScope.launch {
            db.userDao().deleteAll()
            db.userDao().insert(user1, user2, user3)

            displayUsers()
        }
    }

    private suspend fun displayUsers() {
        val users = db.userDao().getAllUsers()
        var displayText = ""
        for (user in users) {
            displayText += "${user.name} ${user.lastName} - ${user.age}\n"
        }
        display.text = displayText
    }
}
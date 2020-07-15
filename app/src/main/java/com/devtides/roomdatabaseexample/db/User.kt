package com.devtides.roomdatabaseexample.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @ColumnInfo(name = "first_name") val name: String,
    @ColumnInfo(name = "last_name") val lastName: String,
    @ColumnInfo(name = "age") val age: Int,
    @ColumnInfo(name = "employed") val working: Boolean
) {
    @PrimaryKey(autoGenerate = true) var uid: Int? = null
}
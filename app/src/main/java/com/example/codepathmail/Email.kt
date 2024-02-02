package com.example.codepathmail

class Email(
    val sender: String,
    val title: String,
    val summary: String,
    var clicked: Boolean = false,
    val date: String,
    val profileImageResId: Int
) {
}
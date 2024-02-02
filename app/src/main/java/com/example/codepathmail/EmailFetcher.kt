package com.example.codepathmail

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class EmailFetcher {
    companion object {
        private val senders = listOf("Dahlia Cline", "Kevin Miranda", "Kaya Austin", "Laila Calderon", "Marquise Rhodes", "Fletcher Patel", "Luz Barron", "Kamren Dudley", "Jairo Foster", "Lilah Sandoval", "Ansley Blake", "Slade Sawyer", "Jaelyn Holmes", "Phoenix Bright", "Ernesto Gould")
        private const val title = "Welcome to Kotlin!"
        private const val summary = "Welcome to the Android Kotlin Course! We're excited to have you join us and learn how to develop Android apps using Kotlin. Here are some tips to get started."
        private const val clicked = false
        fun getEmails(): MutableList<Email> {
            val emails : MutableList<Email> = ArrayList()
            val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
            val profileImageResId = R.drawable.dragon
            for (i in 0..9) {
                val currentDate = dateFormat.format(Date())
                val email = Email(senders[i], title, summary, clicked, currentDate, profileImageResId)
                emails.add(email)
            }
            return emails
        }

        fun getNext5Emails(): MutableList<Email> {
            val newEmails : MutableList<Email> = ArrayList()
            val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
            val profileImageResId = R.drawable.dragon
            for (i in 10..14) {
                val currentDate = dateFormat.format(Date())
                val email = Email(senders[i], title, summary, clicked, currentDate, profileImageResId)
                newEmails.add(email)
            }
            return newEmails
        }
    }
}
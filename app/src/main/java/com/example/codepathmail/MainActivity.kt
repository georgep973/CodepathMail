package com.example.codepathmail

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var emails: List<Email>
    private lateinit var adapter: EmailAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lookup the RecyclerView in activity layout
        val emailsRv = findViewById<RecyclerView>(R.id.emailsRv)
        // Fetch the list of emails
        emails = EmailFetcher.getEmails()
        // Create adapter passing in the list of emails
        adapter = EmailAdapter(emails)
        // Attach the adapter to the RecyclerView to populate items
        emailsRv.adapter = adapter
        // Set layout manager to position the items
        emailsRv.layoutManager = LinearLayoutManager(this)

        // Add item click listener to the RecyclerView using RecyclerItemClickListener
        emailsRv.addOnItemTouchListener(
            RecyclerItemClickListener(this, emailsRv, object : RecyclerItemClickListener.OnItemClickListener {
                override fun onItemClick(view: View, position: Int) {
                    // When an email item is clicked, update the 'clicked' field
                    val clickedEmail = emails[position]
                    clickedEmail.clicked = true

                    // Notify the adapter to update the view for this item
                    adapter.notifyItemChanged(position)
                }
            })
        )

        findViewById<Button>(R.id.loadMoreBtn).setOnClickListener {
            // Fetch next 5 emails
            val newEmails = EmailFetcher.getNext5Emails()
            // Add new emails to existing list of emails
            (emails as MutableList<Email>).addAll(newEmails)
            // Notify the adapter there's new emails so the RecyclerView layout is updated
            adapter.notifyDataSetChanged()
        }
    }
}
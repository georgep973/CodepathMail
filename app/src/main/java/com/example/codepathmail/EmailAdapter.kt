package com.example.codepathmail

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val emails: List<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Your holder should contain a member variable for any view that will be set as you render a row
        val senderTextView: TextView
        val titleTextView: TextView
        val summaryTextView: TextView
        val dateTextView: TextView

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            senderTextView = itemView.findViewById(R.id.senderTv)
            titleTextView = itemView.findViewById(R.id.titleTv)
            summaryTextView = itemView.findViewById(R.id.summaryTv)
            dateTextView = itemView.findViewById(R.id.dateTv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.email_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int {
        return emails.size
    }

    // Populate data into the item through the holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val email = emails[position]
        // Set item views based on views and data model
        holder.senderTextView.text = email.sender
        holder.titleTextView.text = email.title
        holder.summaryTextView.text = email.summary
        holder.dateTextView.text = email.date

        // Change font style based on 'clicked' status
        if (email.clicked) {
            // Email is clicked, use regular style
            holder.senderTextView.setTypeface(null, Typeface.NORMAL)
            holder.titleTextView.setTypeface(null, Typeface.NORMAL)
            holder.summaryTextView.setTypeface(null, Typeface.NORMAL)
            holder.dateTextView.setTypeface(null, Typeface.NORMAL)
        } else {
            // Email is un-clicked (unread), make it bold
            holder.senderTextView.setTypeface(null, Typeface.BOLD)
            holder.titleTextView.setTypeface(null, Typeface.BOLD)
            holder.summaryTextView.setTypeface(null, Typeface.BOLD)
            holder.dateTextView.setTypeface(null, Typeface.BOLD)
        }

        // Change font style and weight
        holder.senderTextView.setTypeface(null, Typeface.BOLD)
        holder.titleTextView.setTypeface(null, Typeface.ITALIC)

        // Change the weight of the TextViews (e.g., adjust layout_weight)
        val params = holder.senderTextView.layoutParams as ConstraintLayout.LayoutParams
        params.horizontalWeight = 1.0f // Adjust the weight as needed
        holder.senderTextView.layoutParams = params
    }
}
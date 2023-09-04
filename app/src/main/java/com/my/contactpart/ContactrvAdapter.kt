package com.my.contactpart

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.my.contactpart.databinding.ContactlistBinding
import com.my.contactpart.ui.ContactDetailsActivity
import com.squareup.picasso.Picasso

class ContactrvAdapter(var contactlist: List<ContactData>, val context: Context) : RecyclerView.Adapter<ContactrvAdapter.ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = ContactlistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contactdetail = contactlist[position]
        holder.binding.apply {
            tvName.text = contactdetail.name
            tvEmail.text = contactdetail.email
            tvNumber.text = contactdetail.contact

            if (contactdetail.avatar.isNotBlank()) {
                Picasso.get()
                    .load(contactdetail.avatar)
                    .resize(80, 80)
                    .centerCrop()
                    .into(ivperson)
            }

            cvContact.setOnClickListener {
                val intent = Intent(context, ContactDetailsActivity::class.java)
                intent.putExtra("CONTACT_ID", contactdetail.contactId)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return contactlist.size
    }

    class ContactViewHolder(var binding: ContactlistBinding) : RecyclerView.ViewHolder(binding.root)
}

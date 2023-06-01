package com.my.contactpart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.my.contactpart.databinding.ActivityMainBinding
import com.my.contactpart.databinding.ContactlistBinding

class ContactrvAdapter(var contactlist:List<ContactData>):RecyclerView.Adapter<ContactViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
       var binding=ContactlistBinding.inflate(
           LayoutInflater.from(parent.context),
           parent,false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        var contactdetail=contactlist[position]
        holder.binding.apply {
            tvName.text=contactdetail.name
            tvEmail.text =contactdetail.email
            tvNumber.text=contactdetail.contact
        }
    }

    override fun getItemCount(): Int {
       return contactlist.size
    }
}

class ContactViewHolder(var binding: ContactlistBinding):RecyclerView.ViewHolder(binding.root)
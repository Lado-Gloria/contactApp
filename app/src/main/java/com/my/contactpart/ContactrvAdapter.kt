package com.my.contactpart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.my.contactpart.databinding.ActivityMainBinding
import com.my.contactpart.databinding.ContactlistBinding
import com.squareup.picasso.Picasso

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
            var binding=holder.binding
            Picasso.get()
                .load(contactdetail.avatar)
                .into(binding.ivperson)
        }
    }

    override fun getItemCount(): Int {
       return contactlist.size
    }
}

class ContactlistBinding {

}

class ContactViewHolder(var binding: ContactlistBinding):RecyclerView.ViewHolder(binding.root)
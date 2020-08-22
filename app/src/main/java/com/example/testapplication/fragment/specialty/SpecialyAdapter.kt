package com.example.testapplication.fragment.specialty

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.entity.responcemodel.SpecialtyDb
import com.example.testapplication.R
import kotlinx.android.synthetic.main.item_speciality.view.*

class SpecialyAdapter(
    private var itemList: List<SpecialtyDb>
) :
    RecyclerView.Adapter<SpecialyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_speciality, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItem(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(item: SpecialtyDb) {
            with(itemView) {
                vSpecialityName.text = item.name
            }
        }

    }
}
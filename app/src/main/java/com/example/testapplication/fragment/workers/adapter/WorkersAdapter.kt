package com.example.testapplication.fragment.workers.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.entity.localmodels.WorkersInfo
import com.example.testapplication.R
import com.example.testapplication.utils.calculateAge
import kotlinx.android.synthetic.main.item_worker.view.*

class WorkersAdapter(
    private var itemList: List<WorkersInfo>,
    var specialty: (item: WorkersInfo) -> Unit,
) :
    RecyclerView.Adapter<WorkersAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_worker, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItem(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    fun updateList(list: List<WorkersInfo>?) {
        list?.let {
            itemList = it
            notifyDataSetChanged()
        }
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(item: WorkersInfo) {
            with(itemView) {
                vFirstName.text = item.firstName?.toLowerCase()?.capitalize()
                vLastName.text = item.lastName?.toLowerCase()?.capitalize()
                vAge.text =
                    String.format(context.getString(R.string.age), calculateAge(item.birthday))
                item.avatarUrl?.apply {
                    Glide.with(context)
                        .load(this)
                        .into(vAvatarLogo)
                }
                itemView.setOnClickListener {
                    specialty(item)
                }
            }
        }

    }
}
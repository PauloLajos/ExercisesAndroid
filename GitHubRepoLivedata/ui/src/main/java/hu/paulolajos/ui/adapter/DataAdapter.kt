package hu.paulolajos.ui.adapter

/**
 * To show the data in list we are adding recylerview in package data → adapter → DataAdapter.kt
 */

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hu.paulolajos.data.model.MyData
import hu.paulolajos.ui.databinding.RecyclerLayoutBinding

class DataAdapter : RecyclerView.Adapter<DataAdapter.MyViewHolder>() {

    private var items = ArrayList<MyData>()

    fun setData(data : ArrayList<MyData>){
        this.items = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RecyclerLayoutBinding.inflate(layoutInflater)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class MyViewHolder(
        private val binding: RecyclerLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun bind(data: MyData){
            binding.gitHubData = data
            binding.executePendingBindings()
        }
    }
}
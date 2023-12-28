package hu.paulolajos.ui.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import hu.paulolajos.room.User
import hu.paulolajos.ui.R
import hu.paulolajos.ui.databinding.CustomRowBinding
import org.w3c.dom.Text

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var _binding: CustomRowBinding? = null
    private val binding get() = _binding!!

    private var userList = emptyList<User>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //_binding = CustomRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        //return MyViewHolder(binding)
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.custom_row,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        //TODO viewBinding!!!
        holder.itemView.findViewById<View>(R.id.id_txt).text = currentItem.id.toString()
        holder.itemView.firstName_txt.text = currentItem.firstName
        holder.itemView.lastName_txt.text = currentItem.lastName
        holder.itemView.age_txt.text = currentItem.age.toString()

        holder.itemView.rowLayout.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

    }

    fun setData(users: List<User>) {
        this.userList = users
        @Suppress("NotifyDataSetChanged")
        notifyDataSetChanged()
    }
}
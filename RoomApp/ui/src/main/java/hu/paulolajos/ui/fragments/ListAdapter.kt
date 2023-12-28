package hu.paulolajos.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hu.paulolajos.room.User
import hu.paulolajos.ui.databinding.CustomRowBinding

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var _binding: CustomRowBinding? = null
    private val binding get() = _binding!!

    private var userList = emptyList<User>()

    class MyViewHolder(binding: CustomRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        _binding = CustomRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        with(userList[position]) {
            binding.idTxt.text = id.toString()
            binding.firstNameTxt.text = firstName
            binding.lastNameTxt.text = lastName
            binding.ageTxt.text = age.toString()
        }
    }

    fun setData(users: List<User>) {
        this.userList = users
        @Suppress("NotifyDataSetChanged")
        notifyDataSetChanged()
    }
}
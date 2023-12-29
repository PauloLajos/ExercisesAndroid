package hu.paulolajos.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import hu.paulolajos.room.User
import hu.paulolajos.ui.databinding.CustomRowBinding

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var _binding: CustomRowBinding? = null
    private val binding get() = _binding!!

    private var userList = emptyList<User>()

    class MyViewHolder(binding: CustomRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        _binding = CustomRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        binding.apply {
            idTxt.text = currentItem.id.toString()
            firstNameTxt.text = currentItem.firstName
            lastNameTxt.text = currentItem.lastName
            ageTxt.text = currentItem.age.toString()

            rowLayout.setOnClickListener {
                val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
                binding.root.findNavController().navigate(action)
            }
        }
    }

    fun setData(users: List<User>) {
        this.userList = users
        @Suppress("NotifyDataSetChanged")
        notifyDataSetChanged()
    }
}
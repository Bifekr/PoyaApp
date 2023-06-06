package ir.minicartoon.poyaapp.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.minicartoon.poyaapp.databinding.BestUserItemBinding
import ir.minicartoon.poyaapp.model.User

class BestUserAdapter(private val bestUserList: List<User>) :
    RecyclerView.Adapter<BestUserAdapter.BestUserViewHolder>() {
    inner class BestUserViewHolder(private val binding: BestUserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.txtBestUserItemName.text = user.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestUserViewHolder {

        val binding =
            BestUserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BestUserViewHolder(binding)
    }

    /*override fun getItemCount()= bestUserList.size */
    override fun getItemCount(): Int {
        return bestUserList.size

    }

    override fun onBindViewHolder(holder: BestUserViewHolder, position: Int) {


        val bestUser: User = bestUserList[position]
        holder.bind(bestUser)


    }
}
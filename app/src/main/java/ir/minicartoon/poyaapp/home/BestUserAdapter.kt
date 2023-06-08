package ir.minicartoon.poyaapp.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ir.minicartoon.poyaapp.R
import ir.minicartoon.poyaapp.databinding.BestUserItemBinding
import ir.minicartoon.poyaapp.model.User
import kotlinx.coroutines.NonDisposableHandle.parent

class BestUserAdapter(
    private val bestUserList: List<User>,
    val onClickBestUserItem: (id: Int) -> Unit
) :
    RecyclerView.Adapter<BestUserAdapter.BestUserViewHolder>() {
    inner class BestUserViewHolder(val binding: BestUserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.txtBestUserItemName.text = user.name
            binding.txtBestUserItemPoint.text = user.point
            // Picasso.get().load(user.image).into(binding.imgEditProfileImage)
            if (user.image != null) {
                Picasso.get().load(user.image).into(binding.imgEditProfileImage)
            } else {
                if (user.jensiat == 0) {
                    Picasso.get().load(R.drawable.man).into(binding.imgEditProfileImage)
                } else {
                    Picasso.get().load(R.drawable.woman).into(binding.imgEditProfileImage)

                }
            }

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
        holder.binding.relBestUserItemParent.setOnClickListener {

            onClickBestUserItem(bestUserList[position].id)
        }

    }
}
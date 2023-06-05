package ir.minicartoon.poyaapp.function

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ir.minicartoon.poyaapp.R

class ListAdapter(val list: MutableList<String>,var onclickList:(String)->Unit) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var parentRv = itemView.findViewById<ConstraintLayout>(R.id.parent_rowList)
        var tv = itemView.findViewById<TextView>(R.id.tv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {

        var view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.row_rv_list, parent, false)
        return ListViewHolder(view)

    }

    override fun getItemCount(): Int {
        return list.size

    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        holder.tv.text = list[position]
        holder.parentRv.setOnClickListener {
            onclickList(list[position])
          //onClickListener.onClick(list[position])
        }
    }
}


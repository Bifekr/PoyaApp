package ir.minicartoon.poyaapp.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import ir.minicartoon.poyaapp.R
import ir.minicartoon.poyaapp.model.Codes

class BestCodesAdapter(var list: List<Codes>, var onBestCodeItemClick: (code: Codes) -> Unit) :
    RecyclerView.Adapter<BestCodesAdapter.BestCodesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestCodesViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.best_codes_item, parent, false)
        return BestCodesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BestCodesViewHolder, position: Int) {
        holder.txtTitle.setText(list[position].title)
        holder.txtPoint.text = "${list[position].point.toString()} رای مثبت "
        holder.parent.setOnClickListener {
            onBestCodeItemClick(list[position])
        }

    }

    class BestCodesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var parent = itemView.findViewById<RelativeLayout>(R.id.rel_bestCodeItem_parent)
        var txtTitle = itemView.findViewById<TextView>(R.id.txt_bestCodesItem_title)
        var txtPoint = itemView.findViewById<TextView>(R.id.txt_bestCodesItem_point)
    }
}
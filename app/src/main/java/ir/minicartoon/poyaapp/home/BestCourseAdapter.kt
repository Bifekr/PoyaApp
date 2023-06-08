package ir.minicartoon.poyaapp.home

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ir.minicartoon.poyaapp.R
import ir.minicartoon.poyaapp.databinding.BestCourseItemBinding
import ir.minicartoon.poyaapp.model.Cource

class BestCourseAdapter(val list: List<Cource>) :
    RecyclerView.Adapter<BestCourseAdapter.BestCourseViewHolder>() {
    class BestCourseViewHolder(private var binding: BestCourseItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(course: Cource) {
            binding.txtBestCourseTitle.text = course.title
            binding.txtBestCoursePrice.text = course.price
            binding.txtBestCoursePriority.text = course.priority.toString()
            Picasso.get().load(course.Image).placeholder(R.drawable.ic_pending)
                .into(binding.imgAllCourseItemImage)
            val background = binding.relBestCourseItemParent.background
            val wrappedDrawable = DrawableCompat.wrap(background)
            DrawableCompat.setTint(wrappedDrawable, Color.parseColor(course.color))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestCourseViewHolder {
        val binding =
            BestCourseItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return BestCourseViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BestCourseViewHolder, position: Int) {
        val bestCourse = list[position]
        holder.bind(bestCourse)
    }
}
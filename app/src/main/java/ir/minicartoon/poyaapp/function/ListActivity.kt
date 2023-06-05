package ir.minicartoon.poyaapp.function

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.minicartoon.poyaapp.R

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val rv=findViewById<RecyclerView>(R.id.rv_list);
        var list :MutableList<String> = mutableListOf()
        for (i in 1..10) {
            list.add("Item $i")
        }
        rv.layoutManager= LinearLayoutManager(this)
        rv.adapter=ListAdapter(list){
            Toast.makeText(this,"Item $it",Toast.LENGTH_SHORT).show()
        }
    }


}
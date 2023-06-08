package ir.minicartoon.poyaapp.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.minicartoon.poyaapp.R
import ir.minicartoon.poyaapp.databinding.FragmentHomeBinding
import ir.minicartoon.poyaapp.model.User

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding;
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //................inflate View and set ViewModel.............//
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        //..............Start Functions and Code..............................//
        getBestUser()
        getBestCourse()






        return binding.root
    }

    private fun getBestCourse() {
        binding.rvHomeBestCourses.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        //get data from ViewModel
        viewModel.getBestCourse().observe(viewLifecycleOwner) { list -> //set data to adapter
            binding.rvHomeBestCourses.adapter = BestCourseAdapter(list)
        }
    }

    private fun getBestUser() {

        binding.rvHomeBestUsers.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)

        viewModel.getBestUser().observe(viewLifecycleOwner) { list -> //set data to adapter

            binding.rvHomeBestUsers.adapter = BestUserAdapter(list) { //get onclick value

                Toast.makeText(this@HomeFragment.requireActivity(), "onClick: $it", LENGTH_SHORT)
                    .show()
                Log.i("tag", "onClick: $it")
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}
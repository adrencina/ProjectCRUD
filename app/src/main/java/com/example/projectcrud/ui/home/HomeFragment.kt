package com.example.projectcrud.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.projectcrud.R
import com.example.projectcrud.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val productViewModel: HomeViewModel by viewModels()
    private lateinit var productAdapter: ProductAdapter

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //val homeViewModel =
            //ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //val textView: TextView = binding.textHome
        //homeViewModel.text.observe(viewLifecycleOwner) {
            //textView.text = it
        //}
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productViewModel.products.observe(viewLifecycleOwner) { products ->
            when (products) {
                is StateHomeViewModel.Success -> {
                    initRecyclerView(products.info.message ?: listOf())
                }

                is StateHomeViewModel.Error -> {
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Fetch the products from the API
        productViewModel.getProducts()

        }

        // Observe the products from the ViewModel


    private fun initRecyclerView(value: List<String>) {
        val adapter = ProductAdapter(value)
        binding.rvHome.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

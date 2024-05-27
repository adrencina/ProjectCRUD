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
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val productViewModel: HomeViewModel by viewModels()

    //private lateinit var productAdapter: ProductAdapter



    // This property is only valid between onCreateView and
    // onDestroyView.


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

        productViewModel.getProducts()

        val productAdapter = ProductAdapter()
        binding.rvHome.adapter = productAdapter

        productViewModel.products.observe(viewLifecycleOwner) { products ->
            productAdapter.setList(products)
        }

        //productViewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
        //}

        productViewModel.error.observe(viewLifecycleOwner) { error ->
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        }


        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

package com.example.projectcrud.ui.home

import ProductViewModel
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectcrud.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val productViewModel: ProductViewModel by viewModels()
    private lateinit var productAdapter: ProductAdapter
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productAdapter = ProductAdapter(emptyList())
        binding.rvHome.layoutManager = LinearLayoutManager(context)
        binding.rvHome.adapter = productAdapter

        productViewModel.products.observe(viewLifecycleOwner) { products ->
            productAdapter.products = products
            productAdapter.notifyDataSetChanged()
        }

        binding.searchButton.setOnClickListener {
            val query = binding.searchEditText.text.toString()
            productViewModel.searchProducts(query)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


//class HomeFragment : Fragment() {
//
//    private val productViewModel: HomeViewModel by viewModels()
//
//    private lateinit var productAdapter: ProductAdapter
//
//    private var _binding: FragmentHomeBinding? = null
//
//    // This property is only valid between onCreateView and
//    // onDestroyView.
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = FragmentHomeBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        binding.rvHome.layoutManager = LinearLayoutManager(context)
//        productAdapter = ProductAdapter(emptyList())
//        binding.rvHome.adapter = productAdapter
//
//
//        productViewModel.products.observe(viewLifecycleOwner) { products ->
//            when (products) {
//                is StateHomeViewModel.Success -> {
//                    updateRecyclerView(products.products)
//                }
//
//                is StateHomeViewModel.Error -> {
//                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//
//        // Fetch the products from the API
//        productViewModel.getProducts()
//
//        }
//
//
//    private fun updateRecyclerView(products: List<ProductResponse>) {
//        productAdapter.updateProducts(products) // Actualiza los productos en el adapter
//    }
//
////    private fun initRecyclerView(products: List<ProductResponse>) {
////        productAdapter = ProductAdapter(products)
////        binding.rvHome.adapter = productAdapter
////    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//}

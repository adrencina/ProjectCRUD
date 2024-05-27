package com.example.projectcrud.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productViewModel.products.observe(viewLifecycleOwner) { products ->
            when (products) {
                is StateHomeViewModel.Success -> {
                    initRecyclerView(products.products)
                }

                is StateHomeViewModel.Error -> {
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Fetch the products from the API
        productViewModel.getProducts()

        }

    private fun initRecyclerView(products: List<ProductResponse>) {
        productAdapter = ProductAdapter(products)
        binding.rvHome.adapter = productAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

package com.example.projectcrud.ui.add

import ProductViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.projectcrud.model.Product
import com.example.projectcrud.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    private val productViewModel: ProductViewModel by viewModels({ requireActivity() })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val description = binding.descriptionEditText.text.toString()
            val price = binding.priceEditText.text.toString()
            val imageUrl = binding.imageEditText.text.toString()

            if (name.isNotEmpty() && description.isNotEmpty() && price.isNotEmpty() && imageUrl.isNotEmpty()) {
                val newProduct = Product(
                    id = (productViewModel.products.value?.size ?: 0) + 1,
                    name = name,
                    description = description,
                    price = price,
                    images = listOf(imageUrl)
                )
                productViewModel.addProduct(newProduct)
                Toast.makeText(requireContext(), "Producto Agregado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Por favor, ingrese todos los datos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


//
//import ProductViewModel
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Toast
//import androidx.fragment.app.viewModels
//import com.example.projectcrud.databinding.FragmentAddBinding
//import com.example.projectcrud.model.Product
//
//class AddFragment : Fragment() {
//
//    private val productViewModel: ProductViewModel by viewModels()
//    private var _binding: FragmentAddBinding? = null
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = FragmentAddBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        binding.addButton.setOnClickListener {
//            val id = binding.idEditText.text.toString().toInt()
//            val name = binding.nameEditText.text.toString()
//            val price = binding.priceEditText.text.toString().toInt()
//            val description = binding.descriptionEditText.text.toString()
//            val images = listOf(binding.imageEditText.text.toString())
//
//            val newProduct = Product(id, name, price.toString(), description, images)
//            productViewModel.addProduct(newProduct)
//            Toast.makeText(context, "Product added", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//}





//// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"
//
///**
// * A simple [Fragment] subclass.
// * Use the [AddFragment.newInstance] factory method to
// * create an instance of this fragment.
// */
//class AddFragment : Fragment() {
//    private var param1: String? = null
//    private var param2: String? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_add, container, false)
//    }
//
//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment AddFragment.
//         */
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            AddFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
//}
package com.example.projectcrud


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.projectcrud.repository.ProductRepository

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DeleteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DeleteFragment : Fragment() {
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


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout para este fragmento
        val view = inflater.inflate(R.layout.fragment_delete, container, false)

        // Obtener referencias a los elementos de la UI
        val productIdToDeleteEditText: EditText = view.findViewById(R.id.et_id_delete)
        val deleteProductButton: Button = view.findViewById(R.id.btn_delete_product)

        // Configurar el listener para el botón
        deleteProductButton.setOnClickListener {
            val productIdText = productIdToDeleteEditText.text.toString().trim()

            if (productIdText.isNotEmpty()) {
                val productId = productIdText.toIntOrNull()

                if (productId != null) {
                    val success = ProductRepository.deleteProduct(productId)

                    if (success) {
                        Toast.makeText(requireContext(), "Product deleted with ID: $productId", Toast.LENGTH_SHORT).show()
                        productIdToDeleteEditText.text.clear()
                    } else {
                        Toast.makeText(requireContext(), "Product not found", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(requireContext(), "Invalid product ID", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Please enter the product ID", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DeleteFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
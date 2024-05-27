// DeleteFragment.kt
package com.example.myapp
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.projectcrud.ProductRepository
import com.example.projectcrud.R

class DeleteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout para este fragmento
        val view = inflater.inflate(R.layout.fragment_delete_product, container, false)

        // Obtener referencias a los elementos de la UI
        val productNameToDeleteEditText: EditText = view.findViewById(R.id.et_product_name_to_delete)
        val deleteProductButton: Button = view.findViewById(R.id.btn_delete_product)

        // Configurar el listener para el botón
        deleteProductButton.setOnClickListener {
            val productName = productNameToDeleteEditText.text.toString().trim()

            if (productName.isNotEmpty()) {
                val success = ProductRepository.deleteProduct(productName)
                if (success) {
                    Toast.makeText(requireContext(), "Product deleted: $productName", Toast.LENGTH_SHORT).show()
                    productNameToDeleteEditText.text.clear()
                } else {
                    Toast.makeText(requireContext(), "Product not found", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Please enter the product name", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}

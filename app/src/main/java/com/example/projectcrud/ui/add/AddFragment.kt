
package com.example.projectcrud.ui.add
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.projectcrud.R

class AddFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        val productNameEditText: EditText = view.findViewById(R.id.et_product_name)
        val productDescriptionEditText: EditText = view.findViewById(R.id.et_product_description)
        val productPriceEditText: EditText = view.findViewById(R.id.et_product_price)
        val addProductButton: Button = view.findViewById(R.id.btn_add_product)

        addProductButton.setOnClickListener {
            val productName = productNameEditText.text.toString().trim()
            val productDescription = productDescriptionEditText.text.toString().trim()
            val productPrice = productPriceEditText.text.toString().trim()

            if (productName.isNotEmpty() && productDescription.isNotEmpty() && productPrice.isNotEmpty()) {
                Toast.makeText(requireContext(), "Product added: $productName", Toast.LENGTH_SHORT).show()


                productNameEditText.text.clear()
                productDescriptionEditText.text.clear()
                productPriceEditText.text.clear()
            } else {
                Toast.makeText(requireContext(), "Please fill out all fields", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}



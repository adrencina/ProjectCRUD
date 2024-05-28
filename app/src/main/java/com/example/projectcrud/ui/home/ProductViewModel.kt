import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projectcrud.model.Product

class ProductViewModel : ViewModel() {
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    init {
        // Initialize with some default products
        _products.value = listOf(
            Product(
                1, "Product 1", "Description 1", "10.0",
                listOf("https://example.com/image1.jpg")
            ),
            Product(
                2, "Product 2", "Description 2", "20.0",
                listOf("https://example.com/image2.jpg")
            )
        )
    }

    fun searchProducts(query: String) {
        _products.value = _products.value?.filter {
            it.name.contains(query, ignoreCase = true) || it.id.toString() == query
        }
    }

    fun addProduct(product: Product) {
        val currentList = _products.value?.toMutableList() ?: mutableListOf()
        currentList.add(product)
        _products.value = currentList
    }

    fun deleteProduct(productId: Int) {
        _products.value = _products.value?.filter { it.id != productId }
    }
}
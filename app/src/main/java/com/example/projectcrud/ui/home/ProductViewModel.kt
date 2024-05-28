import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projectcrud.model.Product

class ProductViewModel : ViewModel() {
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    init {
        // productos por defecto
        _products.value = listOf(
            Product(
                1, "Classic Comfort Drawstring Joggers", "Experience the perfect blend.", "79",
                listOf("https://i.imgur.com/ZKGofuB.jpeg")
            ),
            Product(
                6, "Classic Comfort Fit Joggers", "Discover the perfect blend of style.", "25",
                listOf("https://i.imgur.com/mp3rUty.jpeg")
            ),
            Product(
                8, "Classic Navy Blue Baseball Cap", "Step out in style with this sleek navy blue baseball cap.", "75",
                listOf("https://i.imgur.com/R3iobJA.jpeg")
            ),
            Product(
                3, "Classic Blue Baseball Cap", "Top off your casual look with our Classic Cap.", "65",
                listOf("https://i.imgur.com/wXuQ7bm.jpeg")
            ),
            Product(
                35, "Classic Red Baseball Cap", "Elevate your casual wardrobe with this timeless red baseball cap.", "95",
                listOf("https://i.imgur.com/cBuLvBi.jpeg")
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
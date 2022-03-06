package iesnervion.macal.mo_practicafinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import iesnervion.macal.mo_practicafinal.adapter.ProductAdapter
import iesnervion.macal.mo_practicafinal.clases.Product
import iesnervion.macal.mo_practicafinal.clases.ProductProvider
import iesnervion.macal.mo_practicafinal.clases.ProductProvider.Companion.productList
import iesnervion.macal.mo_practicafinal.databinding.ActivityMainBinding
import iesnervion.macal.mo_practicafinal.databinding.ActivityProductListBinding
import iesnervion.macal.mo_practicafinal.viewModels.ProductVM
import kotlinx.coroutines.CoroutineScope
import java.util.*

class ProductListActivity : AppCompatActivity(),
    androidx.appcompat.widget.SearchView.OnQueryTextListener {
   companion object{
       const val EXTRA_DETAILS_PRODUCT= "Practica_Android.PRODUCT"
   }
    /*private val productDetailsLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        activityResult->
        onItemSelected()

    }*/
    private lateinit var binding: ActivityProductListBinding
    //private lateinit var recycler_adapter:ProductAdapter

    //private val productViewModel : ProductVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()

        val search=binding.activityProductListSvSearchProduct.setOnQueryTextListener(this)
    }
    fun initRecyclerView(){
        binding.activityProductListRvProductList.layoutManager= LinearLayoutManager(this)
        binding.activityProductListRvProductList.adapter=
            ProductAdapter(ProductProvider.productList) { product ->
                onItemSelected(
                    product
                )
            }
    }
    fun onItemSelected(product: Product){
        //val intent = Intent(this,HelloActivity::class.java) startActivity(intent)
        val intent = Intent(this,ProductDetails::class.java).apply {
            putExtra(EXTRA_DETAILS_PRODUCT,product)
        }
        startActivity(intent)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String): Boolean {
        //recycler_adapter.filtrarProductos(newText)
        //productList.setAdapter(recycler_adapter)
        return false
    }
    fun filtrarProductos(texto: String) {
        if (texto.length === 0) {
            val productListAux : List<Product> = productList
            productList =
                ArrayList(productListAux) //listaProductosAux tiene todos los productos
        } else {
            productList.subList(0,0)
            for (producto in productList) {
                if (producto.name.lowercase(Locale.getDefault()).contains(
                        (texto as CharSequence).toString().lowercase(Locale.getDefault())
                    ) //Dios esta contigo
                    || java.lang.String.valueOf(producto.price)
                        .contains((texto as CharSequence).toString().lowercase(Locale.getDefault()))
                ) {
                    productList=listOf(producto)
                }
            }
        }
    }
    //INTENTOS DE SEARCHVIEW
    /*private fun searchByName(query:String){
        val searchResults = ProductProvider.search(query)
        (binding.activityProductListRvProductList.adapter).submitList(searchResults)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(!query.isNullOrEmpty()){
            searchByName(query.lowercase(Locale.getDefault()))
        }
        return true
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        return true
    }*/


}
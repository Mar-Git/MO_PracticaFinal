package iesnervion.macal.mo_practicafinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.SearchView
import android.widget.Toast
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

class ProductListActivity : AppCompatActivity()/*,SearchView.OnQueryTextListener,
    androidx.appcompat.widget.SearchView.OnQueryTextListener*/ {

    private lateinit var binding: ActivityProductListBinding

    private val productViewModel : ProductVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()

        //binding.activityProductListSvSearchProduct.setOnQueryTextListener(this)
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
    fun onItemSelected(product: Product){
        Toast.makeText(this,product.name, Toast.LENGTH_SHORT).show()
        //ir a otra activity
    }
}
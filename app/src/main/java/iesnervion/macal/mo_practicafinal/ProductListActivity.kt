package iesnervion.macal.mo_practicafinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import iesnervion.macal.mo_practicafinal.adapter.ProductAdapter
import iesnervion.macal.mo_practicafinal.clases.Product
import iesnervion.macal.mo_practicafinal.clases.ProductProvider
import iesnervion.macal.mo_practicafinal.databinding.ActivityMainBinding
import iesnervion.macal.mo_practicafinal.databinding.ActivityProductListBinding

class ProductListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }
    fun initRecyclerView(){
        binding.activityProductListRvProductList.layoutManager= LinearLayoutManager(this)
        binding.activityProductListRvProductList.adapter=ProductAdapter(ProductProvider.productList)

    }
}
package iesnervion.macal.mo_practicafinal

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import iesnervion.macal.mo_practicafinal.adapter.CartAdapter
import iesnervion.macal.mo_practicafinal.adapter.ProductAdapter
import iesnervion.macal.mo_practicafinal.clases.Product
import iesnervion.macal.mo_practicafinal.clases.ProductProvider
import iesnervion.macal.mo_practicafinal.databinding.ActivityCartBinding
import iesnervion.macal.mo_practicafinal.databinding.ActivityProductDetailsBinding

class CartActivity : AppCompatActivity() {

    private lateinit var binding:ActivityCartBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var recycler_adapter: CartAdapter
    private lateinit var productListCart:MutableList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences(ProductListActivity.EXTRA_CART_PRODUCT, Context.MODE_PRIVATE)
        initAdapter()
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.activityCartRcvProductList.layoutManager= LinearLayoutManager(this)
        binding.activityCartRcvProductList.adapter= recycler_adapter
    }

    private fun initAdapter(){
        val bundle = intent.extras
        productListCart = bundle?.getParcelableArrayList("list")!!
        recycler_adapter = CartAdapter(this, productListCart)//Tienes que pasarle el contexto y la lista de productos
    }
}
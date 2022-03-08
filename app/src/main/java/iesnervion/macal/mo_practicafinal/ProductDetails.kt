package iesnervion.macal.mo_practicafinal

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.bumptech.glide.Glide
import iesnervion.macal.mo_practicafinal.adapter.ProductAdapter
import iesnervion.macal.mo_practicafinal.clases.Product
import iesnervion.macal.mo_practicafinal.databinding.ActivityProductDetailsBinding

class ProductDetails : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var recycler_adapter:ProductAdapter

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences(ProductListActivity.EXTRA_DETAILS_PRODUCT, Context.MODE_PRIVATE)
        initializeViews()

        //binding.activityProductDetailsBtnAddCart.setOnClickListener(this)

        val buttonClick = findViewById<ImageButton>(R.id.activity_product_details__btn__continue_cart)
        buttonClick.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }
    }


    private fun initializeViews() {
        Glide.with(binding.productDetailsImgImgProduct.context)
            .load(sharedPreferences.getString("productImage", "None"))
            .into(binding.productDetailsImgImgProduct)
        binding.productDetailsLblNameProduct.text = sharedPreferences.getString("productName", "None")
        binding.productDetailsLblPriceProduct.text = sharedPreferences.getLong("productPrice", 0).toString()
        binding.productDetailsLblCategoryProduct.text = sharedPreferences.getString("productCategory", "None")
        binding.productDetailsLblUnitsProduct.text = sharedPreferences.getInt("productUnits", 0).toString()
    }

}

/*private fun FloatingActionButton.setOnClickListener(productDetails: ProductDetails) {

}*/



package iesnervion.macal.mo_practicafinal

import android.content.Intent
import android.icu.math.BigDecimal.valueOf
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import iesnervion.macal.mo_practicafinal.ProductListActivity.Companion.EXTRA_DETAILS_PRODUCT
import iesnervion.macal.mo_practicafinal.clases.Product
import iesnervion.macal.mo_practicafinal.clases.ProductProvider.Companion.productList
import iesnervion.macal.mo_practicafinal.databinding.ActivityProductDetailsBinding
import iesnervion.macal.mo_practicafinal.databinding.ActivityProductListBinding

class ProductDetails : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding
    private lateinit var product: Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent: Intent = getIntent()
        product = intent.getParcelableExtra(EXTRA_DETAILS_PRODUCT)!!
        Glide.with(binding.productDetailsImgImgProduct.context).load(product.image).into(binding.productDetailsImgImgProduct)
        binding.productDetailsLblNameProduct.setText(product.name)
        binding.productDetailsLblPriceProduct.setText(product.price.toString())
        binding.productDetailsLblCategoryProduct.setText(product.category)
        binding.productDetailsLblUnitsProduct.setText(product.units.toString())

    }

    private fun bindings() {
        //var image=Glide.with(binding.productDetailsImgImgProduct.context).load(product.image).into(binding.productDetailsImgImgProduct)
        var name=binding.productDetailsLblNameProduct
//        var price=binding.productDetailsLblPriceProduct
//        var category=binding.productDetailsLblCategoryProduct
//        var units=binding.productDetailsLblUnitsProduct

        name.setText(product.name)
//        price.setText(product.price.toString())
//        category.setText(product.category)
//        units.setText(product.units)
    }
}



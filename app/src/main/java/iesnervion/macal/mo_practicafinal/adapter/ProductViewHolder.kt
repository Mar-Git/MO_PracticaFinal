package iesnervion.macal.mo_practicafinal.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import iesnervion.macal.mo_practicafinal.R
import iesnervion.macal.mo_practicafinal.clases.Product
import iesnervion.macal.mo_practicafinal.databinding.ItemProductBinding

class ProductViewHolder(view: View):RecyclerView.ViewHolder(view) {

    val binding = ItemProductBinding.bind(view)

    /*val nameProduct = view.findViewById<TextView>(R.id.item_login__lbl__name_producto)
    val priceProduct =view.findViewById<TextView>(R.id.item_login__lbl__price_producto)
    val photo = view.findViewById<ImageView>(R.id.item_login__img__image_product)*/

    fun render(productModel: Product, onclickListener:(Product)->Unit){
        binding.itemLoginLblNameProducto.text=productModel.name
        binding.itemLoginLblPriceProducto.text=productModel.price.toString()
        Glide.with(binding.itemLoginImgImageProduct.context).load(productModel.image).into(binding.itemLoginImgImageProduct)
        itemView.setOnClickListener {
            onclickListener(productModel)
        }
    }
}
package iesnervion.macal.mo_practicafinal.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import iesnervion.macal.mo_practicafinal.R
import iesnervion.macal.mo_practicafinal.clases.Product

class ProductViewHolder(view: View):RecyclerView.ViewHolder(view) {

    val nameProduct = view.findViewById<TextView>(R.id.item_login__lbl__name_producto)
    val priceProduct =view.findViewById<TextView>(R.id.item_login__lbl__price_producto)
    val photo = view.findViewById<ImageView>(R.id.item_login__img__image_product)

    fun render(productModel: Product){
        nameProduct.text=productModel.name
        priceProduct.text=productModel.price.toString()
    }
}
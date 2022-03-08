package iesnervion.macal.mo_practicafinal.adapter

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import iesnervion.macal.mo_practicafinal.R
import iesnervion.macal.mo_practicafinal.clases.Product

class CartAdapter(private val context : Context,
                  private val productList : MutableList<Product>) : RecyclerView.Adapter<CartAdapter.CartAdapterViewHolder>(){


    inner class CartAdapterViewHolder(view : View) : RecyclerView.ViewHolder(view){

        private var name : TextView = view.findViewById(R.id.item_product_cart__lbl__name_producto)
        private var price : TextView = view.findViewById(R.id.item_product_cart__lbl__price_producto)
        private var image : ImageView = view.findViewById(R.id.item_product_cart__img__image_product)

        fun bind(product: Product) {
            name.text = product.name
            price.text = product.price.toString()
            Glide.with(itemView.context)
                .load(product.image)
                .into(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartAdapterViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return CartAdapterViewHolder(layoutInflater.inflate(R.layout.item_product_cart,parent,false))
    }

    override fun onBindViewHolder(holder: CartAdapterViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount(): Int {
        return productList.size
    }

}
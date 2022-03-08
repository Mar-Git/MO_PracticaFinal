package iesnervion.macal.mo_practicafinal.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import iesnervion.macal.mo_practicafinal.R
import iesnervion.macal.mo_practicafinal.clases.Product


class ProductAdapter(
    private var productList:List<Product>,
    private val productListener : ProductListener) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {


    inner class ProductViewHolder(view: View): RecyclerView.ViewHolder(view){

        private var name : TextView = view.findViewById(R.id.item_product__lbl__name_producto)
        private var price : TextView = view.findViewById(R.id.item_product__lbl__price_producto)
        private var image : ImageView = view.findViewById(R.id.item_product__img__image_product)
        private var btnAdd : ImageButton = view.findViewById(R.id.item_product__btn_add_cart)

        fun bind(product : Product){

            name.text = product.name
            price.text = product.price.toString()
            Glide.with(itemView.context)
                .load(product.image)
                .into(image)
            btnAdd.setOnClickListener {
                productListener.onButtonAddCartClicked(product)
                //Toast.makeText(this,"",Toast.LENGTH_SHORT)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return ProductViewHolder(layoutInflater.inflate(R.layout.item_product,parent,false))
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        holder.bind(productList[position])
        holder.itemView.setOnClickListener {
            val currentProduct = productList[holder.adapterPosition]
            productListener.onProductClicked(currentProduct)
        }
    }

    override fun getItemCount(): Int = productList.size //devuelve el tamño del listado

    interface ProductListener{
        fun onProductClicked(product : Product)
        fun onButtonAddCartClicked(product: Product)
    }

    fun setData(productListAux: List<Product>) {
        this.productList = productListAux
        notifyDataSetChanged()
    }


}
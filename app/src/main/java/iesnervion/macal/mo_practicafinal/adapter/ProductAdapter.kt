package iesnervion.macal.mo_practicafinal.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import iesnervion.macal.mo_practicafinal.R
import iesnervion.macal.mo_practicafinal.clases.Product
import java.util.*
import kotlin.collections.ArrayList

class ProductAdapter(/*private val productListAux:List<Product>, */private val productList:List<Product>, private val onclickListener:(Product)->Unit) : RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return ProductViewHolder(layoutInflater.inflate(R.layout.item_product,parent,false))
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = productList[position]
        holder.render(item, onclickListener)
    }

    override fun getItemCount(): Int = productList.size //devuelve el tamño del listado

    /*fun filtrarProductos(texto: String) {
        if (texto.length == 0) {
            productList =
                ArrayList(productListAux) //listaProductosAux tiene todos los productos
        } else {
            productList.clear()
            for (producto in productListAux) {
                if (producto.name.lowercase(Locale.getDefault())
                        .contains((texto as CharSequence).toString().lowercase(Locale.getDefault()))
                    || java.lang.String.valueOf(producto.price)
                        .contains((texto as CharSequence).toString().toLowerCase())
                ) {
                    productList.add(producto)
                }
            }
        }
        recyclerView.setAdapter(AdapterRecyclerViewListProducts(listaProductos))
    }*/
}
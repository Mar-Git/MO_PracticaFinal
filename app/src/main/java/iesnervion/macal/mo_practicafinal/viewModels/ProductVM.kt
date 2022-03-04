package iesnervion.macal.mo_practicafinal.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import iesnervion.macal.mo_practicafinal.clases.Product
import iesnervion.macal.mo_practicafinal.clases.ProductProvider

class ProductVM : ViewModel() {

    val productModel = MutableLiveData<Product>()

    fun getProductVM (position:Int ){
        val currentProduct:Product = ProductProvider.productList.get(position)
        productModel.postValue(currentProduct)
    }
}
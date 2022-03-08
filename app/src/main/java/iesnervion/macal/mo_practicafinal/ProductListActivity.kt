package iesnervion.macal.mo_practicafinal

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import iesnervion.macal.mo_practicafinal.adapter.ProductAdapter
import iesnervion.macal.mo_practicafinal.clases.Product
import iesnervion.macal.mo_practicafinal.clases.ProductProvider.Companion.productList
import iesnervion.macal.mo_practicafinal.databinding.ActivityProductListBinding
import  androidx.appcompat.widget.SearchView
import android.R
import android.os.Parcelable
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import iesnervion.macal.mo_practicafinal.clases.ProductProvider
import iesnervion.macal.mo_practicafinal.clases.ProductProvider.Companion.realizarFiltrado
import java.util.ArrayList


class ProductListActivity : AppCompatActivity(),
    SearchView.OnQueryTextListener, SearchView.OnCloseListener, View.OnClickListener {
   companion object{
       const val EXTRA_DETAILS_PRODUCT= "Practica_Android.PRODUCT"
       const val EXTRA_CART_PRODUCT = "Practica_Android.ADD_CART"
   }

    private val productCartList : MutableList<Product> = mutableListOf()
    private lateinit var binding: ActivityProductListBinding
    private lateinit var recycler_adapter:ProductAdapter
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var sharedPreferencesCart: SharedPreferences
    private lateinit var spnCategories: Spinner
    private lateinit var spnOrder: Spinner
    private var listaCategorias =ProductProvider.generarListaCategorias()
    private var listaOrdenar = ProductProvider.generarListaOrdenar()

    //private val productViewModel : ProductVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        initRecyclerView()

        binding.activityProductListSvSearchProduct.setOnQueryTextListener(this)
        binding.activityProductListSvSearchProduct.setOnCloseListener(this)

        binding.activityProductListBtnCart.setOnClickListener(this)

        sharedPreferences = getSharedPreferences(EXTRA_DETAILS_PRODUCT, Context.MODE_PRIVATE)
        sharedPreferencesCart = getSharedPreferences(EXTRA_CART_PRODUCT, Context.MODE_PRIVATE)

        spnCategories=binding.activityProductListSpnCategories
        spnOrder=binding.activityProductListSpnFilterOrder

        inicializarSpinners()

    }


    private fun inicializarSpinners() {
        val spinCategorias = spnCategories
        val spinOrdenar = spnOrder
        val aa: ArrayAdapter<*> =
            ArrayAdapter<Any?>(this, R.layout.simple_spinner_item, listaCategorias as List<Any?>)
        aa.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        spinCategorias.adapter = aa
        val aa2: ArrayAdapter<*> =
            ArrayAdapter<Any?>(this, R.layout.simple_spinner_item, listaOrdenar)
        aa.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        spinOrdenar.adapter = aa2
        spinCategorias.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View, i: Int, l: Long) {
                filtrarPor(i)
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }
        spinOrdenar.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View, i: Int, l: Long) {
                ordenarPor(i)
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }
    }

    /**
     * Realiza la ordenacion segun la opcion del Spinner
     * @param pos Opcion elegida en el spinner
     */
    private fun ordenarPor(pos: Int) {
        var listaItems = productList

        when (pos) {
            0 -> listaItems
            1 -> ProductProvider.ordenarPrecioMayorMenor(listaItems)
            2 -> ProductProvider.ordenarAlfabeticamenteAZ(listaItems)
        }
        //Tenemos que notificar los cambios al adapter
        recycler_adapter.setData(listaItems)
    }

    /**
     * Realiza los filtrados segun la opcion del Spinner
     * @param pos Opcion elegida en el spinner
     */
    private fun filtrarPor(pos: Int) {
        var listaItems = productList
        when (pos) {
            1 -> listaItems = realizarFiltrado(listaItems, "Higiene")
            2 -> listaItems = realizarFiltrado(listaItems, "Medicamentos")
            3 -> listaItems = realizarFiltrado(listaItems, "Nutricional")
        }
        recycler_adapter.setData(listaItems)
    }

    private fun initAdapter(){
        recycler_adapter = ProductAdapter(productList, object : ProductAdapter.ProductListener{
            override fun onProductClicked(product : Product) {

                sharedPreferences.edit().apply{
                    putString("productName", product.name)
                    putLong("productPrice", product.price.toLong())
                    putString("productCategory", product.category)
                    putInt("productUnits", product.units)
                    putString("productImage", product.image)
                }.apply()

                val intent = Intent(this@ProductListActivity,ProductDetails::class.java)
                startActivity(intent)
            }

            override fun onButtonAddCartClicked(product: Product) {
                productCartList.add(Product(product.name,
                    product.category,
                    product.price,
                    product.units,
                    product.image))
                //Toast.makeText(this,"Añadido!",Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun initRecyclerView(){
        binding.activityProductListRvProductList.layoutManager= LinearLayoutManager(this)
        binding.activityProductListRvProductList.adapter= recycler_adapter
    }


    override fun onQueryTextSubmit(query: String?): Boolean {

        val productListAux : MutableList<Product> = mutableListOf()
        for (product in productList){
            if (query?.let {product.name.toLowerCase().contains(query?.toLowerCase().toString()) } == true){
                productListAux.add(product)
            }
        }
        recycler_adapter.setData(productListAux)

        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return false
    }


    override fun onClose(): Boolean {
        recycler_adapter.setData(productList)
        return true
    }

    override fun onClick(p0: View?) {
        //TODO Hacer aquí la guarda de la lista en el Bundle, se pasa por el intent
        val bundle:Bundle = Bundle()
        bundle.putParcelableArrayList("list",productCartList as ArrayList<out Parcelable>)
        //productCartList
        val intent = Intent(this@ProductListActivity,CartActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)

    }


}
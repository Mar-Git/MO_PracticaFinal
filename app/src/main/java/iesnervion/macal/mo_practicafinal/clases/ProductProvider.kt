package iesnervion.macal.mo_practicafinal.clases

import java.util.*
import kotlin.collections.ArrayList

class ProductProvider {
    companion object{
        var productList = listOf<Product>(
            Product(
                "Paracetamol 1 g",
                "Medicamentos",
                4.6,
                69,
                "https://s3-eu-west-3.amazonaws.com/retxo-farmacia/presentaciones/imagen_cajas/000/056/255/original/658257.png?1549446133"
            ),
            Product(
                    "Ibuprofeno 600mg",
                "Medicamentos",
                5.8,
                102,
            "http://www.aepsal.com/wp-content/uploads/2017/03/Ibuprofeno-e1489614454904.png"
            ),
            Product(
                "Multicentrum",
                "Nutricional",
                7.2,
                45,
                "https://www.farmaciauniversal24h.com/parafarmacia/1136-large_default/multicentrum-30-comp.jpg"
            ),
            Product(
                "Eucerin crema de manos",
                "Higiene",
                10.3,
                88,
                "https://www.farmaciagranviavalencia.es/1220-large_default/eucerin-hyaluron-filler-peeling-serum-noche-30-ml.jpg"
            ),
            Product(
                "Normodorm 25 mg",
                "Medicamentos",
                5.1,
                30,
                "https://farmatorre.com/pics/contenido/normodor-445x0.png"
            ),
            Product(
                "Oraldine enjuague bucal",
                "Higiene",
                1.75,
                57,
                "https://dhb3yazwboecu.cloudfront.net/439/oraldine-clasico-farmaconfianza_l.png"
            ),
            Product(
                "Potito Hero fruta",
                "Nutricional",
                1.95,
                78,
                "https://www.supertambo.es/web/tambo/img/productos/677/hero_frutas_235_24.jpg"
            ),
            Product(
                "Hierro 14 mg",
                "Nutricional",
                11.95,
                99,
                "https://m.media-amazon.com/images/I/71DDLYXdcPL._AC_SL1500_.jpg"
            ),
            Product(
                "Voltadol Forte",
                "Medicamentos",
                4.95,
                40,
                "https://oferfarma.com/wp-content/uploads/2021/01/voltadol-forte-gel-topico-100g.jpg"
            )
        )

        fun generarListaCategorias(): ArrayList<String> {
            val lista: ArrayList<String> = ArrayList()
            lista.add("Filtrar por")
            lista.add("Higiene")
            lista.add("Medicamentos")
            lista.add("Nutricional")
            return lista
        }

        fun generarListaOrdenar(): List<String> {
            val lista: MutableList<String> = mutableListOf()
            lista.add("Ordenar por")
            lista.add("Precio")
            lista.add("Nombre")
            return lista
        }

        fun realizarFiltrado(lista: List<Product>, filtro: String): List<Product> {
            val listaProductos: MutableList<Product> = mutableListOf()
            for (i in 0 until lista.size) {
                if (lista[i].category.contains(filtro)) {
                    listaProductos.add(lista[i])
                }
            }
            return listaProductos
        }

        /**
         * Ordena la lista segun el precio de mayor a menor
         * @param lista lista a ordenar
         */
        fun ordenarPrecioMayorMenor(lista: List<Product>) {
            Collections.sort(lista) { o1, o2 ->
                var resultado = 0
                if (o1.price> o2.price) {
                    resultado = -1
                } else if (o1.price < o2.price) {
                    resultado = 1
                }
                resultado
            }
        }

        /**
         * la lista alfabeticamente de la a-Z
         * @param lista lista a ordenar.
         */
        fun ordenarAlfabeticamenteAZ(lista: List<Product>) {
            Collections.sort(lista) { o1, o2 -> o1.name.compareTo(o2.name) }
        }
    }
}
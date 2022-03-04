package iesnervion.macal.mo_practicafinal.clases

class ProductProvider {
    companion object{
        val productList = listOf<Product>(
            Product(
                "Paracetamol 1 g",
                "Medicamentos",
                4.6,
                "https://s3-eu-west-3.amazonaws.com/retxo-farmacia/presentaciones/imagen_cajas/000/056/255/original/658257.png?1549446133"
            ),
            Product(
                    "Ibuprofeno 600mg",
                "Medicamentos",
                5.8,
            "http://www.aepsal.com/wp-content/uploads/2017/03/Ibuprofeno-e1489614454904.png"
            ),
            Product(
                "Multicentrum, complemento alimenticio",
                "Nutricional",
                7.2,
                "https://www.farmaciauniversal24h.com/parafarmacia/1136-large_default/multicentrum-30-comp.jpg"
            ),
            Product(
                "Eucerin crema de manos",
                "Higiene",
                10.3,
                "https://www.farmaciagranviavalencia.es/1220-large_default/eucerin-hyaluron-filler-peeling-serum-noche-30-ml.jpg"
            ),
            Product(
                "Normodorm 25 mg",
                "Medicamentos",
                5.1,
                "https://farmatorre.com/pics/contenido/normodor-445x0.png"
            ),
            Product(
                "Oraldine enjuague bucal",
                "Higiene",
                1.75,
                "https://dhb3yazwboecu.cloudfront.net/439/oraldine-clasico-farmaconfianza_l.png"
            ),
            Product(
                "Potito Hero fruta variada",
                "Nutricional",
                1.95,
                "https://www.supertambo.es/web/tambo/img/productos/677/hero_frutas_235_24.jpg"
            ),
            Product(
                "Hierro 14 mg",
                "Nutricional",
                11.95,
                "https://m.media-amazon.com/images/I/71DDLYXdcPL._AC_SL1500_.jpg"
            ),
            Product(
                "Voltadol Forte",
                "Medicamentos",
                4.95,
                "https://oferfarma.com/wp-content/uploads/2021/01/voltadol-forte-gel-topico-100g.jpg"
            )
        )

        /*fun getAll(): List<Product> = productList

        fun search(query: String): List<Product> {
            if (query.isBlank())
                return emptyList()
            return productList.filter { expense ->
                val regex = query.toRegex(RegexOption.IGNORE_CASE)
                regex.containsMatchIn(expense.name)
            }
        }*/
    }
}
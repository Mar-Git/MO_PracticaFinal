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
                "https://cienzoo.com/wp-content/uploads/2020/03/51fc70Y37SL.jpg"
            ),
            Product(
                "Eucerin crema de manos",
                "Higiene",
                10.3,
                "https://www.kindpng.com/picc/m/266-2668506_eucerin-hd-png-download.png"
            ),
            Product(
                "Normodorm 25 mg",
                "Medicamentos",
                5.1,
                "https://farmaciadelcruce.com/110-large_default/normodorm-25-mg-14-comprimidos-recubiertos.jpg"
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
                "https://media.simplysupplements.es/biblioteca/new_tub/hierro-14mg.jpg?2019-08-06"
            ),
            Product(
                "Compresas post-parto",
                "Higiene",
                5.95,
                "https://www.castrofarmacias.com/media/catalog/product/cache/edf7b936402ad2210b32c215604fc9c6/i/n/indasec_compresas_post_parto_algodon_puro_primeros_dias_hipoalergenicas.jpg"
            ),
            Product(
                "Voltadol Forte",
                "Medicamentos",
                4.95,
                "https://oferfarma.com/wp-content/uploads/2021/01/voltadol-forte-gel-topico-100g.jpg"
            )
        )
    }
}
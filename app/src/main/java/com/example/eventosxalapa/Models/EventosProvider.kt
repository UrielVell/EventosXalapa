package com.example.eventosxalapa.Models

class EventosProvider {
    companion object {
        val listaHoy = listOf<Evento>(
            Evento("Festival de la Salsa",
                "01/11/2023",
                "Evento de baile y musica de salsa",
                "Ayuntamiento",
                "https://picsum.photos/id/21/130/130",
                "$60"),
            Evento("Festival del Pambaso",
                "01/11/2023",
                "Festival donde se conmemora este platillo veracruzano tipico",
                "Ayuntamiento",
                "https://picsum.photos/id/23/130/130",
                "Gratis")
        )

        val listaSemana = listOf<Evento>(
            Evento("Festival de la Salsa",
                "01/11/2023",
                "Evento de baile y musica de salsa",
                "Ayuntamiento",
                "https://picsum.photos/id/21/130/130",
                "$60"),
            Evento("Festival del Pambaso",
                "01/11/2023",
                "Festival donde se conmemora este platillo veracruzano tipico",
                "Ayuntamiento",
                "https://picsum.photos/id/23/130/130",
                "Gratis"),
            Evento("Recorrido Cerro de Macuilteptl",
                "06/11/2023",
                "Recorrido por todo el cerro de macuilteptl",
                "Admiistracion del Cerro de Macuilteptl",
                "https://fastly.picsum.photos/id/786/130/130",
                "$30")
        )

        val listaMes = listOf<Evento>(
            Evento("Festival de la Salsa",
                "01/11/2023",
                "Evento de baile y musica de salsa",
                "Ayuntamiento",
                "https://picsum.photos/id/21/130/130",
                "$60"),
            Evento("Festival del Pambaso",
                "01/11/2023",
                "Festival donde se conmemora este platillo veracruzano tipico",
                "Ayuntamiento",
                "https://picsum.photos/id/23/130/130",
                "Gratis"),
            Evento("Recorrido Cerro de Macuilteptl",
                "06/11/2023",
                "Recorrido por todo el cerro de macuilteptl",
                "Admiistracion del Cerro de Macuilteptl",
                "https://fastly.picsum.photos/id/786/130/130",
                "$30"),
            Evento("Aniversario del Ayuntamiento de Xalapa",
                "23/11/2023",
                "celebracion del aniversario del ayuntamiento de xalapa",
                "Ayuntamiento",
                "https://fastly.picsum.photos/id/828/130/130",
                "Gratis")
        )
    }
}
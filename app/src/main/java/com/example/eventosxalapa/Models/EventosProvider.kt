package com.example.eventosxalapa.Models

class EventosProvider {
    companion object{
        val eventos= listOf<ClassEvento>(
            ClassEvento("Evento1", "2023-01-01", "Descripción del Evento 1", "Organizador1", "https://picsum.photos/id/1/130/130"),
            ClassEvento("Evento2", "2023-02-15", "Descripción del Evento 2", "Organizador2", "https://picsum.photos/id/2/130/130"),
            ClassEvento("Evento3", "2023-03-30", "Descripción del Evento 3", "Organizador3", "https://picsum.photos/id/3/130/130"),
            ClassEvento("Evento4", "2023-04-10", "Descripción del Evento 4", "Organizador4", "https://picsum.photos/id/4/130/130"),
            ClassEvento("Evento5", "2023-05-20", "Descripción del Evento 5", "Organizador5", "https://picsum.photos/id/5/130/130")
        )
    }
}
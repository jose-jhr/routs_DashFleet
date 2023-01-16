package com.ingenieria.rutasdashfleet.fragments.model

import com.ingenieria.rutasdashfleet.fragments.RoutesContract.RoutesContract
import com.ingenieria.rutasdashfleet.fragments.customlist.RouteViewModel

/**
 * simulate petitions to server
 */
class DataRoutesModel{

    fun getDataRoutes(responseCallback:RoutesContract.RoutesInteractor) {

        val items = ArrayList<RoutesResponse>()

        items.add(RoutesResponse("0","Ruta 1","Ruta one","10 km"))
        items.add(RoutesResponse("1","Ruta 2","Ruta two","20 km"))
        items.add(RoutesResponse("2","Ruta 3","Ruta three","30 km"))
        items.add(RoutesResponse("3","Ruta 4","Ruta four","40 km"))

        responseCallback.onResponse(items)


    }


}
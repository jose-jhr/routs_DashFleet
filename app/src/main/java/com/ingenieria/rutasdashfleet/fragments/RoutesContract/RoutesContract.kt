package com.ingenieria.rutasdashfleet.fragments.RoutesContract

import com.ingenieria.rutasdashfleet.fragments.AdapterListRoutes
import com.ingenieria.rutasdashfleet.fragments.customlist.RouteViewModel
import com.ingenieria.rutasdashfleet.fragments.model.RoutesResponse
import java.net.URL

interface RoutesContract {

    interface View {
        fun showRoutes(adapter: AdapterListRoutes)
        fun loadingRoutes()
        fun errorRoutes()
        fun hideLoadingRoutes()
    }

    interface presenter {
        fun getRoutes()
    }

    interface RoutesInteractor {
        fun onResponse(routesItems:ArrayList<RoutesResponse>)
    }



}
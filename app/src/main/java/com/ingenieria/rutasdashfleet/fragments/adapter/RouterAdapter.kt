package com.ingenieria.rutasdashfleet.fragments.adapter

import com.ingenieria.rutasdashfleet.fragments.customlist.RouteViewModel
import com.ingenieria.rutasdashfleet.fragments.model.RoutesResponse

/**
 * adapter for the list of routes
 */
class RouterAdapter() {

    fun getRouteViewModel(userResponse: RoutesResponse): RouteViewModel {
        return RouteViewModel(userResponse.header_rout,userResponse.name_route,userResponse.distance)
    }

}
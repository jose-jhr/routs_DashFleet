package com.ingenieria.rutasdashfleet.fragments

import android.app.Activity
import android.content.Context
import androidx.lifecycle.LiveData
import com.ingenieria.rutasdashfleet.fragments.RoutesContract.RoutesContract
import com.ingenieria.rutasdashfleet.fragments.adapter.RouterAdapter
import com.ingenieria.rutasdashfleet.fragments.customlist.RouteViewModel
import com.ingenieria.rutasdashfleet.fragments.model.DataRoutesModel
import com.ingenieria.rutasdashfleet.fragments.model.RoutesResponse

/**
 * interface for the fragment to communicate with the activity
 */
class AdapterPresenter(val context: Activity, val routesContract: RoutesContract.View):RoutesContract.presenter{

    val dataRoutesServer = DataRoutesModel()

    override fun getRoutes() {
        routesContract.loadingRoutes()
        dataRoutesServer.getDataRoutes(object : RoutesContract.RoutesInteractor{
            override fun onResponse(routesItems: ArrayList<RoutesResponse>) {
                val arrayListRouterAdapter = ArrayList<RouteViewModel>()
                for (routes in routesItems){
                    arrayListRouterAdapter.add(RouterAdapter().getRouteViewModel(routes))
                }
                val adapterListView = AdapterListRoutes(context, arrayListRouterAdapter)
                routesContract.showRoutes(adapterListView)
            }

        })

    }


}
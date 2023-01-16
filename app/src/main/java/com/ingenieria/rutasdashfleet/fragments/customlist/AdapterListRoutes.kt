package com.ingenieria.rutasdashfleet.fragments

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.ingenieria.rutasdashfleet.R
import com.ingenieria.rutasdashfleet.fragments.adapter.RouterAdapter
import com.ingenieria.rutasdashfleet.fragments.customlist.RouteViewModel
import kotlinx.android.synthetic.main.model_routes_view.view.*

class AdapterListRoutes(private val context: Activity,private val routesElements:ArrayList<RouteViewModel>)
    :ArrayAdapter<RouteViewModel>(context, R.layout.model_routes_view,routesElements) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.model_routes_view, null, true)

        rowView.txt_headerRoute.text = routesElements[position].header_route
        rowView.txt_nameRoute.text = routesElements[position].name_route
        rowView.txt_distanceRoute.text = routesElements[position].distance

        return rowView

    }






}
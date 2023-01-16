package com.ingenieria.rutasdashfleet.fragments

import android.app.Activity
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.Fragment
import com.ingenieria.rutasdashfleet.R
import com.ingenieria.rutasdashfleet.fragments.RoutesContract.RoutesContract
import com.ingenieria.rutasdashfleet.fragments.customview.ExpandableCustomListView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class RoutesFragment : Fragment() {

    lateinit var presenteRoutes : AdapterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView =  inflater.inflate(R.layout.fragment_routes, container, false)

        val listViewRoute = rootView.findViewById<ListView>(R.id.listViewRoutes)





        presenteRoutes = AdapterPresenter(context as Activity,object :RoutesContract.View{
            override fun showRoutes(adapter: AdapterListRoutes) {
                listViewRoute.adapter = adapter

            }

            override fun loadingRoutes() {

            }

            override fun errorRoutes() {

            }

            override fun hideLoadingRoutes() {

            }

        })

        presenteRoutes.getRoutes()

        return rootView
    }





}
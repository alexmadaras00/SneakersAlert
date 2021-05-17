package com.example.sneakersalert.ui

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sneakersalert.Adapters.AdapterJordan
import com.example.sneakersalert.DataClasses.NewShoe
import com.example.sneakersalert.DataClasses.Spec
import com.example.sneakersalert.Global
import com.example.sneakersalert.R
import kotlinx.android.synthetic.main.fragment_airmax1.*

class Airmax1Fragment : Fragment(R.layout.fragment_airmax1), AdapterView.OnItemSelectedListener {

    val a = ArrayList<NewShoe>()
    val sp = ArrayList<Spec>()
    val adapter = AdapterJordan(a, object : AdapterJordan.OnClickListener {
        override fun onItemClick(position: Int) {
            Global.price = a[position].price!!
            Global.name = a[position].name
            Global.model = a[position].model
            Global.sizes = a[position].sizes
            Global.pic = a[position].image!!
            Global.sp = a[position].spec
            view?.findNavController()?.navigate(R.id.action_nav_airmax1_to_buyingProducts)
        }

    })

    override fun onCreate(savedInstanceState: Bundle?) {
        sp.add(Spec(R.drawable.shield, "Anti-pollution, anti-dust"))
        sp.add(Spec(R.drawable.crossing, "Reusable"))
        sp.add(Spec(R.drawable.happy_face, "Pleated at sides for extra comfort"))
        sp.add(Spec(R.drawable.sun, "Wider face coverage for maximum \n" + "protection"))
        a.add(
            NewShoe(
                R.drawable.air_max_1_have_a_nikeday, "Nike Air Max 1", "Have A Nike Day", 149, "",
                arrayListOf(39, 40, 41), sp
            )
        )
        a.add(
            NewShoe(
                R.drawable.limeade, "Nike Air Max 1", "Limeade", 209, "",
                arrayListOf(39, 40, 41), arrayListOf(
                    Spec(R.drawable.shield, "Anti-pollution, anti-dust"),
                    Spec(R.drawable.crossing, "Reusable"),
                    Spec(R.drawable.happy_face, "Pleated at sides for extra comfort"),
                    Spec(
                        R.drawable.sun, "Wider face coverage for maximum \n" +
                                "protection "
                    )
                )
            )
        )
        a.add(
            NewShoe(
                R.drawable.limeade2, "Nike Air Max 1", "Limeade", 289, "",
                arrayListOf(39, 40), arrayListOf(
                    Spec(R.drawable.shield, "Anti-pollution, anti-dust"),
                    Spec(R.drawable.crossing, "Reusable"),
                    Spec(R.drawable.happy_face, "Pleated at sides for extra comfort"),
                    Spec(
                        R.drawable.sun, "Wider face coverage for maximum \n" +
                                "protection "
                    )
                )
            )
        )
        super.onCreate(savedInstanceState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (!isAdded) {
            return
        }
        val spinner: Spinner = view.findViewById(R.id.spinner2)
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.planets_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
        spinner.onItemSelectedListener = this
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewAirmax1)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.isNestedScrollingEnabled = true
        val adapter = AdapterJordan(a, object : AdapterJordan.OnClickListener {
            override fun onItemClick(position: Int) {
                Global.price = a[position].price!!
                Global.name = a[position].name
                Global.model = a[position].model
                Global.sizes = a[position].sizes
                Global.pic = a[position].image!!
                Global.sp = a[position].spec
                Global.infoText = a[position].text
                view.findNavController().navigate(R.id.buyingProducts)
            }

        })
        recyclerView.adapter = adapter
        if (recyclerView.itemDecorationCount == 0) {
            println("Empty")
        }
        println(a.size)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (position == 0)
            sortbyRecommended()
        if (position == 1)
            sortbyNew()
        if (position == 2)
            sortbySelling()
        if (position == 3)
            sortbyHighLow()
        if (position == 4)
            sortbyLowHigh()


        val adapter = AdapterJordan(a, object : AdapterJordan.OnClickListener {
            override fun onItemClick(position: Int) {
                Global.price = a[position].price!!
                Global.name = a[position].name
                Global.model = a[position].model
                Global.sizes = a[position].sizes
                Global.pic = a[position].image!!
                Global.sp = a[position].spec
                Global.infoText = a[position].text
                view?.findNavController()?.navigate(R.id.buyingProducts)
            }

        })
        recyclerViewAirmax1.adapter = adapter
        adapter.notifyDataSetChanged()

    }

    private fun sortbySelling() {

    }

    private fun sortbyNew() {
        a.reverse()
        val adapter = AdapterJordan(a, object : AdapterJordan.OnClickListener {
            override fun onItemClick(position: Int) {
                Global.price = a[position].price!!
                Global.name = a[position].name
                Global.model = a[position].model
                Global.sizes = a[position].sizes
                Global.pic = a[position].image!!
                Global.sp = a[position].spec
                Global.infoText = a[position].text
                view?.findNavController()?.navigate(R.id.buyingProducts)
            }

        })
        recyclerViewAirmax1?.adapter = adapter
        adapter.notifyDataSetChanged()

    }

    private fun sortbyRecommended() {

    }

    private fun sortbyHighLow() {
        a.sortByDescending { it.price }
        val adapter = AdapterJordan(a, object : AdapterJordan.OnClickListener {
            override fun onItemClick(position: Int) {
                Global.price = a[position].price!!
                Global.name = a[position].name
                Global.model = a[position].model
                Global.sizes = a[position].sizes
                Global.pic = a[position].image!!
                Global.sp = a[position].spec
                Global.infoText = a[position].text
                view?.findNavController()?.navigate(R.id.buyingProducts)
            }

        })
        recyclerViewAirmax1?.adapter = adapter
        this.adapter.notifyDataSetChanged()

    }

    private fun sortbyLowHigh() {
        a.sortWith(nullsLast(compareBy { it.price }))

        val adapter = AdapterJordan(a, object : AdapterJordan.OnClickListener {
            override fun onItemClick(position: Int) {
                Global.price = a[position].price!!
                Global.name = a[position].name
                Global.model = a[position].model
                Global.sizes = a[position].sizes
                Global.pic = a[position].image!!
                Global.sp = a[position].spec
                Global.infoText = a[position].text
                view?.findNavController()?.navigate(R.id.buyingProducts)
            }

        })
        recyclerViewAirmax1?.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }
}
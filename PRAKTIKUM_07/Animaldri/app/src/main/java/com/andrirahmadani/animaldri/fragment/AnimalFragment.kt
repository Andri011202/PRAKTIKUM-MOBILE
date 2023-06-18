package com.andrirahmadani.animaldri.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andrirahmadani.animaldri.HewanAdapter
import com.andrirahmadani.animaldri.R
import com.andrirahmadani.animaldri.listHewan

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AnimalFragment : Fragment() {
    private lateinit var adapter: HewanAdapter
    private lateinit var recycleView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animal, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val grid = GridLayoutManager(context, 2)
        recycleView = view.findViewById(R.id.list_hewan_view)
        recycleView.layoutManager = grid
//        recycleView.hasFixedSize(true)
        adapter = HewanAdapter(listHewan)
        recycleView.adapter = adapter
    }
}
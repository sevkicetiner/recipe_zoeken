package com.example.receptzoeken.ui.fragments.zoeken


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.receptzoeken.R
import com.example.receptzoeken.ui.activities.detail.DetailActivity


/**
 * A simple [Fragment] subclass.
 */
class ZoekenFragment : Fragment() {

    lateinit var recyclerZoek:RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_zoeken, container, false)
        val viewmodel = ViewModelProviders.of(this).get(ZoekViewModel::class.java)
        recyclerZoek = view.findViewById(R.id.zoek_tv)
        view.findViewById<EditText>(R.id.search_edit).setOnEditorActionListener { v, actionId, event ->

            if (actionId == EditorInfo.IME_ACTION_SEARCH){
                viewmodel.SearchRecipes(v.text.toString())
                val imm: InputMethodManager? =
                    requireActivity().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager?
                imm?.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
                 true
            }
            false
        }

        viewmodel.mutableList.observe(this, Observer {
            recyclerZoek.adapter = ZoekRecyclerAdapter(it, ZoekRecyclerAdapter.ZoekItemListener{

                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra("id", it.id)
                    context?.startActivity(intent)

            })
        })

        return view
    }
}

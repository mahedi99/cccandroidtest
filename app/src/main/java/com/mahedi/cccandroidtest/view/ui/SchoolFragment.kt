package com.mahedi.cccandroidtest.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.mahedi.cccandroidtest.R
import com.mahedi.cccandroidtest.service.model.Estimate
import com.mahedi.cccandroidtest.view.factory.SchoolViewModelFactory
import com.mahedi.cccandroidtest.viewmodel.SchoolViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 * Use the [SchoolFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SchoolFragment : Fragment() {


    private lateinit var contactTV: TextView
    private lateinit var createdByTV: TextView
    private lateinit var revisionTV: TextView
    private lateinit var requesterTV: TextView
    private lateinit var createdTV: TextView
    private lateinit var estNumberTV: TextView
    private lateinit var schoolNameTV: TextView
    private lateinit var addressTV: TextView
    private lateinit var viewModel: SchoolViewModel
    private lateinit var viewModelFactory: SchoolViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModelFactory = SchoolViewModelFactory(requireActivity().application, "c574b0b4-bdef-4b92-a8f0-608a86ccf5ab")
        viewModel = ViewModelProvider(this, viewModelFactory).get(SchoolViewModel::class.java)
        return inflater.inflate(R.layout.fragment_school, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenCreated {
            initView(view);
        }

        viewModel.result.observe(viewLifecycleOwner, Observer { data ->
            lifecycleScope.launch(Dispatchers.Default){
                updateUI(data)
            }
        })
    }

    private fun updateUI(estimate: Estimate) {
        schoolNameTV.text = estimate.company
        addressTV.text = estimate.address
        estNumberTV.text = estimate.number.toString()
        createdTV.text = estimate.created_date
        requesterTV.text = estimate.requested_by
        revisionTV.text = estimate.revision_number.toString()
        createdByTV.text = estimate.created_by
        contactTV.text = estimate.contact
    }

    private fun initView(view: View){
        schoolNameTV = view.findViewById(R.id.school_name_TV)
        addressTV = view.findViewById(R.id.address_TV)
        estNumberTV = view.findViewById(R.id.est_number_TV)
        createdTV = view.findViewById(R.id.created_TV)
        requesterTV = view.findViewById(R.id.requester_TV)
        revisionTV = view.findViewById(R.id.revision_TV)
        createdByTV = view.findViewById(R.id.created_by_TV)
        contactTV = view.findViewById(R.id.contact_TV)
    }
}
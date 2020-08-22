package com.example.testapplication.fragment.workers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testapplication.R
import com.example.testapplication.fragment.specialty.SpecialtyFragment
import com.example.testapplication.fragment.workers.adapter.WorkersAdapter
import com.example.testapplication.fragment.workers.viewmodel.WorkersViewModel
import kotlinx.android.synthetic.main.fragment_workers.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class WorkersFragment : Fragment() {
    private lateinit var workersAdapter: WorkersAdapter
    private val workersViewModel: WorkersViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_workers, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFragmentView()
        initViewModel()
    }

    private fun initFragmentView() {
        workersAdapter = WorkersAdapter(mutableListOf()) { specialty ->

            val specialtyFragment = SpecialtyFragment.newInstance(specialty)
            val fragment = activity?.supportFragmentManager?.beginTransaction()
            fragment?.replace(R.id.rootFragment, specialtyFragment)
            fragment?.addToBackStack(null)
            fragment?.commit()
        }
        rvWorkers.adapter = workersAdapter
    }

    private fun initViewModel() {
        workersViewModel.getWorkersListDataDb.observe(viewLifecycleOwner, {
            workersAdapter.updateList(it)
        })
    }
}
package com.example.testapplication.fragment.specialty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.entity.localmodels.WorkersInfo
import com.example.testapplication.R
import com.example.testapplication.utils.calculateAge
import com.example.testapplication.utils.convertDateFormat
import kotlinx.android.synthetic.main.fragment_specialty.*


class SpecialtyFragment : Fragment() {

    private var workersInfo: WorkersInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            workersInfo = it.getParcelable(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_specialty, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFragmentView()
    }

    private fun initFragmentView() {
        vFirstName.text = workersInfo?.firstName?.toLowerCase()?.capitalize()
        vLastName.text = workersInfo?.lastName?.toLowerCase()?.capitalize()
        workersInfo?.birthday?.run {
            val rawDate = convertDateFormat(this)
            vDateOfBirth.text = if (rawDate.isBlank())
                getString(R.string.birthday_place_holder)
            else
                String.format(getString(R.string.birthday), rawDate)
        }

        vAge.text = String.format(
            getString(R.string.age),
            calculateAge(workersInfo?.birthday)
        )
        workersInfo?.avatarUrl?.apply {
            Glide.with(requireContext())
                .load(this)
                .into(vAvatarLogo)
        }
        workersInfo?.specialtyDb?.run {
            rvSpeciality.adapter = SpecialyAdapter(this)
        }

    }

    companion object {
        private const val ARG_PARAM1 = "param1"

        @JvmStatic
        fun newInstance(param1: WorkersInfo) =
            SpecialtyFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, param1)
                }
            }
    }
}
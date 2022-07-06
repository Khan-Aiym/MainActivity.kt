package com.example.homework8to3mouthkt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.homework8to3mouthkt.databinding.FragmentBlankBinding
import com.example.homework8to3mouthkt.ui.dashboard.DashboardModel
import com.example.homework8to3mouthkt.ui.home.HomeModel

class BlankFragment : Fragment() {
    private lateinit var binding: FragmentBlankBinding
    private lateinit var model: DashboardModel
    private lateinit var homeModel: HomeModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {
            if (requireArguments().getSerializable(KEY_DASHBOARD) != null) {
                model = requireArguments().getSerializable(KEY_DASHBOARD) as DashboardModel
                setData(model)
            }
            if (requireArguments().getSerializable("Afrika_key") != null) {
                homeModel = requireArguments().getSerializable("Afrika_key") as HomeModel
                setData(homeModel)
            }
        }
    }

    private fun setData(dashboardModel: DashboardModel) {
        binding.tvName.text = dashboardModel.tvName
        binding.tvStatus.text = dashboardModel.tvStatus
        Glide.with(requireContext()).load(dashboardModel.ivInteger)
            .into(binding.ivCharacter)
    }

    private fun setData(homeModel: HomeModel) {
        binding.tvStatus.text = homeModel.tvLocation
        binding.tvName.text = homeModel.tvNameLocation
        Glide.with(requireContext()).load(homeModel.ivLocation)
            .into(binding.ivCharacter)
    }

    companion object {
        const val KEY_DASHBOARD = "model_key"
    }
}
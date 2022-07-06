package com.example.homework8to3mouthkt.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import com.example.homework8to3mouthkt.BlankFragment
import com.example.homework8to3mouthkt.R
import com.example.homework8to3mouthkt.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private lateinit var binding: FragmentDashboardBinding
    private lateinit var dashboardAdapter: DashboardAdapter
    private val list: ArrayList<DashboardModel> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?,
    ): View {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        initRecycler()
        initListener()
    }

    private fun initRecycler() {
        dashboardAdapter = DashboardAdapter(list)
        binding.recDashboard.adapter = dashboardAdapter
    }

    private fun initListener() {
        dashboardAdapter.onClickListener = {
            Toast.makeText(activity, "Click $it", Toast.LENGTH_LONG).show()
            val info = dashboardAdapter.getItem(it)
            val bundle = Bundle()
            bundle.putSerializable(BlankFragment.KEY_DASHBOARD, info)
            val controller = findNavController(requireActivity(), R.id.nav_host_fragment_activity_main)
            controller.navigate(R.id.blankFragment, bundle)
        }
    }

    private fun loadData() {
        list.add(DashboardModel("Alive", "Rick Sanchez", R.drawable.img))
        list.add(DashboardModel("Alive", "Morty Smith", R.drawable.img_1))
        list.add(DashboardModel("Dead", "Albert Einstein", R.drawable.img_2))
        list.add(DashboardModel("Alive", "Jerry Smith", R.drawable.img_3))
    }
}
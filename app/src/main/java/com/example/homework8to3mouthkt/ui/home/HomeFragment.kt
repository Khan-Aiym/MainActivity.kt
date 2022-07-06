package com.example.homework8to3mouthkt.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import com.example.homework8to3mouthkt.OnClickItem
import com.example.homework8to3mouthkt.R
import com.example.homework8to3mouthkt.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), OnClickItem {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeAdapter: HomeAdapter
    private val list: ArrayList<HomeModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        homeAdapter = HomeAdapter(list, this)
        binding.rvHome.adapter = homeAdapter
    }

    private fun loadData() {
        list.add(HomeModel(R.drawable.img_4, "Cluster", "Abadango"))
        list.add(HomeModel(R.drawable.img_4, "Planet", "Earth (C-137)"))
        list.add(HomeModel(R.drawable.img_4, "Planet", "Worldender's lair"))
        list.add(HomeModel(R.drawable.img_4, "Space station", "Citadel of Ticks"))
        list.add(HomeModel(R.drawable.img_4, "TV", "Interdimensional Cable"))
        list.add(HomeModel(R.drawable.img_4, "Microverse", "Anatomy Park"))
        list.add(HomeModel(R.drawable.img_4, "Planet", "Post-Apocalyptic"))
        list.add(HomeModel(R.drawable.img_4, "Resort", "Immortality Field Resort"))
        list.add(HomeModel(R.drawable.img_4, "Planet", "Venzenulon 7"))
        list.add(HomeModel(R.drawable.img_4, "Planet", "Purge Planet"))
        list.add(HomeModel(R.drawable.img_4, "Planet", "Cronenberg Earth"))
        list.add(HomeModel(R.drawable.img_4, "Planet", "Bepis 9"))
        list.add(HomeModel(R.drawable.img_4, "Fantasy town", "Giant's Town"))
        list.add(HomeModel(R.drawable.img_4, "Planet", "Nuptia 4"))
        list.add(HomeModel(R.drawable.img_4, "Space station", "St. Gloopy Noops Hospital"))
        list.add(HomeModel(R.drawable.img_4, "Planet", "Bird World"))
        list.add(HomeModel(R.drawable.img_4, "Dream", "Mr. Goldenfold's dream"))
        list.add(HomeModel(R.drawable.img_4, "Planet", "Earth (5-126)"))
        list.add(HomeModel(R.drawable.img_4, "Planet", "Earth (Rpl. Dimension"))
        list.add(HomeModel(R.drawable.img_4, "Planet", "Gromflom Prime"))
    }

    override fun onClick(pos: Int) {
        val model: HomeModel = homeAdapter.getItem(pos)
        Toast.makeText(activity, "Click$pos", Toast.LENGTH_SHORT).show()
        val bundle = Bundle()
        bundle.putSerializable("Afrika_key", model)
        val controller = findNavController(requireActivity(), R.id.nav_host_fragment_activity_main)
        controller.navigate(R.id.blankFragment, bundle)
    }
}
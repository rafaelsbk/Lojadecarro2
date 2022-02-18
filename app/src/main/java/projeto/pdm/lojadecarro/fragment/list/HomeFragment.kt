package projeto.pdm.lojadecarro.fragment.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.view.*
import projeto.pdm.lojadecarro.R
import projeto.pdm.lojadecarro.data.CarroViewModel
import projeto.pdm.lojadecarro.databinding.FragmentHomeBinding
import projeto.pdm.lojadecarro.repository.CarroRemoteRepository
import projeto.pdm.lojadecarro.viweModel.CarroRemoteViewModel
import projeto.pdm.lojadecarro.viweModel.MainViewModelFactory


class HomeFragment : Fragment() {

    private lateinit var mCarroViewModel: CarroViewModel
    private lateinit var viewModelRemote: CarroRemoteViewModel
    lateinit var binding: FragmentHomeBinding

 override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
     binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        //recycler
        val adapter = ListAdapter()
        val recyclerView = binding.recyclerView
     binding.recyclerView.adapter = adapter
     binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())


     //CarroViewModel
     mCarroViewModel = ViewModelProvider(this).get(CarroViewModel::class.java)
     mCarroViewModel.readAllData.observe(viewLifecycleOwner, Observer {carro ->
        // adapter.setData(carro)
     })

     //CarroViewModelRemote
     val repository = CarroRemoteRepository()
     val viewModelFactory = MainViewModelFactory(repository)
     viewModelRemote = ViewModelProvider(this, viewModelFactory).get(CarroRemoteViewModel::class.java)

     viewModelRemote.getCarro()
     viewModelRemote.myResponse.observe(viewLifecycleOwner, Observer {
       adapter.setData(it)
     })


        binding.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_addCarro)
        }

           // val view2 = inflater.inflate(R.layout.fragment_home, container, false)

           binding.floatingActionButton2.setOnClickListener{
                findNavController().navigate(R.id.action_homeFragment_to_sobre)
        }

     return binding.root

    }
}
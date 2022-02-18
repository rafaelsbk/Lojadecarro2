package projeto.pdm.lojadecarro.fragment.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_addcarro.*
import kotlinx.android.synthetic.main.fragment_addcarro.view.*
import projeto.pdm.lojadecarro.R
import projeto.pdm.lojadecarro.data.Carro
import projeto.pdm.lojadecarro.data.CarroViewModel

class AddCarFragment : Fragment() {

        private lateinit var mCarViewModel: CarroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_addcarro, container, false)

        mCarViewModel = ViewModelProvider (this).get(CarroViewModel::class.java)
        view.addbtn.setOnClickListener{
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {
        val carMarca = addMarca.text.toString()
        val modelo = addModelo.text.toString()
        val tipo = addTipo.text.toString()
        val cor = addCor.text.toString()
        val anoAdd = addAno.text.toString()

        if (inputCheck(carMarca,modelo,cor)){
            val carro = Carro(0, carMarca, modelo, tipo, cor, 0)
            mCarViewModel.addCar(carro)
            Toast.makeText(requireContext(), "Cadastrado com Sucesso!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addCarro_to_homeFragment)
        } else  {
            Toast.makeText(requireContext(), "Preencha todos os campos.", Toast.LENGTH_LONG).show()
       }
    }

    private fun inputCheck(carMarca: String, carModelo: String, carCor: String): Boolean{
        return !(TextUtils.isEmpty(carMarca) && TextUtils.isEmpty(carModelo) && TextUtils.isEmpty(carCor))
    }

}
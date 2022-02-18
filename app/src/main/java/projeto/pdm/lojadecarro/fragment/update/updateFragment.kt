package projeto.pdm.lojadecarro.fragment.update

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*
import projeto.pdm.lojadecarro.R
import projeto.pdm.lojadecarro.data.Carro
import projeto.pdm.lojadecarro.data.CarroViewModel


class updateFragment : Fragment() {

    private val args by navArgs<updateFragmentArgs>()
    private lateinit var mCarroViewModel: CarroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        mCarroViewModel = ViewModelProvider(this).get(CarroViewModel::class.java)

        view.editMarca.setText(args.currentCar.marca)
        view.editModelo.setText(args.currentCar.modelo)
        view.editAno.setText(args.currentCar.ano.toString())
        view.editCor.setText(args.currentCar.cor)
        view.editTipo.setText(args.currentCar.tipoCar)

        view.editbtn.setOnClickListener {
        editarCarro()
        }
        return view
    }
        private fun editarCarro(){
            val marcaEdit = editMarca.text.toString()
            val modeloEdit = editModelo.text.toString()
            val tipoEdit = editTipo.text.toString()
            val corEdit = editCor.text.toString()
            val anoEdit = Integer.parseInt(editAno.text.toString())

            if(inputCheck(marcaEdit,modeloEdit, corEdit)){
                val editarCarro = Carro(args.currentCar.id, marcaEdit,modeloEdit,tipoEdit,corEdit,anoEdit)
                mCarroViewModel.updateCarro(editarCarro)
                Toast.makeText(requireContext(), "Edicao completa", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_homeFragment_to_updateFragment)
            }else {
                Toast.makeText(requireContext(), "Complete os campos necessarios", Toast.LENGTH_SHORT).show()
            }
        }

    private fun inputCheck (carMarca: String, modelo: String, corCarro: String): Boolean{
        return !(TextUtils.isEmpty(carMarca)&& TextUtils.isEmpty(modelo) && TextUtils.isEmpty(corCarro))
    }

}
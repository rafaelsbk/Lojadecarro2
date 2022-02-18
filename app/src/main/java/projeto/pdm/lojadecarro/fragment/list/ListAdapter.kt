package projeto.pdm.lojadecarro.fragment.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custom_row.view.*
import kotlinx.android.synthetic.main.fragment_addcarro.view.*

import projeto.pdm.lojadecarro.R
import projeto.pdm.lojadecarro.data.Carro

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var carList = emptyList<Carro>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = carList[position]
        holder.itemView.idtxt.text = currentItem.id.toString()
        holder.itemView.marcatxt.text = currentItem.marca
        holder.itemView.modelotxt.text = currentItem.modelo
        //holder.itemView.addTipo.text = currentItem.tipoCar
        holder.itemView.cortxt.text = currentItem.cor
        //holder.itemView.addAno.text = currentItem.ano.toString()

        holder.itemView.carrolista.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
}


    override fun getItemCount(): Int {
        return carList.size
    }
    fun setData(carro: List<Carro>){
        this.carList = carro
        notifyDataSetChanged()
    }
}




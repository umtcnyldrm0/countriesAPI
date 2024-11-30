package adapter

import adapter.FirstFragmentDirections
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.pulsetech.myapplication.FirstFragment
import com.pulsetech.myapplication.R
import model.Country
import adapter.FirstFragmentDirections as FirstFragmentDirections1

class countryAdapter(val countryList: ArrayList<Country>) :
    RecyclerView.Adapter<countryAdapter.countryViewHolder>() {


    class countryViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewRegion: TextView = itemView.findViewById(R.id.textViewRegion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): countryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return countryViewHolder(view)

    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: countryViewHolder, position: Int) {

        val country = countryList[position]
        holder.textViewName.text = country.countryName
        holder.textViewRegion.text = country.countryRegion

        holder.view.setOnClickListener{
            val navController = Navigation.findNavController(it)
            navController.navigate(R.id.action_firstFragment_to_secondFragment)

        }


    }

    fun updateCountryList(newCountryList: List<Country>) {
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }
}

class FirstFragmentDirections {

}

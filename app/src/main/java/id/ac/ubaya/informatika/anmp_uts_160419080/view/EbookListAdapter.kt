package id.ac.ubaya.informatika.anmp_uts_160419080.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.anmp_uts_160419080.R
import id.ac.ubaya.informatika.anmp_uts_160419080.model.Ebook
import id.ac.ubaya.informatika.anmp_uts_160419080.util.loadImage
import kotlinx.android.synthetic.main.ebook_list_item.view.*

class EbookListAdapter(val ebookList:ArrayList<Ebook>):RecyclerView.Adapter<EbookListAdapter.EbookViewHolder>() {
    class EbookViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    fun updateEbookList(newEbookList: List<Ebook>) {
        ebookList.clear()
        ebookList.addAll(newEbookList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EbookViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.ebook_list_item, parent, false)

        return EbookViewHolder(v)
    }

    override fun onBindViewHolder(holder: EbookViewHolder, position: Int) {
        holder.view.txtType.text = ebookList[position].type
        holder.view.txtTitle.text = ebookList[position].title
        holder.view.txtAuthor.text = ebookList[position].author
        holder.view.imgCoverList.loadImage(ebookList[position].cover.toString(), holder.view.progressBar)

        holder.view.cardView.setOnClickListener {
            val ebookID = ebookList[position].id
            val action = EbookListFragmentDirections.actionEbookDetail(ebookID.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return ebookList.size
    }
}
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
import kotlinx.android.synthetic.main.journal_list_item.view.*

class JournalListAdapter(val journalList:ArrayList<Ebook>):RecyclerView.Adapter<JournalListAdapter.JournalViewHolder>() {
    class JournalViewHolder(val view: View):RecyclerView.ViewHolder(view)

    fun updateJournalList(newJournalList:List<Ebook>){
        journalList.clear()
        journalList.addAll(newJournalList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JournalViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.journal_list_item, parent,false)

        return JournalViewHolder(v)
    }

    override fun onBindViewHolder(holder: JournalViewHolder, position: Int) {
        holder.view.txtTypeJ.text = journalList[position].type
        holder.view.txtTitleJ.text = journalList[position].title
        holder.view.txtAuthorJ.text = journalList[position].author
        holder.view.imgCoverListJ.loadImage(journalList[position].cover.toString(), holder.view.progressBarJ)

        holder.view.cardViewJ.setOnClickListener {
            val journalID = journalList[position].id
            val action = JournalListFragmentDirections.actionJournalDetail(journalID.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return journalList.size
    }
}
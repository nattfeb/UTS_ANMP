package id.ac.ubaya.informatika.anmp_uts_160419080.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ubaya.informatika.anmp_uts_160419080.R
import id.ac.ubaya.informatika.anmp_uts_160419080.viewmodel.ListViewModelJ
import kotlinx.android.synthetic.main.fragment_ebook_list.*
import kotlinx.android.synthetic.main.fragment_journal_list.*

class JournalListFragment : Fragment() {
    private lateinit var viewModel: ListViewModelJ
    private val journalListAAdapter = JournalListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_journal_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListViewModelJ::class.java)
        viewModel.refresh()

        recViewJ.layoutManager = LinearLayoutManager(context)
        recViewJ.adapter = journalListAAdapter

        refreshLayoutJ.setOnRefreshListener {
            recViewJ.visibility = View.GONE
            txtErrorJ.visibility = View.GONE
            progressLoadJ.visibility  = View.VISIBLE
            viewModel.refresh()
            refreshLayoutJ.isRefreshing = false
        }

        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.journalsLD.observe(viewLifecycleOwner, Observer{
            journalListAAdapter.updateJournalList(it)
        })

        viewModel.loadingErrorLD.observe(viewLifecycleOwner, Observer {
            txtErrorJ.visibility = if(it) View.VISIBLE else View.GONE
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it) {
                progressLoadJ.visibility = View.VISIBLE
                recViewJ.visibility = View.GONE
            }else{
                progressLoadJ.visibility = View.GONE
                recViewJ.visibility = View.VISIBLE
            }
        })
    }

}
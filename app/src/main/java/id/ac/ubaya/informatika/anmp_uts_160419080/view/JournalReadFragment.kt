package id.ac.ubaya.informatika.anmp_uts_160419080.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.ac.ubaya.informatika.anmp_uts_160419080.R
import id.ac.ubaya.informatika.anmp_uts_160419080.viewmodel.DetailViewModel
import id.ac.ubaya.informatika.anmp_uts_160419080.viewmodel.DetailViewModelJ
import kotlinx.android.synthetic.main.fragment_ebook_read.*
import kotlinx.android.synthetic.main.fragment_journal_read.*

class JournalReadFragment : Fragment() {
    private lateinit var viewModel: DetailViewModelJ

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_journal_read, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val journalID = JournalDetailFragmentArgs.fromBundle(requireArguments()).journalID

        viewModel = ViewModelProvider(this).get(DetailViewModelJ::class.java)
        viewModel.fetch(journalID)

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.journalLD.observe(viewLifecycleOwner, Observer {
            txtChapterJ.setText(it.chapter)
        })
    }

}
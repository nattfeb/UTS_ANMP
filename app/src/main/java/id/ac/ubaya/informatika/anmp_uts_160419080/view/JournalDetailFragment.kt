package id.ac.ubaya.informatika.anmp_uts_160419080.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.anmp_uts_160419080.R
import id.ac.ubaya.informatika.anmp_uts_160419080.util.loadImage
import id.ac.ubaya.informatika.anmp_uts_160419080.viewmodel.DetailViewModelJ
import kotlinx.android.synthetic.main.fragment_ebook_detail.*
import kotlinx.android.synthetic.main.fragment_journal_detail.*

class JournalDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModelJ

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_journal_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ejournalID = JournalDetailFragmentArgs.fromBundle(requireArguments()).journalID

        viewModel = ViewModelProvider(this).get(DetailViewModelJ::class.java)
        viewModel.fetch(ejournalID)

        btnReadJ.setOnClickListener {
            val action = JournalDetailFragmentDirections.actionJournalRead(ejournalID)
            Navigation.findNavController(it).navigate(action)
        }

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.journalLD.observe(viewLifecycleOwner, Observer {
            txtGenreJ.setText(it.genre)
            txtTitleDJ.setText(it.title)
            txtAuthorDJ.setText(it.author)
            txtDescJ.setText(it.description)
            txtOPDJ.setText(it.opd)
            txtPPYJ.setText(it.ppy)
            txtDOIJ.setText(it.doi)
            txtSubjectsJ.setText(it.subjects)
            imgCoverDetailJ.loadImage(it.cover.toString(), progressBarDetailJ)
        })
    }
}
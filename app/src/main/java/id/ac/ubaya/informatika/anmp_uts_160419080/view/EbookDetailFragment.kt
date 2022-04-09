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
import id.ac.ubaya.informatika.anmp_uts_160419080.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_ebook_detail.*


class EbookDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ebook_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ebookID = EbookDetailFragmentArgs.fromBundle(requireArguments()).ebookID

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(ebookID)

        observeViewModel()

        btnRead.setOnClickListener {
            val action = EbookDetailFragmentDirections.actionEbookRead(ebookID)
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun observeViewModel() {
        viewModel.ebookLD.observe(viewLifecycleOwner, Observer {
            txtGenre.setText(it.genre)
            txtTitleD.setText(it.title)
            txtAuthorD.setText(it.author)
            txtDesc.setText(it.description)
            txtPublisher.setText(it.publisher)
            txtOPD.setText(it.opd)
            txtPPY.setText(it.ppy)
            txtISBN.setText(it.isbn)
            txtDOI.setText(it.doi)
            txtSubjects.setText(it.subjects)
            imgCoverDetail.loadImage(it.cover.toString(), progressBarDetail)
        })
    }
}
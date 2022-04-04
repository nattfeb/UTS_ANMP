package id.ac.ubaya.informatika.anmp_uts_160419080.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.ac.ubaya.informatika.anmp_uts_160419080.R
import id.ac.ubaya.informatika.anmp_uts_160419080.util.loadImage
import id.ac.ubaya.informatika.anmp_uts_160419080.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_ebook_detail.*
import kotlinx.android.synthetic.main.fragment_ebook_read.*

class EbookReadFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ebook_read, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ebookID = EbookDetailFragmentArgs.fromBundle(requireArguments()).ebookID

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(ebookID)

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.ebookLD.observe(viewLifecycleOwner, Observer {
            txtChapter.setText(it.chapter)
        })
    }

}
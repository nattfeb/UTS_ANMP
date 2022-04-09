package id.ac.ubaya.informatika.anmp_uts_160419080.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import id.ac.ubaya.informatika.anmp_uts_160419080.model.Ebook

class DetailViewModelJ(application: Application): AndroidViewModel(application) {
    val journalLD = MutableLiveData<Ebook>()

    private var TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun fetch(journalID : String) {
        queue = Volley.newRequestQueue(getApplication())
        var url = "https://ubaya.fun/flutter/160419080/ANMP/ejournal.php?id=$journalID"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val result = Gson().fromJson<Ebook>(response, Ebook::class.java)
                journalLD.value = result

                Log.d("showvoley", response.toString())
            },
            {
                Log.d("showvoley", it.toString())
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

}
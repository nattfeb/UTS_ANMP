package id.ac.ubaya.informatika.anmp_uts_160419080.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.ac.ubaya.informatika.anmp_uts_160419080.model.Ebook

class ListViewModelJ(application: Application):AndroidViewModel(application) {
    val journalsLD = MutableLiveData<List<Ebook>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    private var TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun refresh() {
        loadingErrorLD.value = false
        loadingLD.value=true

        queue = Volley.newRequestQueue(getApplication())
        var url = "https://ubaya.fun/flutter/160419080/ANMP/ejournal.php"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val sType = object : TypeToken<List<Ebook>>(){}.type
                val result = Gson().fromJson<List<Ebook>>(response, sType)
                journalsLD.value = result

                loadingLD.value = false
                Log.d("showvoley", response.toString())
            },
            {
                Log.d("showvoley", it.toString())
                loadingErrorLD.value = true
                loadingLD.value = false
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)

    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}
package com.ik.navigationjetpack

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.ik.navigationjetpack.utils.ListItemDecorations
import com.ik.navigationjetpack.adapters.MyAdapter
import com.ik.navigationjetpack.models.MovieResponse
import com.ik.navigationjetpack.models.Movies
import com.ik.navigationjetpack.api.APIClient
import com.ik.navigationjetpack.api.ApiInterface
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {
    val TAG: String = MainActivity::class.java.simpleName
    val API_KEY: String = "ed81768d096e6a89562ad629f5722ef9"

    lateinit var myCustomAdapter: MyAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(ListItemDecorations(20))
        recyclerView.setHasFixedSize(true)

                if (API_KEY.isEmpty()) {
                    context!!.toast("Please obtain your API KEY first from www.themoviedb.org")
                    return
                }

        progressBar.visibility = View.VISIBLE

        var apiServices = APIClient.client.create(ApiInterface::class.java)

        val call = apiServices.getTopRatedMovies(API_KEY)

        call.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {

                var listOfMovies: List<Movies> = response.body()?.results!!
                myCustomAdapter = MyAdapter(context!!, listOfMovies)
                recyclerView.setAdapter(myCustomAdapter)
                progressBar.visibility = View.GONE
            }


            override fun onFailure(call: Call<MovieResponse>?, t: Throwable?) {
                progressBar.visibility = View.GONE
                Log.e(TAG, t.toString())
            }
        })
    }


    }


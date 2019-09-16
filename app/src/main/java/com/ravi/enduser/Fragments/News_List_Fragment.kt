package com.ravi.enduser.Fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ravi.enduser.R
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.ravi.enduser.Adapter.RssItemsAdapter
import com.ravi.enduser.Interfaces.RssService
import kotlinx.android.synthetic.main.fragment_rss.*
import me.toptas.rssconverter.RssConverterFactory
import me.toptas.rssconverter.RssFeed
import me.toptas.rssconverter.RssItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


/**
 * A simple [Fragment] subclass.
 */
class News_List_Fragment : Fragment(), SwipeRefreshLayout.OnRefreshListener, RssItemsAdapter.OnItemClickListener {
    var recyclerView: RecyclerView? = null

    private var feedUrl: String? = null
    private lateinit var mAdapter: RssItemsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        feedUrl = arguments?.getString(KEY_FEED)


    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var v:View= inflater.inflate(R.layout.fragment_rss, container, false)

    return v
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         recyclerView=view.findViewById(R.id.recyclerView)
        mAdapter = RssItemsAdapter(this)
        recyclerView!!.setLayoutManager(LinearLayoutManager(activity))
        recyclerView!!.adapter = mAdapter
        swRefresh.setOnRefreshListener(this)

        fetchRss()
    }

    /**
     * Fetches Rss Feed Url
     */
    private fun fetchRss() {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://github.com")
                .addConverterFactory(RssConverterFactory.create())
                .build()

        showLoading()
        val service = retrofit.create(RssService::class.java)

        feedUrl?.apply {
            service.getRss(this)
                    .enqueue(object : Callback<RssFeed> {
                        override fun onResponse(call: Call<RssFeed>, response: Response<RssFeed>) {
                            if(response.body()!=RssFeed(items=null)){
                            Log.d("responce_recycler",response.body().toString()+"Ravi")
                                onRssItemsLoaded(response.body()!!.items!!)
                            hideLoading()}
                            else{
                                Toast.makeText(activity, "Please Try again", Toast.LENGTH_SHORT).show()
                                hideLoading()
                            }
                        }

                        override fun onFailure(call: Call<RssFeed>, t: Throwable) {
                            Toast.makeText(activity, "Failed to fetchRss RSS feed!", Toast.LENGTH_SHORT).show()
                            hideLoading()
                        }
                    })
        }
    }

    /**
     * Loads fetched [RssItem] list to RecyclerView
     * @param rssItems
     */
    fun onRssItemsLoaded(rssItems: List<RssItem>) {
        mAdapter.setItems(rssItems)
        mAdapter.notifyDataSetChanged()
        if (recyclerView!!.visibility != View.VISIBLE) {
            recyclerView!!.visibility = View.VISIBLE
        }
    }

    /**
     * Shows [SwipeRefreshLayout]
     */
    private fun showLoading() {
        swRefresh.isRefreshing = true
    }


    /**
     * Hides [SwipeRefreshLayout]
     */
    fun hideLoading() {
        swRefresh.isRefreshing = false
    }


    /**
     * Triggers on [SwipeRefreshLayout] refresh
     */
    override fun onRefresh() {
        fetchRss()
    }

    /**
     * Browse [RssItem] url
     * @param rssItem
     */
    override fun onItemSelected(rssItem: RssItem) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(rssItem.link))
        startActivity(intent)
    }

    companion object {
        private const val KEY_FEED = "FEED"

        /**
         * Creates new instance of [RssFragment]
         * @param feedUrl Fetched Url Feed
         * @return Fragment
         */
        fun newInstance(feedUrl: String): News_List_Fragment {
            val rssFragment = News_List_Fragment()
            val bundle = Bundle()
            bundle.putSerializable(KEY_FEED, feedUrl)
            rssFragment.arguments = bundle
            return rssFragment
        }
    }

}
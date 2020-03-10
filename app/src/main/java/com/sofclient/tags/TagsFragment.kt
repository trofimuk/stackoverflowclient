package com.sofclient.tags

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.navOptions
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.data.tags.Tag
import com.example.domain.tags.TagsEntity
import com.sofclient.R
import com.sofclient.adapters.TagsPagedAdapter
import com.sofclient.base.BaseFragment
import com.sofclient.holders.TagHolder
import com.sofclient.tags.datasoutce.TagsDataSourceFactory
import kotlinx.android.synthetic.main.tags_fragment.*

class TagsFragment : BaseFragment(), TagsPagedAdapter.OnItemClickListener {

    private lateinit var tagsViewModel: TagsViewModel

    private lateinit var tagsAdapter: TagsPagedAdapter

    override fun getLayoutId() = R.layout.tags_fragment

    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initViewModel() {
        tagsViewModel = ViewModelProvider(this).get(TagsViewModel::class.java)
    }

    private fun initTagsAdapter(){
        rcvTags.layoutManager = LinearLayoutManager(activity)
        tagsAdapter = TagsPagedAdapter(this)
        rcvTags.adapter = tagsAdapter
    }

    override fun setListeners() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initUi() {
        navController = Navigation.findNavController(activity!!, R.id.container)

        initViewModel()
        initTagsAdapter()
        populateTagsAdapter()
        //setListeners()
    }

    private fun populateTagsAdapter(){
        tagsViewModel.tagsListLiveData
            .observe(this, Observer<PagedList<Tag>> {
                tagsAdapter.submitList(it)
            })
    }

    override fun onItemClick(position: Int) {
        val bundle = Bundle()
        bundle.putString(TAG_NAME_VALUE, tagsAdapter.currentList?.get(position)?.name)

        navController.navigate(
            R.id.questionsFragment, bundle, navOptions { this.launchSingleTop = true })
    }

    companion object{
        const val TAG_NAME_VALUE = "tag_name"
    }
}
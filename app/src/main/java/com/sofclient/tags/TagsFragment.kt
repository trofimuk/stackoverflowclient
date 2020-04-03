package com.sofclient.tags

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.navOptions
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.data.tags.Tag
import com.example.data.utils.StorageUtils
import com.sofclient.R
import com.sofclient.adapters.TagsPagedAdapter
import com.sofclient.base.BaseFragment
import kotlinx.android.synthetic.main.tags_fragment.*
import org.koin.android.ext.android.inject

class TagsFragment : BaseFragment(), TagsPagedAdapter.OnItemClickListener {

    private val storage: StorageUtils by inject()

    private lateinit var tagsViewModel: TagsViewModel

    private lateinit var tagsAdapter: TagsPagedAdapter

    override fun getLayoutId() = R.layout.tags_fragment

    private lateinit var navController: NavController

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

        if(isAirplaneModeOn(activity!!)){
            displayAirPlaneError(getString(R.string.text_error_airplane_mode))
        }else{
            populateTagsAdapter()
        }
        //setListeners()
    }

    private fun populateTagsAdapter(){
        tagsViewModel.tagsListLiveData
            .observe(this, Observer<PagedList<Tag>> {
                tagsAdapter.submitList(it)
            })
    }

    override fun onItemClick(position: Int) {
        if(isAirplaneModeOn(activity!!)){
            displayAirPlaneError(getString(R.string.text_error_airplane_mode))
        }else{
            storage.saveTagName(tagsAdapter.currentList?.get(position)?.name!!)
            navController.navigate(
                R.id.questionsFragment, null, navOptions { this.launchSingleTop = true })
        }
    }
}
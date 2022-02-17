package com.crystal.githubusersearch

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.crystal.githubusersearch.Model.User
import com.crystal.githubusersearch.databinding.FragmentLocalBinding

class LocalFragment : Fragment(R.layout.fragment_local){
    private var binding: FragmentLocalBinding? = null
    private lateinit var listAdapter: UserListAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragmentHomeBinding= FragmentLocalBinding.bind(view)
        binding = fragmentHomeBinding
        listAdapter = UserListAdapter()
        binding?.apply{
            localRecyclerView.layoutManager = LinearLayoutManager(context)
            localRecyclerView.adapter = listAdapter
        }

        updateData()
    }

    private fun updateData() {
//        저장한 데이터 들 가져와서 UserList 로 만들어서 넣기
        listAdapter.submitList(listOf(User("", "11111")))
    }
}
package com.ecommerce.practiceproject.view

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.util.Log

import android.view.ViewGroup

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.ecommerce.practiceproject.R
import com.ecommerce.practiceproject.adapter.UserListAdapter
import com.ecommerce.practiceproject.config.ViewModelFactory
import com.ecommerce.practiceproject.databinding.LayoutFragmentOneBinding
import com.ecommerce.practiceproject.model.UserRepository
import com.ecommerce.practiceproject.view_model.FragmentViewModel
import layout.ViewUtils


/**
 * Date 9/19/2021.
 * Created by Md Atik Faysal(Android Developer)
 *
 */
class FragmentOne : Fragment() {

    private lateinit var binding : LayoutFragmentOneBinding
    private lateinit var viewModel : FragmentViewModel

    @Nullable
    override fun onCreateView(@NonNull inflater: LayoutInflater, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.layout_fragment_one, container, false)
        viewModel = ViewModelProviders.of(this, ViewModelFactory(UserRepository())).get(FragmentViewModel::class.java)
        val view =  binding.root
        binding.lifecycleOwner = this
        binding.userList = viewModel

        binding.btnAddNewUser.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fragmentOne_to_fragmentTwo)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getUserList()
        viewModel.getUserList()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.job.cancel()
    }

    private fun getUserList()
    {
        viewModel.mlUserList.observe(viewLifecycleOwner,{
            Log.d("userListSize","${it.size}")
            if(it.size > 0)
            {
                val adapter = UserListAdapter(requireContext(), it)
                ViewUtils.verticalRecyclerView(requireContext(), binding.rvList).adapter = adapter
                adapter.notifyDataSetChanged()
            }
        })
    }
}
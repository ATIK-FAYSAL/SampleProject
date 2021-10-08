package com.ecommerce.practiceproject.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.ecommerce.practiceproject.R
import com.ecommerce.practiceproject.config.ViewModelFactory
import com.ecommerce.practiceproject.databinding.LayoutFragmentOneBinding
import com.ecommerce.practiceproject.databinding.LayoutFragmentTwoBinding
import com.ecommerce.practiceproject.model.UserRepository
import com.ecommerce.practiceproject.view_model.FragmentViewModel

/**
 * Date 9/19/2021.
 * Created by Md Atik Faysal(Android Developer)
 *
 */
class FragmentTwo: Fragment() {

    private lateinit var binding : LayoutFragmentTwoBinding
    private lateinit var viewModel : FragmentViewModel

    @Nullable
    override fun onCreateView(@NonNull inflater: LayoutInflater, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.layout_fragment_two, container, false)
        viewModel = ViewModelProviders.of(this, ViewModelFactory(UserRepository())).get(FragmentViewModel::class.java)
        val view =  binding.root
        binding.lifecycleOwner = this
        binding.addUser = viewModel
        initialization()

        return view
    }

    private fun initialization()
    {
        viewModel.mlIsUserAdded.observe(viewLifecycleOwner, {
            if(it)
                Log.i("isDataEntry","Data Entered")
            else Log.i("isDataEntry","Failed to add data")
        })

        binding.btnSave.setOnClickListener{
            if(setErrorMsgForInvalidData())
                viewModel.addUser()
        }
    }

    private fun setErrorMsgForInvalidData() : Boolean
    {
        when(viewModel.dataValidation())
        {
            1->{
                binding.etFullName.error = "Invalid Name"
                binding.etFullName.requestFocus()
                return false
            }

            2->{
                binding.etAddress.error = "Invalid Address"
                binding.etAddress.requestFocus()
                return false
            }

            3->{
                binding.etEmail.error = "Invalid Email"
                binding.etEmail.requestFocus()
                return false
            }

            4->{
                binding.etPhone.error = "Invalid Phone"
                binding.etPhone.requestFocus()
                return false
            }
        }

        return true
    }
}
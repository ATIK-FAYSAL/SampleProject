package com.ecommerce.practiceproject.config

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ecommerce.practiceproject.model.UserRepository
import com.ecommerce.practiceproject.view_model.FragmentViewModel

class ViewModelFactory(private val repository: UserRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(FragmentViewModel::class.java)) {
            return FragmentViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}
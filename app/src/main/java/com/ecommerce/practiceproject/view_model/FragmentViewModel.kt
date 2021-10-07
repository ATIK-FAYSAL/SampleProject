package com.ecommerce.practiceproject.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ecommerce.practiceproject.model.UserRepository
import kotlinx.coroutines.launch

class FragmentViewModel(repository : UserRepository) : ViewModel()
{
    fun getUserList()
    {
        viewModelScope.launch {

        }
    }

}
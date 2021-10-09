package com.ecommerce.practiceproject.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ecommerce.practiceproject.database.entities.UserEntities
import com.ecommerce.practiceproject.model.UserRepository
import com.ecommerce.practiceproject.utils.isEmptyString
import com.ecommerce.practiceproject.utils.phoneNumberValidation
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class FragmentViewModel( private  val repository : UserRepository) : ViewModel(), CoroutineScope
{
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    lateinit var job: Job

    init {
        job = Job()
    }

    //private val repository = UserRepository()
    var mlFullName = MutableLiveData<String>()
    var mlPhone = MutableLiveData<String>()
    var mlEmail = MutableLiveData<String>()
    var mlAddress = MutableLiveData<String>()

    var mlIsUserAdded = MutableLiveData<Boolean>()

    var mlUserList = MutableLiveData<ArrayList<UserEntities>>()

    /**
     * ...validation of required data
     * ...Full name must be valid, empty name is not allowed
     * ...phone number must be start with country code +88 or 0
     * ...and number length must be 11 or 14
     * ...email, postal address must not be empty
     * ...when all data are valid then return 0 otherwise return error code
     */
    fun dataValidation() : Int
    {
        if(!mlFullName.value.toString().isEmptyString())
            return 1

        if(!mlAddress.value.toString().isEmptyString())
            return 2

        if(!mlEmail.value.toString().isEmptyString())
            return 3

        if(!mlPhone.value.toString().phoneNumberValidation())
            return 4

        return 0
    }

    /**
     * ...add new user
     * ...save data on room db
     */
    fun addUser()
    {
        val user = UserEntities()

        user.fullName = mlFullName.value.toString()
        user.address = mlAddress.value.toString()
        user.email = mlEmail.value.toString()
        user.phone = mlPhone.value.toString()

        job = viewModelScope.launch {
            val result = repository.addUser(user)
            mlIsUserAdded.value = result > -1
        }
    }

    /**
     * ...get user list from local db
     */
    fun getUserList()
    {
        job = viewModelScope.launch {
            val userList = withContext(Dispatchers.IO){repository.getUserList()}
            mlUserList.postValue(userList as ArrayList<UserEntities>)
        }
    }
}
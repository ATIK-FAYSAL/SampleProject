package com.ecommerce.practiceproject.view_model

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ecommerce.practiceproject.model.UserRepository
import junit.framework.TestCase
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FragmentViewModelTest : TestCase(){
    private lateinit var viewModel: FragmentViewModel

    @Before
    public override fun setUp() {
        super.setUp()
        val mContext = ApplicationProvider.getApplicationContext<Context>()
        val repository = UserRepository()
        viewModel = FragmentViewModel(repository)
    }

    @Test
    fun dataValidation() {
        val expectedOutput = 0
        viewModel.mlFullName.postValue("Atik Faysal")
        viewModel.mlAddress.postValue("Dhaka, Shukrabad")
        viewModel.mlEmail.postValue("atik@gmail.com")
        viewModel.mlPhone.postValue("01794037303")

        val result = viewModel.dataValidation()

        TestCase.assertEquals(expectedOutput, result)
    }
}
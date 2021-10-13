package com.ecommerce.practiceproject.model

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ecommerce.practiceproject.data.ItemModel
import com.ecommerce.practiceproject.network.RetrofitClient
import com.ecommerce.practiceproject.network.config.ApiConfig

class PostDataSource() : PagingSource<Int, ItemModel>()
{
    override fun getRefreshKey(state: PagingState<Int, ItemModel>): Int? {
       return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ItemModel> {
        try {
            val currentLoadingPageKey = params.key ?: 1
            val apiConfig = RetrofitClient.getRetrofitClient().create(ApiConfig::class.java)
            val response = apiConfig.getDataList(currentLoadingPageKey, 50)
            val responseData = mutableListOf<ItemModel>()
            val data = response.results
            responseData.addAll(data)

            val prevKey = if (currentLoadingPageKey == 1) null else currentLoadingPageKey - 1

            return LoadResult.Page(
                data = responseData,
                prevKey = prevKey,
                nextKey = currentLoadingPageKey.plus(1)
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

}
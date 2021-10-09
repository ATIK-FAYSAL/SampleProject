package layout

import android.content.Context
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



/**
 * Created by Atik Faysal (Android Developer)
 * Create on 1/3/2021
 * Email: mdatikfaysal@gmail.com
 * *** Happy Coding ***
 */
class ViewUtils
{
    companion object{

        fun horizontalRecyclerView(context: Context, recyclerview: RecyclerView) : RecyclerView
        {
            val layoutManager = LinearLayoutManager(context)
            recyclerview.setHasFixedSize(true)
            layoutManager.orientation = LinearLayoutManager.HORIZONTAL
            recyclerview.layoutManager = layoutManager
            recyclerview.itemAnimator = DefaultItemAnimator()

            return recyclerview
        }

        fun horizontalMultiNumberItemRecyclerView(context: Context, recyclerview: RecyclerView, column: Int) : RecyclerView
        {
            recyclerview.setHasFixedSize(true)
            recyclerview.layoutManager = GridLayoutManager(context, column)
            recyclerview.itemAnimator = DefaultItemAnimator()

            return recyclerview
        }

        fun verticalRecyclerView(context: Context, recyclerview: RecyclerView) : RecyclerView
        {
            val layoutManager = LinearLayoutManager(context)
            recyclerview.setHasFixedSize(true)
            layoutManager.orientation = LinearLayoutManager.VERTICAL
            recyclerview.layoutManager = layoutManager
            recyclerview.itemAnimator = DefaultItemAnimator()

            return recyclerview
        }
    }
}
package com.ecommerce.practiceproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.layout_fragment_one.*

/**
 * Date 9/19/2021.
 * Created by Md Atik Faysal(Android Developer)
 *
 */
class FragmentThree : Fragment() {

    @Nullable
    override fun onCreateView(@NonNull inflater: LayoutInflater, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View {
        val view =  inflater.inflate(R.layout.layout_fragment_three, container, false)

        val tvFragmentTitle = view.findViewById<TextView>(R.id.tv_fragment_title)

        tvFragmentTitle.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fragmentThree_to_fragmentTwo3)
            //requireActivity().supportFragmentManager.popBackStack()
        }

        return view
    }
}
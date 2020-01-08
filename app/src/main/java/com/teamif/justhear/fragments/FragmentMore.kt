package com.teamif.justhear.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.teamif.justhear.MainActivity
import com.teamif.justhear.R

class FragmentMore : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_more, container, false)
    }

    override fun onResume() {
        super.onResume()
        (activity!! as MainActivity).setActionBarTitle(R.string.more)
    }
}
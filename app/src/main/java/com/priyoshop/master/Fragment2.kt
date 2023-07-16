package com.priyoshop.master

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.myapp.common.base.BaseFragment
import com.priyoshop.master.databinding.Fragment2Binding

class Fragment2 : BaseFragment<Fragment2Binding>() {
    override fun viewBindingLayout(): Fragment2Binding =
        Fragment2Binding.inflate(layoutInflater)

    override fun initializeView(savedInstanceState: Bundle?) {

        binding.fragment2.setOnClickListener {

            findNavController().navigate(com.myapp.navigations.R.id.action_fragment2_to_fragment1)
        }
    }
}
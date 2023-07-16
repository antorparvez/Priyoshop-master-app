package com.priyoshop.master

import android.os.Bundle
import com.myapp.common.base.BaseFragment
import com.priyoshop.master.databinding.Fragment1Binding

class Fragment1 : BaseFragment<Fragment1Binding>() {
    override fun viewBindingLayout()= Fragment1Binding.inflate(layoutInflater)

    override fun initializeView(savedInstanceState: Bundle?) {
        binding.fragment1.setOnClickListener {
        }
    }
}
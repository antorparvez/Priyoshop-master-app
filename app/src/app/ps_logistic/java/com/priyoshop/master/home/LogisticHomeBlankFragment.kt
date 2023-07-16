package com.priyoshop.master.home

import android.os.Bundle
import com.myapp.common.base.BaseFragment
import com.priyoshop.master.databinding.FragmentLogisticHomeBlankBinding

class LogisticHomeBlankFragment : BaseFragment<FragmentLogisticHomeBlankBinding>() {
    override fun viewBindingLayout(): FragmentLogisticHomeBlankBinding {
        return FragmentLogisticHomeBlankBinding.inflate(layoutInflater)
    }

    override fun initializeView(savedInstanceState: Bundle?) {
        binding.logisticHomeBlankFragmentTV.setOnClickListener {
            navigateToDestination(LogisticHomeBlankFragmentDirections.actionLogisticHomeBlankFragmentToLogisticBlankFragment2())
        }
    }
}
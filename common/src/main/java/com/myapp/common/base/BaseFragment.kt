package com.myapp.common.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment<V : ViewBinding> : Fragment() {
    private var _binding: V? = null
    protected val  binding get() = _binding!!
    protected abstract fun viewBindingLayout(): V
    protected abstract fun initializeView(savedInstanceState: Bundle?)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = viewBindingLayout()
        initializeView(savedInstanceState)
        return binding.root
    }

    protected fun showMessage(message: String?) {
        Snackbar.make(
            requireActivity().findViewById(android.R.id.content),
            "" + message,
            Snackbar.LENGTH_LONG
        ).show()
    }

    protected fun showProgressBar(isLoading: Boolean, view: View) {
        if (isLoading) {
            view.visibility = View.VISIBLE
            requireActivity().window?.setFlags(
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
            )
        } else {
            view.visibility = View.GONE
            requireActivity().window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        }
    }
    protected fun showWelcomeMessage(isLoading: Boolean, view: View) {
        if (isLoading) {
            view.visibility = View.VISIBLE
            requireActivity().window?.setFlags(
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
            )
        } else {
            view.visibility = View.GONE
            requireActivity().window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        }
    }
    protected fun showToastMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // region navigation
    protected fun navigateToDestination(navDirections: NavDirections) {
        try {
            findNavController().navigate(navDirections)
        } catch (e: Exception) {
            Log.d("TAG", "navigateToDestination Exception: ${e.message}")
        }
    }

    protected fun navigateBack() {
        try {
            findNavController().navigateUp()
        } catch (e: Exception) {
            Log.d("TAG", "navigateToBack Exception: ${e.message}")
        }
    }

    protected fun navigateToDestinationWithBundleNavOptions(
        destinationId: Int,
        bundle: Bundle? = null,
        navOptions: NavOptions? = null
    ) {
        try {
            findNavController().navigate(destinationId, bundle, navOptions)
        } catch (e: Exception) {
            Log.d("TAG", "navigateToDestinationWithBundleNavOptions Exception: ${e.message}")
        }
    }

    protected fun navigateToDestinationWithBundleNavOptions(
        navController: NavController,
        destinationId: Int,
        bundle: Bundle? = null,
        navOptions: NavOptions? = null
    ) {
        try {
            navController.navigate(destinationId, bundle, navOptions)
        } catch (e: Exception) {
            Log.d("TAG", "navigateToDestinationWithBundleNavOptions: ${e.message} ")
        }
    }


}
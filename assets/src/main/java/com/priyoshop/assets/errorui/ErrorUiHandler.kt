package com.priyoshop.assets.errorui

/*
import android.view.View
import androidx.core.view.isVisible
import com.test.com.priyoshop.master.databinding.ErrorHandlerLayoutBinding

class ErrorUiHandler constructor(
    private var binding: ErrorHandlerLayoutBinding,
    private var featureUi: View? = null,
    private val networkErrorCallback: ((flag: Int) -> Unit)?,
    private val dataErrorCallback: ((flag: Int) -> Unit)?
) {

    private var networkErrorCallbackFlag = 0
    private var dataErrorCallbackFlag = 0

    init {
        binding.errorLL.isVisible = false
        featureUi?.isVisible = true
        binding.networkErrorBtn.setOnClickListener {
            networkErrorCallback?.invoke(networkErrorCallbackFlag)
        }
        binding.dataErrorBtn.setOnClickListener {
            dataErrorCallback?.invoke(dataErrorCallbackFlag)
        }
    }

    fun showProgressBar(isLoading: Boolean) {
        binding.errorLL.isVisible = true
        binding.group.isVisible = false
        binding.networkErrorBtn.isVisible = false
        binding.dataErrorBtn.isVisible = false
        featureUi?.isVisible = !isLoading
        binding.progressBar.isVisible = isLoading
    }


    fun showNetworkError(message: String, networkErrorMethodFlag: Int = 0) {
        featureUi?.isVisible = false
        binding.errorLL.isVisible = true
        binding.group.isVisible = true
        binding.progressBar.isVisible = false
        binding.networkErrorBtn.isVisible = true
        binding.dataErrorBtn.isVisible = false

        binding.errorImageView.setImageResource(R.drawable.ic_error)
        binding.errorTitleTV.text = binding.root.context.getString(R.string.error_network_issue)
        binding.errorMessageTv.text = message
        this.networkErrorCallbackFlag = networkErrorMethodFlag
    }

    fun showDataError(icon: Int, title: String, message: String,buttonText:String,dataErrorMethodFlag: Int = 0) {
        featureUi?.isVisible = false
        binding.errorLL.isVisible = true
        binding.group.isVisible = true
        binding.progressBar.isVisible = false
        binding.networkErrorBtn.isVisible = false
        binding.dataErrorBtn.isVisible = true
        binding.dataErrorBtn.text = buttonText
        binding.errorImageView.setImageResource(icon)
        binding.errorTitleTV.text = title
        binding.errorMessageTv.text = message
        this.dataErrorCallbackFlag = dataErrorMethodFlag
    }

    fun reset() {
        binding.errorLL.isVisible = false
        featureUi?.isVisible = true
    }

}*/

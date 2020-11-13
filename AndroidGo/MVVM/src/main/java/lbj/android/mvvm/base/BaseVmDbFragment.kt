package lbj.android.mvvm.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import lbj.android.mvvm.ext.getVmClazz
import lbj.android.mvvm.helper.VMFactory

abstract class BaseVmDbFragment<VM : BaseVM, DB : ViewDataBinding> : Fragment() {

    lateinit var viewModel: VM
    lateinit var bind: DB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return bind.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    abstract fun getLayoutId(): Int
    abstract fun setTitle()
    abstract fun setView()
    abstract fun setListener()
    abstract fun setData()
    abstract fun setBind()

    private fun createViewModel(): VM =
        ViewModelProvider(this, VMFactory()).get(getVmClazz(this) as Class<VM>)
}
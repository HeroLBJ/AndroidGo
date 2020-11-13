package lbj.android.mvvm.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import lbj.android.mvvm.ext.getVmClazz
import lbj.android.mvvm.helper.VMFactory

abstract class BaseVmDbActivity<VM : BaseVM, DB : ViewDataBinding> : AppCompatActivity() {

    lateinit var viewModel: VM
    lateinit var bind: DB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = createDataBinding()
        viewModel = createViewModel()
        setTitle()
        setView()
        setListener()
        setData()
        setBind()
    }

    abstract fun getLayoutId(): Int
    abstract fun setTitle()
    abstract fun setView()
    abstract fun setListener()
    abstract fun setData()
    abstract fun setBind()

    private fun createDataBinding(): DB =
        DataBindingUtil.setContentView(this, getLayoutId())

    private fun createViewModel(): VM =
        ViewModelProvider(this, VMFactory()).get(getVmClazz(this) as Class<VM>)
}
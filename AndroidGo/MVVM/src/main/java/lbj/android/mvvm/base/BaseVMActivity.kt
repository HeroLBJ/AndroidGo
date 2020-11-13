package lbj.android.mvvm.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import lbj.android.mvvm.ext.getVmClazz
import lbj.android.mvvm.helper.VMFactory

abstract class BaseVMActivity<VM : BaseVM> : AppCompatActivity() {

    lateinit var vm: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        vm = createViewModel()
        setTitle()
        setView()
        setListener()
        setData()
    }

    abstract fun getLayoutId(): Int
    abstract fun setTitle()
    abstract fun setView()
    abstract fun setListener()
    abstract fun setData()

    private fun createViewModel(): VM =
        ViewModelProvider(this, VMFactory()).get(getVmClazz(this) as Class<VM>)

}
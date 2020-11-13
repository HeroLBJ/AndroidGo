package lbj.android.app.base

import androidx.databinding.ViewDataBinding
import lbj.android.mvvm.base.BaseVM
import lbj.android.mvvm.base.BaseVmDbActivity

abstract class BaseActivity<VM : BaseVM, DB : ViewDataBinding> : BaseVmDbActivity<VM, DB>() {
    abstract override fun getLayoutId(): Int

    override fun setTitle() {

    }

    override fun setView() {

    }

    override fun setListener() {

    }

    override fun setData() {

    }

    override fun setBind() {

    }
}
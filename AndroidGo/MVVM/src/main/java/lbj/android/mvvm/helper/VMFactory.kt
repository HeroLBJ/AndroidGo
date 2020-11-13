package lbj.android.mvvm.helper

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class VMFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.newInstance() //使用newInstance反射实例ViewModel，并且传出去
    }
}
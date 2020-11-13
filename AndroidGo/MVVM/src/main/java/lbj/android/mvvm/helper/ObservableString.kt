package lbj.android.mvvm.helper

import androidx.databinding.ObservableField

class ObservableString(var mValue: String = "") : ObservableField<String>() {

    override fun set(value: String) {
        if (value != mValue) {
            mValue = value
            notifyChange()
        }
    }

    override fun get(): String {
        return mValue
    }
}
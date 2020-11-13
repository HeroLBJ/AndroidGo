package lbj.android.ui.item02

import lbj.android.mvvm.helper.ObservableString
import lbj.android.mvvm.base.BaseVM

class SignatureVM : BaseVM() {
    var signature = ObservableString("暂无签名")
    var packageName = ObservableString()
}
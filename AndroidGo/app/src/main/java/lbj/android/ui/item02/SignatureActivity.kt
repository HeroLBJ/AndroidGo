package lbj.android.ui.item02

import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signature.*
import lbj.android.R
import lbj.android.app.base.BaseActivity
import lbj.android.databinding.ActivitySignatureBinding
import lbj.android.mvvm.helper.encipher.getSignature
import lbj.android.mvvm.helper.util.copy

class SignatureActivity : BaseActivity<SignatureVM, ActivitySignatureBinding>() {

    override fun getLayoutId() = R.layout.activity_signature

    override fun setListener() {
        btn_signature.setOnClickListener {
            if (viewModel.packageName.get().isEmpty()) {
                Toast.makeText(baseContext, "请输入包名", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            viewModel.signature.set(viewModel.packageName.get().getSignature(this))
        }

        btn_copy.setOnClickListener {
            viewModel.signature.get().copy(this)
        }
    }

    override fun setBind() {
        bind.vm = viewModel
    }
}
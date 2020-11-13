package lbj.android.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import lbj.android.R
import lbj.android.ui.item02.SignatureActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_action.setOnClickListener {
            startActivity(Intent(this, SignatureActivity::class.java))
        }
    }
}
package lbj.android.mvvm.helper.util

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context

/**
 * 复制普通文本
 */
fun String.copy(context: Context, message: String = "复制成功") {
    // 获取剪贴板管理器
    val cm = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    // 创建普通字符型ClipData
    val clipData = ClipData.newPlainText("Label", this)
    // 将ClipData内容放到系统剪贴板里。
    cm.setPrimaryClip(clipData)
}

/**
 * 粘贴文本
 */
fun Context.paste(): String {
    val cm = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    if (cm.hasPrimaryClip() && cm.primaryClip?.itemCount ?: 0 > 0) {
        val addedText: CharSequence = cm.primaryClip!!.getItemAt(0).text
        return addedText.toString()
    }
    return ""
}
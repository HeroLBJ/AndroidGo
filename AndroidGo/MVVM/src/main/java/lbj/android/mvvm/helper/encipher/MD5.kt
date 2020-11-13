package lbj.android.mvvm.helper.encipher

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.content.pm.Signature
import java.security.MessageDigest


/**
 * 获取当前手机安装的APK包名的签名文件,如果找不到则返回""
 */
fun String.getSignature(context: Context): String = MD5.getSignature(context, this)

class MD5 {

    companion object {

        fun getSignature(context: Context, packageName: String): String {
            val arrayOfSignature = getRawSignature(context, packageName)
            if (arrayOfSignature == null || arrayOfSignature.isEmpty()) {
                return ""
            }
            return getMessageDigest(arrayOfSignature[0]?.toByteArray())
        }

        private val arrayOfChar = charArrayOf(
            48.toChar(),
            49.toChar(),
            50.toChar(),
            51.toChar(),
            52.toChar(),
            53.toChar(),
            54.toChar(),
            55.toChar(),
            56.toChar(),
            57.toChar(),
            97.toChar(),
            98.toChar(),
            99.toChar(),
            100.toChar(),
            101.toChar(),
            102.toChar()
        )

        private fun getMessageDigest(paramArrayOfByte: ByteArray?): String {
            if (paramArrayOfByte == null) return ""
            try {
                val localMessageDigest = MessageDigest.getInstance("MD5")
                localMessageDigest.update(paramArrayOfByte)
                val arrayOfByte = localMessageDigest.digest()
                val i = arrayOfByte.size
                val arrayOfChar2 = CharArray(i * 2)
                var j = 0
                var k = 0
                while (true) {
                    if (j >= i) return String(arrayOfChar2)
                    val m = arrayOfByte[j].toInt()
                    val n = k + 1
                    arrayOfChar2[k] = arrayOfChar[0xF and (m ushr 4)]
                    k = n + 1
                    arrayOfChar2[n] = arrayOfChar[m and 0xF]
                    j++
                }
            } catch (localException: Exception) {
            }
            return ""
        }

        private fun getRawSignature(context: Context, packageName: String): Array<Signature?>? {
            val localPackageManager: PackageManager = context.packageManager
            val localPackageInfo: PackageInfo?
            try {
                localPackageInfo =
                    localPackageManager.getPackageInfo(packageName, PackageManager.GET_SIGNATURES)
                if (localPackageInfo == null) {
                    return null
                }
            } catch (localNameNotFoundException: PackageManager.NameNotFoundException) {
                return null
            }
            return localPackageInfo.signatures
        }
    }
}
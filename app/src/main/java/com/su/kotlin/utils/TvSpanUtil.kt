package com.su.kotlin.utils

import android.annotation.SuppressLint
import android.text.Html
import android.text.method.LinkMovementMethod
import android.widget.TextView
import com.su.kotlin.R
import java.lang.ref.WeakReference

/**
 * Created by Sujiayong on 2018/2/27.
 * 设置界面中tvKotlinWeb（TextView）
 */
class TvSpanUtil {

    companion object {
        /**
         * strs：只有一个的时候：代表—<a></a>的标记为“链接”
         *       只有两个的时候：代表—<a></a>的标记为 strs的第二个
         */
        @SuppressLint("StringFormatMatches")
        fun setTvSpan(textView: TextView, vararg strs: String) {
            val weakTextView = WeakReference<TextView>(textView)

            var urlStr = ""
            if (strs.size == 1) {
                urlStr = weakTextView.get()!!.context.getString(R.string.kotlin_web_url, strs)
            } else if (strs.size == 2) {
                urlStr = weakTextView.get()!!.context.getString(R.string.kotlin_web_url, strs[0], strs[1])
            }

            val urlSpan = Html.fromHtml(urlStr)
            textView.append(urlSpan)

            textView.movementMethod = LinkMovementMethod.getInstance()
        }


    }
}
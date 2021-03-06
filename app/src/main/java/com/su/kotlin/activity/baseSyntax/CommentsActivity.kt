package com.su.kotlin.activity.baseSyntax

import android.os.Bundle
import com.su.kotlin.R
import com.su.kotlin.frame.BaseActivity
import com.su.kotlin.utils.TvSpanUtil
import kotlinx.android.synthetic.main.activity_comments.*

/**
 * Created by Sujiayong on 2018/2/27.
 * 注解界面
 */
class CommentsActivity :BaseActivity(){

    val urlForDetails = "https://www.kotlincn.net/docs/reference/kotlin-doc.html"
    val urlFlagForDetails = "编写 Kotlin 代码文档"
    val sumUp = "\n与Java和JavaScript一样，\n// 这是一个行注释\n\n" +
            "/* 这是一个多行的\n" +
            "   块注释。 */"+
            "\n\n在Android Studio中快捷键也一致：\n选中文本后，ctrl+/（这是单行）；\n" +
            "选中文本后，ctrl+shift+/（这是多行）；\n"

    override fun setKotlinWeb(): String = "https://www.kotlincn.net/docs/reference/basic-syntax.html#注释"

    override fun layoutResId(): Int = R.layout.activity_comments

    override fun getIntentExtras(extrasBundle: Bundle) {

    }

    override fun initData() {
    }

    override fun initView() {
        //设置官网链接
//        TvSpanUtil.setTvSpan(tvKotlinWeb, url, url)
        TvSpanUtil.setTvSpan(tvKotlinDetailsWeb, urlForDetails, urlFlagForDetails)

        tvSumUp.append(sumUp)
    }

    override fun iniitListener() {
    }
}
package com.su.kotlin.activity.baseSyntax

import android.os.Bundle
import com.su.kotlin.R
import com.su.kotlin.frame.BaseActivity

/**
 * Created by Mr.Su on 2018/3/4.
 * 创建基本类及其实例——界面
 *
 */
class CreatingInstancesActivity : BaseActivity() {

    val urlForDetails = "https://www.kotlincn.net/docs/reference/classes.html"
    val urlFlagForDetails = "类"
    val urlForDetails2 = "https://www.kotlincn.net/docs/reference/object-declarations.html"
    val urlFlagForDetails2 = "对象与实例"

    override fun setKotlinWeb(): String = "https://www.kotlincn.net/docs/reference/basic-syntax.html#创建基本类及其实例"

    override fun layoutResId(): Int = R.layout.activity_common

    override fun getIntentExtras(extrasBundle: Bundle) {

    }

    override fun initData() {

    }

    override fun initView() {

    }

    override fun iniitListener() {

    }
}
package com.su.kotlin.activity.idioms

import android.os.Bundle
import android.util.Log
import android.view.View
import com.su.kotlin.R
import com.su.kotlin.frame.BaseActivity
import com.su.kotlin.utils.TvSpanUtil
import kotlinx.android.synthetic.main.activity_common.*

/**
 * Created by Mr.Su on 2018/3/24.
 *
 */
class LazyPropertyActivity : BaseActivity() {

    companion object {
        val TAG = "LazyPropertyActivity"
    }

    val goodWeb1 = "https://blog.csdn.net/Sherlbon/article/details/72769843"
    val goodWebTitle1 = "Kotlin lateinit 和 by lazy 的区别"

    val goodWeb2 = "https://www.jianshu.com/p/b8220a278fb0"
    val goodWebTitle2 = "Kotlin 的一些实用小技巧"

    val lazyProperty: String by lazy {
        Log.d(TAG, "executed only first time")
        "LazyProperty"
    }

    override fun setKotlinWeb(): String = "https://www.kotlincn.net/docs/reference/idioms.html#延迟属性"

    override fun layoutResId(): Int = R.layout.activity_common

    override fun getIntentExtras(extrasBundle: Bundle) {

    }

    override fun initData() {
        tvFun.text = "Lazy:\n" +
                "    val lazyProperty: String by lazy {\n" +
                "        Log.d(TAG, \"executed only first time\")\n" +
                "        \"LazyProperty\"\n" +
                "    }"

        btnRun.visibility = View.GONE

        tvSumUp.append("\n")
        TvSpanUtil.setTvSpan(tvSumUp, goodWeb1, goodWebTitle1)
        tvSumUp.append("\n")
        TvSpanUtil.setTvSpan(tvSumUp, goodWeb2, goodWebTitle2)

        tvRunResult.text = "在测试是尝试在Activity生命周期的onCreate()、onResume()、onStart()方法Log变量lazyProperty" +
                "，发现\"executed only first time\"只出现一次，且在第一次调用（初始化）前面。"

        val sumUpStr = "\nLazy：\n" +
                " * Creates a new instance of the [Lazy] that uses the specified initialization function [initializer]\n" +
                " * and the default thread-safety mode [LazyThreadSafetyMode.SYNCHRONIZED].\n" +
                " *\n" +
                " * If the initialization of a value throws an exception, it will attempt to reinitialize the value at next access.\n" +
                " *\n" +
                " * Note that the returned instance uses itself to synchronize on. Do not synchronize from external code on\n" +
                " * the returned instance as it may cause accidental deadlock. Also this behavior can be changed in the future.\n\n"
        tvSumUp.append(sumUpStr)
    }

    override fun initView() {

    }

    override fun iniitListener() {

    }

}
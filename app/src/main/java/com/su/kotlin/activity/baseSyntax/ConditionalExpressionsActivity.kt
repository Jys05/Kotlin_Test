package com.su.kotlin.activity.baseSyntax

import android.os.Bundle
import android.view.View
import com.su.kotlin.R
import com.su.kotlin.frame.BaseActivity
import com.su.kotlin.utils.TvSpanUtil
import kotlinx.android.synthetic.main.activity_conditional_expressions.*

/**
 * Created by Sujiayong on 2018/2/27.
 * 条件表达式——界面
 */
class ConditionalExpressionsActivity : BaseActivity() {

    val urlForDetails = "https://www.kotlincn.net/docs/reference/control-flow.html#if-表达式"
    val urlFlagForDetails = "if 表达式"

    override fun setKotlinWeb(): String = "https://www.kotlincn.net/docs/reference/basic-syntax.html#使用条件表达式"

    override fun layoutResId(): Int = R.layout.activity_conditional_expressions

    override fun getIntentExtras(extrasBundle: Bundle) {
    }

    override fun initData() {
    }

    override fun initView() {
        //设置官网链接
//        TvSpanUtil.setTvSpan(tvKotlinWeb, url, url)
        TvSpanUtil.setTvSpan(tvKotlinDetailsWeb, urlForDetails, urlFlagForDetails)

        tvFun.text = "fun maxOf(a: Int, b: Int): Int {\n" +
                "    if (a > b) {\n" +
                "        return a\n" +
                "    } else {\n" +
                "        return b\n" +
                "    }\n" +
                "}" +
                "\n\n或者\n" +
                "fun maxOf(a: Int, b: Int) = if (a > b) a else b"

        val sumUpStr = "\n1、在Kotlin中，没有Java的“三元运算符（条件 ? 然后 : 否则”\n" +
                "2、if的分支可以是代码块，最后的表达式作为该块的值\n" +
                "3、如果你使用 if 作为表达式而不是语句（例如：返回它的值或者把它赋给变量），该表达式需要有 else 分支\n\n" +
                "测试过，如果写成：\n" +
                "        val a = 231\n" +
                "        val b = 123\n" +
                "        val test = if (a > b) { a } \n" +
                "会报错，所以验证了第三点，若作为表达式，需要有 else 分支"


        tvSumUp.append(sumUpStr)

        scrollView.smoothScrollTo(0, 0)
    }

    override fun iniitListener() {
        btnRun.setOnClickListener { v: View? -> tvRunResult.text = maxOf(0, 42).toString() }
    }

    fun maxOf(a: Int, b: Int): Int {
        if (a > b) {
            return a
        } else {
            return b
        }
    }
}
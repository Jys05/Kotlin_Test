package com.su.kotlin_test.activity.baseSyntax

import android.os.Bundle
import android.support.annotation.NonNull
import android.view.View
import com.su.kotlin_test.R
import com.su.kotlin_test.frame.BaseActivity
import com.su.kotlin_test.utils.TvSpanUtil
import kotlinx.android.synthetic.main.activity_string_templates.*

/**
 * Created by Sujiayong on 2018/2/27.
 * 使用字符串模板——界面
 */
class StringTemplatesActivity : BaseActivity() {

    val url = "https://www.kotlincn.net/docs/reference/basic-syntax.html#使用字符串模板"
    val urlForDetails = "https://www.kotlincn.net/docs/reference/basic-types.html#字符串模板"
    val urlFlagForDetails = "基本类型 #字符串模板"

    override fun setLayoutResId(): Int = R.layout.activity_string_templates

    override fun getIntentExtras(extrasBundle: Bundle) {
    }

    override fun initData() {
    }

    override fun initView() {
        //设置官网链接
        TvSpanUtil.setTvSpan(tvKotlinWeb, url, url)
        TvSpanUtil.setTvSpan(tvKotlinDetailsWeb, urlForDetails, urlFlagForDetails)

        tvFun.text = "        var a = 1\n" +
                "        // 模板中的简单名称：\n" +
                "        val s1 = \"a is \$a\"\n" +
                "\n" +
                "        a = 3\n" +
                "        // 模板中的任意表达式：\n" +
                "        val s2 = \"\${s1.replace(\"is\", \"was\")}, but now is \$a\",测试函数： \${testFun(\"我的测试\")}" +
                "\n\n函数：\n" +
                "    fun testFun(value: String): Int {\n" +
                "        val resultStr = \"测试的文本：\" + value\n" +
                "        val result = resultStr.length + 10\n" +
                "        return result\n" +
                "    }"


        val sumUpStr = "\n字符串模板格式：\n" +
                "1、美元符号($)+变量\n" +
                "2、美元符号($)+用花括号括起来的任意表达式\n" +
                "注意：\n" +
                "1、将代码写成一个函数方法，也可用\n" +
                "2、自定义函数方法若没有返回值，会显示“kotlin.Unit”\n"
        tvSumUp.append(sumUpStr)

        scrollView.smoothScrollTo(0, 0)
    }

    override fun iniitListener() {
        btnRun.setOnClickListener { v: View? -> tvRunResult.text = useStringTemplates() }
    }

    fun useStringTemplates(): String {
        var a = 1
        // 模板中的简单名称：
        val s1 = "a is $a"

        a = 3
        // 模板中的任意表达式：
        val s2 = "${s1.replace("is", "was")}, but now is $a ,测试函数： ${testFun("我的测试")}"
        return s2
    }

    fun testFun(value: String): Int {
        val resultStr = "测试的文本：" + value
        val result = resultStr.length + 10
        return result
    }
}
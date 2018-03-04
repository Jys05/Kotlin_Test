package com.su.kotlin_test.activity.baseSyntax

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.su.kotlin_test.R
import com.su.kotlin_test.frame.BaseActivity
import com.su.kotlin_test.utils.CreateRadioButton
import com.su.kotlin_test.utils.TvSpanUtil
import kotlinx.android.synthetic.main.activity_common_for_radio_group.*

/**
 * Created by Mr.Su on 2018/3/4.
 * 使用 when 表达式——界面
 *
 */
class WhenExpressionActivity : BaseActivity() {

    var checkedIdForRadioButton = 1

    val url = "https://www.kotlincn.net/docs/reference/basic-syntax.html#使用-when-表达式"
    val urlForDetails = "https://www.kotlincn.net/docs/reference/control-flow.html#when-表达式"
    val urlFlagForDetails = "when 表达式"


    override fun setLayoutResId(): Int = R.layout.activity_common_for_radio_group

    override fun getIntentExtras(extrasBundle: Bundle) {
    }

    override fun initData() {

    }

    override fun initView() {
        //设置官网链接
        TvSpanUtil.setTvSpan(tvKotlinWeb, url, url)
        TvSpanUtil.setTvSpan(tvKotlinDetailsWeb, urlForDetails, urlFlagForDetails)

        tvFun.text = "\n使用 when 表达式：\n    fun describe(obj: Any): String =\n" +
                "            when (obj) {\n" +
                "                1, 20 -> \"One or Twenty\"\n" +
                "                \"Hello\" -> \"Greeting\"\n" +
                "                is String -> \"is a string\"\n" +
                "                is Long -> \"Long\"\n" +
                "                !is String -> \"Not a string\"\n" +
                "                else -> \"Unknown\"\n" +
                "            }"

        tvRadioGroupDescribe.text = "传入方法的值："

        var value1 = "1"
        var value2 = "1.toLong()"
        var value3 = "1.toDouble()"
        var value4 = "20"
        var value5 = "Hello"
        var value6 = "Kotlin"
        var value7 = "5.toLong()"
        var value8 = "6.66"

        //若不设置RadioButton的id，id会自动叠加
        radioGroup.addView(CreateRadioButton.createRadioButton(applicationContext, value1, 1))
        radioGroup.addView(CreateRadioButton.createRadioButton(applicationContext, value2, 2))
        radioGroup.addView(CreateRadioButton.createRadioButton(applicationContext, value3, 3))
        radioGroup.addView(CreateRadioButton.createRadioButton(applicationContext, value4, 4))
        radioGroup.addView(CreateRadioButton.createRadioButton(applicationContext, value5, 5))
        radioGroup.addView(CreateRadioButton.createRadioButton(applicationContext, value6, 6))
        radioGroup.addView(CreateRadioButton.createRadioButton(applicationContext, value7, 7))
        radioGroup.addView(CreateRadioButton.createRadioButton(applicationContext, value8, 8))

        radioGroup.check(checkedIdForRadioButton)
        scrollView.smoothScrollTo(0, 0)

        val sumUpStr = "\n" +
                "注意：上述函数：1、经过When表达式后，得到的值直接赋出去了。\n" +
                "2、“->”能接“{}”括起的函数块，但是上述函数写法:\n" +
                "    (a)只要最后一句是定义好的类型（如上述的String类型），例子见下述—“when表达式的使用2。”\n" +
                "    (b)这样写法不能加“return”，不然会报错，Android Studio会将其修改为传给一个变量。" +
                "\n\n1、一个“->”符号，相当于带有“break”。\n" +
                "2、当多条条件，使用“,”隔开。\n" +
                "3、详情中表述，条件可以是“in”加“区间”"

        val fun2 = "\n\nwhen表达式的使用2\n    fun describe2(obj: Any): String = when (obj) {\n" +
                "        1, 20 -> {\n" +
                "            var a = \"One or Twenty\" + \"For Kotlin\"\n" +
                "            a\n" +
                "        }\n" +
                "        \"Hello\" -> {\n" +
                "            val a = 1\n" +
                "            val b = 2\n" +
                "            \"Hello\" + (a + b).toString()\n" +
                "        }\n" +
                "        is String -> \"is a string\"\n" +
                "        is Long -> \"Long\"\n" +
                "        !is String -> \"Not a string\"\n" +
                "        else -> \"Unknown\"\n" +
                "    }"
        tvSumUp.append(sumUpStr)
        tvSumUp.append(fun2)
    }

    override fun iniitListener() {
        btnRun.setOnClickListener { v: View? ->
            when (checkedIdForRadioButton) {
                1 -> tvRunResult.text = describe(1)
                2 -> tvRunResult.text = describe(1.toLong())
                3 -> tvRunResult.text = describe(1.toDouble())
                4 -> tvRunResult.text = describe(20)
                5 -> tvRunResult.text = describe("Hello")
                6 -> tvRunResult.text = describe("Kotlin")
                7 -> tvRunResult.text = describe(5.toLong())
                8 -> tvRunResult.text = describe(6.66)
                else -> Toast.makeText(this, getString(R.string.error_code), Toast.LENGTH_SHORT).show()
            }
        }

        radioGroup.setOnCheckedChangeListener { group, checkedId -> checkedIdForRadioButton = checkedId }
    }

    fun describe(obj: Any): String =
            when (obj) {
                1, 20 -> "One or Twenty"
                "Hello" -> "Greeting"
                is String -> "is a string"
                is Long -> "Long"
                !is String -> "Not a string"
                else -> "Unknown"
            }

    fun describe2(obj: Any): String = when (obj) {
        1, 20 -> {
            var a = "One or Twenty" + "For Kotlin"
            a
        }
        "Hello" -> {
            val a = 1
            val b = 2
            "Hello" + (a + b).toString()
        }
        is String -> "is a string"
        is Long -> "Long"
        !is String -> "Not a string"
        else -> "Unknown"
    }


}
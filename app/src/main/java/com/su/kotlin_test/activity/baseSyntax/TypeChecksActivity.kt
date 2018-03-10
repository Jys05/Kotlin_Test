package com.su.kotlin_test.activity.baseSyntax

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import com.su.kotlin_test.R
import com.su.kotlin_test.frame.BaseActivity
import com.su.kotlin_test.utils.CreateRadioButton
import com.su.kotlin_test.utils.TvSpanUtil
import kotlinx.android.synthetic.main.activity_type_checks.*

/**
 * Created by Sujiayong on 2018/2/27.
 * 使用类型检测及自动类型转换——界面
 */
class TypeChecksActivity : BaseActivity() {

    var checkedIdForRadioButton = 1

    val urlForDetails = "https://www.kotlincn.net/docs/reference/classes.html"
    val urlFlagForDetails = "类"
    val urlForDetails2 = "https://www.kotlincn.net/docs/reference/typecasts.html"
    val urlFlagForDetails2 = "类型转换"

    override fun setKotlinWeb(): String = "https://www.kotlincn.net/docs/reference/basic-syntax.html#使用类型检测及自动类型转换"

    override fun layoutResId(): Int = R.layout.activity_type_checks

    override fun getIntentExtras(extrasBundle: Bundle) {
    }

    override fun initData() {
    }

    override fun initView() {
        //设置官网链接
//        TvSpanUtil.setTvSpan(tvKotlinWeb, url, url)

        TvSpanUtil.setTvSpan(tvKotlinDetailsWeb, urlForDetails, urlFlagForDetails)
        tvKotlinDetailsWeb.append(" 和 ")
        TvSpanUtil.setTvSpan(tvKotlinDetailsWeb, urlForDetails2, urlFlagForDetails2)

        var getStringLength1 = "\n    fun getStringLength1(obj: Any): Int? {\n" +
                "        if (obj is String) {\n" +
                "            // `obj` 在该条件分支内自动转换成 `String`\n" +
                "            return obj.length\n" +
                "        }\n" +
                "\n" +
                "        // 在离开类型检测分支后，`obj` 仍然是 `Any` 类型\n" +
                "        return null\n" +
                "\n" +
                "    }"
        var getStringLength2 = "\n    fun getStringLength2(obj: Any): Int? {\n" +
                "        if (obj !is String) return null\n" +
                "\n" +
                "        // `obj` 在这一分支自动转换为 `String`\n" +
                "        return obj.length\n" +
                "\n" +
                "    }"
        var getStringLength3 = "\n    fun getStringLength3(obj: Any): Int? {\n" +
                "        // `obj` 在 `&&` 右边自动转换成 `String` 类型\n" +
                "        if (obj is String && obj.length > 0) {\n" +
                "            return obj.length\n" +
                "        }\n" +
                "\n" +
                "        return null\n" +
                "    }"

        //若不设置RadioButton的id，id会自动叠加
        radioGroup.addView(CreateRadioButton.createRadioButton(applicationContext, getStringLength1, 1))
        radioGroup.addView(CreateRadioButton.createRadioButton(applicationContext, getStringLength2, 2))
        radioGroup.addView(CreateRadioButton.createRadioButton(applicationContext, getStringLength3, 3))

        radioGroup.check(checkedIdForRadioButton)
        scrollView.smoothScrollTo(0, 0)

        val sumUpStr = "\n使用“is”和“!is”——来检测一个表达式是否某类型的一个实例\n" +
                "'obj'经过is或者!is后，会自动转成对应的类型，也会有该类型的方法"+
                "\n\n注意：传入各个方法的参数是String类型的“使用类型检测及自动类型转换”"
        tvSumUp.append(sumUpStr)
    }

    override fun iniitListener() {
        btnRun.setOnClickListener { v: View? ->
            when (checkedIdForRadioButton) {
                1 -> tvRunResult.text = getStringLength1("使用类型检测及自动类型转换").toString()
                2 -> tvRunResult.text = getStringLength2("使用类型检测及自动类型转换").toString()
                3 -> tvRunResult.text = getStringLength3("使用类型检测及自动类型转换").toString()
                else -> Snackbar.make(v!!,R.string.error_code, Snackbar.LENGTH_SHORT).show()
            }
        }

        radioGroup.setOnCheckedChangeListener { group, checkedId -> checkedIdForRadioButton = checkedId }
    }

    fun getStringLength1(obj: Any): Int? {
        if (obj is String) {
            // `obj` 在该条件分支内自动转换成 `String`
            return obj.length
        }

        // 在离开类型检测分支后，`obj` 仍然是 `Any` 类型
        return null

    }

    fun getStringLength2(obj: Any): Int? {
        if (obj !is String) return null

        // `obj` 在这一分支自动转换为 `String`
        return obj.length

    }

    fun getStringLength3(obj: Any): Int? {
        // `obj` 在 `&&` 右边自动转换成 `String` 类型
        if (obj is String && obj.length > 0) {
            return obj.length
        }

        return null
    }
}
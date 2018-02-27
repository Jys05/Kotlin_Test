package com.su.kotlin_test.activity.baseSyntax

import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import com.su.kotlin_test.R
import com.su.kotlin_test.frame.BaseActivity
import com.su.kotlin_test.utils.CreateRadioButton.Companion.createRadioButton
import com.su.kotlin_test.utils.TvSpanUtil.Companion.setTvSpan
import kotlinx.android.synthetic.main.activity_define_var.*

/**
 * Created by Sujiayong on 2018/2/24.
 * 定义变量界面
 */
class DefineVarActivity : BaseActivity(), View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    var checkedIdForRadioButton = 1
    var valFunText: String = ""
    var varFunText: String = ""
    var globalVarFunText: String = ""

    val url = "https://www.kotlincn.net/docs/reference/basic-syntax.html#定义变量"
    val urlForDetails = "https://www.kotlincn.net/docs/reference/properties.html"
    var urlForBlog = "http://blog.danlew.net/2017/05/30/mutable-vals-in-kotlin/#"
    var urlFlag = "介绍var与val的博客"

    override fun setLayoutResId(): Int = R.layout.activity_define_var

    override fun getIntentExtras(extrasBundle: Bundle) {

    }

    override fun initData() {
        valFunText = "\n一次赋值（只读）的局部变量：\n        val a: Int = 1  // 立即赋值\n" +
                "        val b = 2       // 自动推断出 `Int` 类型\n" +
                "        val c: Int      // 如果没有初始值类型不能省略\n" +
                "        c = 3           // 明确赋值\n" +
                "    println(\"a = \$a, b = \$b, c = \$c\")"

        varFunText = "\n可变变量：\n    var x = 5 // 自动推断出 `Int` 类型\n" +
                "    x += 1\n" +
                "    println(\"x = \$x\")"

        globalVarFunText = "\n顶层变量：\nval PI = 3.14\n" +
                "var x = 0\n" +
                "\n" +
                "fun incrementX() { \n" +
                "    x += 1 \n" +
                "}"
    }

    override fun initView() {
        //设置官网链接
        setTvSpan(tvKotlinWeb, url, url)
        setTvSpan(tvKotlinDetailsWeb , urlForDetails ,urlForDetails)

        //设置总结
        tvSumUp.text = "1、val：不可变变量，类似java中的加了final \n" +
                "var:可变变量 \n" +
                "2、在Kotlin中，会自动推断出类型\n"
        setTvSpan(tvSumUp, urlForBlog, urlFlag)

        //若不设置RadioButton的id，id会自动叠加
        radioGroup.addView(createRadioButton(applicationContext, valFunText, 1))
        radioGroup.addView(createRadioButton(applicationContext, varFunText, 2))
        radioGroup.addView(createRadioButton(applicationContext, globalVarFunText, 3))

        radioGroup.check(checkedIdForRadioButton)

        scrollView.smoothScrollTo(0, 0)
    }

    override fun iniitListener() {
        btnRunFun.setOnClickListener(this)

        radioGroup.setOnCheckedChangeListener(this)
    }


    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        Toast.makeText(this, "radioButton的id为" + checkedId.toString(), Toast.LENGTH_SHORT).show()
        checkedIdForRadioButton = checkedId
    }

    override fun onClick(v: View?) {
        when (checkedIdForRadioButton) {
            1 -> tvResult.text = funForVal()
            2 -> tvResult.text = funForVar()
            3 -> tvResult.text = funForTopLevelVar()
            else -> Toast.makeText(this, getString(R.string.error_code), Toast.LENGTH_SHORT).show()
        }
    }


    /**
     * 一次赋值（只读）的局部变量
     */
    fun funForVal(): String {
        val a: Int = 1  // 立即赋值
        val b = 2       // 自动推断出 `Int` 类型
        val c: Int      // 如果没有初始值类型不能省略
        c = 3           // 明确赋值

        return "a = $a, b = $b, c = $c"
    }


    /**
     * 可变变量：
     */
    fun funForVar(): String {
        var x = 5 // 自动推断出 `Int` 类型
        var result = "x = $x(before)"
        x += 1
        result += ",x = $x (after)"
        return result
    }


    /**
     * 顶层变量：
     */
    fun funForTopLevelVar(): String {
        var result = "x = $x; PI = $PI(before)"

        incrementX()

        result += "incrementX():x = $x; PI = $PI(after)"

        return result
    }

    val PI = 3.14
    var x = 0

    fun incrementX() {
        x += 1
    }

}
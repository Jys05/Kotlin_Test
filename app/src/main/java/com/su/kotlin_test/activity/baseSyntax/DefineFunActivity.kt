package com.su.kotlin_test.activity.baseSyntax

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import com.su.kotlin_test.R
import com.su.kotlin_test.frame.BaseActivity
import com.su.kotlin_test.utils.CreateRadioButton.Companion.createRadioButton
import com.su.kotlin_test.utils.TvSpanUtil.Companion.setTvSpan
import kotlinx.android.synthetic.main.activity_define_fun.*

/**
 * Created by Sujiayong on 2018/2/24.
 * 定义函数界面
 */
class DefineFunActivity : BaseActivity(), View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    var checkedIdForRadioButton = 1
    val url = "https://www.kotlincn.net/docs/reference/basic-syntax.html#定义函数"
    val urlForDetails = "https://www.kotlincn.net/docs/reference/functions.html"
    val urlFlagForDetails = "函数"

    override fun setLayoutResId(): Int = R.layout.activity_define_fun

    override fun getIntentExtras(extrasBundle: Bundle) {

    }

    override fun initData() {

    }

    override fun initView() {
        setTvSpan(tvKotlinWeb , url ,url)
        setTvSpan(tvKotlinDetailsWeb , urlForDetails ,urlFlagForDetails)

        var sum = "\n带有两个 Int 参数、返回 Int 的函数：\nfun sum(a: Int, b: Int): Int {\n\t\treturn a + b\n}"
        var sum2 = "\n将表达式作为函数体、返回值类型自动推断的函数：\nfun sum(a: Int, b: Int) = a + b"
        var printSum = "\n函数返回无意义的值：\nfun printSum(a: Int, b: Int): Unit {\n\t\tprintln(\"sum of \$a and \$b is \${a + b}\")\n}"
        var printSum2 = "\nUnit 返回类型可以省略：\nfun printSum(a: Int, b: Int) {\n\t\tprintln(\"sum of \$a and \$b is \${a + b}\")\n}"

        //若不设置RadioButton的id，id会自动叠加
        radioGroup.addView(createRadioButton(applicationContext, sum, 1))
        radioGroup.addView(createRadioButton(applicationContext, sum2, 2))
        radioGroup.addView(createRadioButton(applicationContext, printSum, 3))
        radioGroup.addView(createRadioButton(applicationContext, printSum2, 4))

        radioGroup.check(checkedIdForRadioButton)

    }

    override fun iniitListener() {
        radioGroup.setOnCheckedChangeListener(this)

        btnGetResult.setOnClickListener(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        //发现不这样的话，其他界面的会受到影响（id会在这个基础上叠加）
        radioGroup.removeAllViews()
    }


    override fun onClick(v: View?) {
        val numValueStr1 = etFristNumValue.text.trim().toString()
        val numValueStr2 = etSecondNumValue.text.trim().toString()

        if (TextUtils.isEmpty(numValueStr1) || TextUtils.isEmpty(numValueStr2)) {
            Toast.makeText(this, getString(R.string.please_input_num), Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val fristNum: Int = Integer.parseInt(numValueStr1)
            val secondNum = Integer.parseInt(numValueStr2)
            when (checkedIdForRadioButton) {
                1 -> tvResult.text = sum(fristNum, secondNum).toString()
                2 -> tvResult.text = sum2(fristNum, secondNum).toString()
                3 -> tvResult.text = printSum(fristNum, secondNum)
                4 -> tvResult.text = printSum2(fristNum, secondNum)
                else -> Toast.makeText(this, getString(R.string.error_code), Toast.LENGTH_SHORT).show()
            }
        } catch (e: NumberFormatException) {
            Toast.makeText(this, getString(R.string.tip_for_NumberFormatException), Toast.LENGTH_SHORT).show()
            return
        }


    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        Toast.makeText(this, "radioButton的id为" + checkedId.toString(), Toast.LENGTH_SHORT).show()
        checkedIdForRadioButton = checkedId
    }

    /** * 知识点：函数方法   */

    /**
     * 知识点：带有两个 Int 参数、返回 Int 的函数
     */
    fun sum(a: Int, b: Int): Int {
        println("sum of $a and $b is ${a + b}")
        return a + b
    }

    /**
     * 知识点：将表达式作为函数体、返回值类型自动推断的函数：
     */
    fun sum2(a: Int, b: Int): Int = a + b


    /**
     * 知识点：函数返回无意义的值：
     * 注意：由于项目的原因，将返回Unit改为返回String
     */
//    fun printSum(a: Int, b: Int): Unit {
//        println("sum of $a and $b is ${a + b}")
//    }
    fun printSum(a: Int, b: Int): String {
        return "sum of $a and $b is ${a + b}"
    }

    /**
     * 知识点：Unit 返回类型可以省略：
     * 注意：由于项目的原因，将返回Unit改为返回String
     */
//    fun printSum(a: Int, b: Int) {
//        println("sum of $a and $b is ${a + b}")
//    }
    fun printSum2(a: Int, b: Int): String {
        return "sum of $a and $b is ${a + b}"
    }
}
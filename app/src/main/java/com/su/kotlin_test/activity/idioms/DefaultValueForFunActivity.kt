package com.su.kotlin_test.activity.idioms

import android.os.Bundle
import android.util.Log
import com.su.kotlin_test.R
import com.su.kotlin_test.frame.BaseActivity
import com.su.kotlin_test.utils.CreateRadioButton
import kotlinx.android.synthetic.main.activity_common_double_radio_group.*

/**
 * Created by Mr.Su on 2018/3/8.
 *
 * 函数的默认参数
 */
class DefaultValueForFunActivity : BaseActivity() {

    var checkedIdForRbFun = 1           //对于函数RadioButton的Id
    var checkedIdForRbValue = 1           //对于值RadioButton的Id


    override fun setKotlinWeb(): String = "https://www.kotlincn.net/docs/reference/idioms.html#函数的默认参数"

    override fun layoutResId(): Int = R.layout.activity_common_double_radio_group

    override fun getIntentExtras(extrasBundle: Bundle) {

    }

    override fun initData() {
    }

    override fun initView() {


        var fun1 = "\n函数的默认参数_1：\n" +
                "   fun defautValue1(num: Int = 10, str: String = " +
                "\"kotlin的函数的默认参数\"): String = \"Num is \$num,Str is \$str\""
        var fun2 = "\n\n函数的默认参数_2：\n" +
                "    fun defautValue2(num: Int, str: String = " +
                "\"kotlin的函数的默认参数\"): String = \"Num is \$num,Str is \$str\""

        //调用函数
        var askFun1 = "\n\n\n调用_1：\n" + "defautValue()"
        var askFun2 = "\n\n调用_2：\n" + "defautValue(11,\"kotlin语言\")"
        var askFun3 = "\n\n调用_2：\n" + "defautValue(11)"

        radioGroupForFun.addView(CreateRadioButton.createRadioButton(applicationContext, fun1, 1))
        radioGroupForFun.addView(CreateRadioButton.createRadioButton(applicationContext, fun2, 2))

        radioGroupForValue.addView(CreateRadioButton.createRadioButton(this, askFun1, 1))
        radioGroupForValue.addView(CreateRadioButton.createRadioButton(this, askFun2, 2))
        radioGroupForValue.addView(CreateRadioButton.createRadioButton(this, askFun3, 3))

        radioGroupForFun.check(checkedIdForRbFun)
        radioGroupForValue.check(checkedIdForRbValue)
        scrollView.smoothScrollTo(0, 0)

        val sumUpStr = "\n在没有入参的情况下，会使用默认的值。\n" +
                "当多个入参可以只传其中一个，前提条件是这“其中一个参数”不是第二个位或第二位之后的\n\n" +
                "注意：\n" +
                "必须注意参数的位置问题，不然还导致调用函数的问题"
        tvSumUp.append(sumUpStr)

    }

    override fun iniitListener() {
        //函数的radioButton
        radioGroupForFun.setOnCheckedChangeListener { group, checkedId ->
            checkedIdForRbFun = checkedId
        }
        //关于调用的radioButton
        radioGroupForValue.setOnCheckedChangeListener { group, checkedId ->
            checkedIdForRbValue = checkedId
        }

        btnRun.setOnClickListener {
            tvRunResult.text = when (checkedIdForRbFun) {
                1 -> {
                    when (checkedIdForRbValue) {
                        1 -> defautValue1()
                        2 -> defautValue1(11, "kotlin语言")
                        3 -> defautValue1(11)
                        else -> {
                            "请选择函数"
                        }
                    }
                }
                2 -> {
                    when (checkedIdForRbValue) {
                        1 -> "由于不是默认，该函数的入参num必须传"
                        2 -> defautValue2(11, "kotlin语言")
                        3 -> defautValue2(11)
                        else -> {
                            "请选择函数"
                        }
                    }
                }
                else -> {
                    "请选择函数"
                }
            }
        }
    }

    val TAG = "DefaultValueFor"

    fun defautValue1(num: Int = 10, str: String = "kotlin的函数的默认参数"): String = "Num is $num,Str is $str"

    fun defautValue2(num: Int, str: String = "kotlin的函数的默认参数"): String = "Num is $num,Str is $str"
}
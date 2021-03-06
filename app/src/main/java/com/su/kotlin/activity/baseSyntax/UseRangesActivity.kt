package com.su.kotlin.activity.baseSyntax

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import com.su.kotlin.R
import com.su.kotlin.frame.BaseActivity
import com.su.kotlin.utils.CreateRadioButton
import com.su.kotlin.utils.TvSpanUtil
import kotlinx.android.synthetic.main.activity_type_checks.*

/**
 * Created by Mr.Su on 2018/3/4.
 * 使用区间（range）——界面
 */
class UseRangesActivity : BaseActivity() {

    var checkedIdForRadioButton = 1

    val urlForDetails = "https://www.kotlincn.net/docs/reference/ranges.html"
    val urlFlagForDetails = "区间"

    override fun setKotlinWeb(): String = "https://www.kotlincn.net/docs/reference/basic-syntax.html#使用区间range"

    override fun layoutResId(): Int = R.layout.activity_common_single_radio_group

    override fun getIntentExtras(extrasBundle: Bundle) {

    }

    override fun initData() {

    }

    override fun initView() {
        //设置官网链接
//        TvSpanUtil.setTvSpan(tvKotlinWeb, url, url)

        TvSpanUtil.setTvSpan(tvKotlinDetailsWeb, urlForDetails, urlFlagForDetails)

        var useRanges1 = "三种区间：\n    fun useRanges1(): String {\n" +
                "        for (x in 0..10) {\n" +
                "            print(x)\n" +
                "        }\n" +
                "        println()\n" +
                "        for (y in 10 downTo 0) {\n" +
                "            print(y)\n" +
                "        }\n" +
                "        println()\n" +
                "        for (z in 0 until 10) {\n" +
                "            print(z)\n" +
                "          }\n" +
                "        print(0 downTo 10)\n" +
                "    }"
        var useRanges2 = "使用in判断，以及step用法：\n   fun useRanges2(): String {\n" +
                "        //if判断\n" +
                "        if (8 in 0..10) {\n" +
                "            print(\"8 in the range\")\n" +
                "        }\n" +
                "        //if判断\n" +
                "        if (10 !in 0 until 10) {\n" +
                "            print(\"10 is out of range\")\n" +
                "        }\n" +
                "        //for循环\n" +
                "        for (x in 0..10 step 3) {\n" +
                "            print(x)\n" +
                "        }\n" +
                "    }"

        //若不设置RadioButton的id，id会自动叠加
        radioGroup.addView(CreateRadioButton.createRadioButton(applicationContext, useRanges1, 1))
        radioGroup.addView(CreateRadioButton.createRadioButton(applicationContext, useRanges2, 2))

        radioGroup.check(checkedIdForRadioButton)
        scrollView.smoothScrollTo(0, 0)

        val sumUpStr = "\n1、“..”符号：是“[,]”区间，如“0..10” 等于 [0,10]\n" +
                "2、“until”：是“[,)”区间，如“0 until 10” 等于 [0,10)\n" +
                "3、“downTo”：是倒序,当如0 downTo 10，得到的结果是“0 downTo 10 step 1”\n" +
                "4、“step”：是获取第0位、第x位以及第x的倍数位的数字，\n" +
                "    如x in 0..10 step 3，得到的是0、3、6、9\n" +
                "    又如x in 10..14 step 3，得到的是10、13"
        tvSumUp.append(sumUpStr)
    }

    override fun iniitListener() {
        btnRun.setOnClickListener { v: View? ->
            when (checkedIdForRadioButton) {
                1 -> tvRunResult.text = useRanges1()
                2 -> tvRunResult.text = useRanges2()
                else -> Snackbar.make(v!!,R.string.error_code, Snackbar.LENGTH_SHORT).show()
            }
        }

        radioGroup.setOnCheckedChangeListener { group, checkedId -> checkedIdForRadioButton = checkedId }
    }

    fun useRanges1(): String {
        var resultForLoop1 = ""
        var resultForLoop2 = ""
        var resultForLoop3 = ""

        for (x in 0..10) {
            resultForLoop1 += x
        }
        for (y in 10 downTo 0) {
            resultForLoop2 += y
        }

        for (z in 0 until 10) {
            resultForLoop3 += z
        }

        var resultForLoop4 = (0 downTo 10)

        return resultForLoop1 +
                "\n" +
                resultForLoop2 +
                "\n" +
                resultForLoop3 +
                "\n" +
                resultForLoop4
    }


    fun useRanges2(): String {
        var resultForLoop1 = ""
        var resultForLoop2 = ""
        var resultForLoop3 = ""
        if (8 in 0..10) {
            resultForLoop1 = "8 in the range"
        }

        if (10 !in 0 until 10) {
            resultForLoop2 = "10 is out of range"
        }

        for (x in 0..10 step 3) {
            resultForLoop3 += x
        }

        return resultForLoop1 +
                "\n" +
                resultForLoop2 +
                "\n" +
                resultForLoop3
    }


}

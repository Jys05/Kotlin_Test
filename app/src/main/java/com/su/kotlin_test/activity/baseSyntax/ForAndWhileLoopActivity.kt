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
 * Created by Mr.Su on 2018/3/3.
 * 关于for 和 while 循环的
 */
class ForAndWhileLoopActivity : BaseActivity() {

    var checkedIdForRadioButton = 1

    val urlForDetails = "https://www.kotlincn.net/docs/reference/control-flow.html#for-循环"
    val urlFlagForDetails = "for循环"
    val urlForDetails2 = "https://www.kotlincn.net/docs/reference/control-flow.html#while-循环"
    val urlFlagForDetails2 = "while循环"

    override fun setKotlinWeb(): String  = "https://www.kotlincn.net/docs/reference/basic-syntax.html#使用-for-循环"

    override fun layoutResId(): Int = R.layout.activity_common_single_radio_group

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

        var forLoop1 = "\n使用 for 循环:\n    fun forLoop2(): String? {  \n" +
                "        var restul: String? = null\n" +
                "        \n" +
                "        val items = listOf(\"apple\", \"banana\", \"kiwi\")\n" +
                "        for (index in items.indices) {\n" +
                "            println(\"item at \$index is \${items[index]}\")\n" +
                "            restul += \"item at \$index is \${items[index]}\" + \"\\n\"\n" +
                "        }\n" +
                "\n" +
                "        return restul\n" +
                "    }"
        var forLoop2 = "\n使用 for 循环2:\n        fun forLoop(): String? {  \n" +
                "        var restul: String? = null\n" +
                "        \n" +
                "        val items = listOf(\"apple\", \"banana\", \"kiwi\")\n" +
                "        for (item in items) {\n" +
                "            println(\"forLoop:\" + item)\n" +
                "            restul += \"forLoop:\" + item + \"\\n\"\n" +
                "        }\n" +
                "\n" +
                "        return restul\n" +
                "    }"
        var whileLoop = "\n使用 while 循环:\n    fun whileLoop(): String? {\n" +
                "        var restul: String? = null\n" +
                "\n" +
                "        val items = listOf(\"apple\", \"banana\", \"kiwi\")\n" +
                "        var index = 0\n" +
                "        while (index < items.size) {\n" +
                "            println(\"item at \$index is \${items[index]}\")\n" +
                "            restul += \"item at \$index is \${items[index]}\"\n" +
                "            index++\n" +
                "        }\n" +
                "\n" +
                "        return restul\n" +
                "    }"

        //若不设置RadioButton的id，id会自动叠加
        radioGroup.addView(CreateRadioButton.createRadioButton(applicationContext, forLoop1, 1))
        radioGroup.addView(CreateRadioButton.createRadioButton(applicationContext, forLoop2, 2))
        radioGroup.addView(CreateRadioButton.createRadioButton(applicationContext, whileLoop, 3))

        radioGroup.check(checkedIdForRadioButton)
        scrollView.smoothScrollTo(0, 0)

        val sumUpStr = "\n首先：\n"+
                "1、for循环——第一种是：作为元素的“in”用法—“item in items”；" +
                "第二种是：作为index的“in”用法—“index in items.indices”，关键是有“.indices”\n"+
                "2、while循环和Java类似\n\n"+
                "说一下listOf和arryOf：\n"+
                "1、listOf:Returns a new read-only list of given elements.  The returned list is serializable (JVM).\n"+
                "——关键read-only list，是一个只读\n"+
                "2、arryOf: Returns an array containing the specified elements." +
                "——在Java转Kotlin中，数组会转成arryOf\n\n"+
                "listOf和arryOf——都是类似的，而且两个都有kotlin的特性会自动识别数据类型\n\n"

        tvSumUp.append(sumUpStr)
    }

    override fun iniitListener() {
        btnRun.setOnClickListener { v: View? ->
            when (checkedIdForRadioButton) {
                1 -> tvRunResult.text = forLoop1()
                2 -> tvRunResult.text = forLoop2()
                3 -> tvRunResult.text = whileLoop()
                else -> Snackbar.make(v!!,R.string.error_code, Snackbar.LENGTH_SHORT).show()
            }
        }

        radioGroup.setOnCheckedChangeListener { group, checkedId -> checkedIdForRadioButton = checkedId }
    }

    fun forLoop1(): String? {
        var restul= ""

        val items = listOf("apple", "banana", "kiwi")
        for (item in items) {
            println(item)
            restul +=  item + "\n"
        }

        return restul
    }

    fun forLoop2(): String? {
        var restul = ""

        val items = listOf("apple", "banana", "kiwi")
        for (index in items.indices) {
            println("item at $index is ${items[index]}")
            restul += "item at $index is ${items[index]}" + "\n"
        }

        return restul
    }

    fun whileLoop(): String? {
        var restul = ""

        val items = listOf("apple", "banana", "kiwi")
        var index = 0
        while (index < items.size) {
            println("item at $index is ${items[index]}")
            restul += "item at $index is ${items[index]}"
            index++
        }

        return restul
    }
}
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
 * 使用集合——界面
 */
class CollectionsActivity : BaseActivity() {

    var checkedIdForRadioButton = 1

    val urlForDetails = "https://www.kotlincn.net/docs/reference/lambdas.html"
    val urlFlagForDetails = "高阶函数及Lambda表达式"

    override fun setKotlinWeb(): String = "https://www.kotlincn.net/docs/reference/basic-syntax.html#使用集合"

    override fun layoutResId(): Int = R.layout.activity_common_single_radio_group

    override fun getIntentExtras(extrasBundle: Bundle) {

    }

    override fun initData() {

    }

    override fun initView() {
        //设置官网链接
//        TvSpanUtil.setTvSpan(tvKotlinWeb, url, url)

        TvSpanUtil.setTvSpan(tvKotlinDetailsWeb, urlForDetails, urlFlagForDetails)

        var collection1 = "\n对集合进行迭代:\n" +
                "    fun collection1(){\n" +
                "        val fruits = listOf(\"banana\", \"avocado\", \"apple\", \"kiwi\")\n" +
                "\n" +
                "        for (item in fruits) {\n" +
                "            println(item)\n" +
                "        }\n" +
                "    }"
        var collection2 = "\n\n使用 in 运算符来判断集合内是否包含某实例：\n" +
                "    fun collection2(){\n" +
                "        val fruits = listOf(\"banana\", \"avocado\", \"apple\", \"kiwi\")\n" +
                "\n" +
                "        when {\n" +
                "            \"orange\" in fruits -> println(\"juicy\")\n" +
                "            \"apple\" in fruits -> println(\"apple is fine too\")\n" +
                "        }\n" +
                "    }"
        var collection3 = "\n\n使用 lambda 表达式来过滤（filter）和映射（map）集合：\n" +
                "    fun collection3(){\n" +
                "        val fruits = listOf(\"banana\", \"avocado\", \"apple\", \"kiwi\")\n" +
                "\n" +
                "        fruits\n" +
                "                .filter { it.startsWith(\"a\") }\n" +
                "                .sortedBy { it }\n" +
                "                .map { it.toUpperCase() }\n" +
                "                .forEach { println(it) }\n" +
                "    }"

        //若不设置RadioButton的id，id会自动叠加
        radioGroup.addView(CreateRadioButton.createRadioButton(applicationContext, collection1, 1))
        radioGroup.addView(CreateRadioButton.createRadioButton(applicationContext, collection2, 2))
        radioGroup.addView(CreateRadioButton.createRadioButton(applicationContext, collection3, 3))

        radioGroup.check(checkedIdForRadioButton)
        scrollView.smoothScrollTo(0, 0)

        val sumUpStr = "\n1、listOf是自动识别类型，而且是这种集合为“只读”。\n" +
                "源代码介绍：Returns a new read-only list of given elements.  The returned list is serializable (JVM).\n\n" +
                "2、这里有when的一种用法:when{...}，里面写进“任何条件”,代码中尝试过加入，如下述：\n\n" +
                "            result.isEmpty() -> result += (\"result is null\" + \" \")\n" +
                "            \"orange\" in fruits -> result += (\"juicy\" + \" \")\n" +
                "            \"apple\" in fruits -> result += (\"apple is fine too\" + \" \")\n\n" +
                "3、就是filter；sortedBy；map；forEach的使用。先看看源代码介绍：\n" +
                "  (a)filter: Returns a list containing only elements matching the given [predicate].\n\n" +
                "  (b)sortedBy: Returns a list of all elements sorted according to natural sort order of the value returned by specified [selector] function.\n\n" +
                "  (c)map:Returns a list containing the results of applying the given [transform] function to each element in the original collection.\n\n" +
                "  (d)forEach:Performs the given [action] on each element.\n" +
                "4、sortedBy：\n" +
                "  (a)尝试过“.sortedBy { it.length }”，会根据String的length排序\n\n" +
                "  (b)sortedBy和Java中List<>类型的sort方法类似，Java中传入的是Comparator(比较器)" +
                "5、map：尝试过“ .map { it + \"_Kotlin\" }”，会对“当前集合”做“{...}”的处理"
        tvSumUp.append(sumUpStr)
    }

    override fun iniitListener() {
        btnRun.setOnClickListener { v: View? ->
            when (checkedIdForRadioButton) {
                1 -> tvRunResult.text = collection1()
                2 -> tvRunResult.text = collection2()
                3 -> tvRunResult.text = collection3()
                else -> Snackbar.make(v!!,R.string.error_code,Snackbar.LENGTH_SHORT).show()
            }
        }

        radioGroup.setOnCheckedChangeListener { group, checkedId -> checkedIdForRadioButton = checkedId }
    }

    fun collection1(): String {
        val fruits = listOf("banana", "avocado", "apple", "kiwi")
        var result = ""
        for (item in fruits) {
            result += (item + " ")
        }
        return result
    }

    fun collection2(): String {
        val fruits = listOf("banana", "avocado", "apple", "kiwi")
        var result = ""
        when {
            result.isEmpty() -> result += ("result is null" + " ")
            "orange" in fruits -> result += ("juicy" + " ")
            "apple" in fruits -> result += ("apple is fine too" + " ")
        }

        return result
    }

    fun collection3(): String {
        val fruits = listOf("banana", "avocado", "apple", "kiwi")
        var result = ""
        fruits
                .filter { it.startsWith("a") }
                .sortedBy { it }
                .map { it }
                .forEach { result += (it + " ") }
        return result
    }
}
package com.su.kotlin.activity.idioms.dtos

import android.os.Bundle
import android.view.View
import com.su.kotlin.R
import com.su.kotlin.frame.BaseActivity
import com.su.kotlin.utils.TvSpanUtil
import kotlinx.android.synthetic.main.activity_common_single_radio_group.*

/**
 * Created by Mr.Su on 2018/3/8.
 * 创建Dtos类——界面
 */
class CreatingDtosActivity : BaseActivity() {

    val urlForDetails = "https://www.kotlincn.net/docs/reference/data-classes.html"
    val urlFlagForDetails = "数据类"

    override fun setKotlinWeb(): String = "https://www.kotlincn.net/docs/reference/idioms.html#创建-dtospojospocos"

    override fun layoutResId(): Int = R.layout.activity_common_single_radio_group

    override fun getIntentExtras(extrasBundle: Bundle) {

    }

    override fun initData() {

    }

    override fun initView() {
        TvSpanUtil.setTvSpan(tvKotlinDetailsWeb, urlForDetails, urlFlagForDetails)

        tvFun.text = "data class User(val name: String, val email: String)"
        var user1 = User("张三", 18)

        btnRun.visibility = View.GONE

        val value0 = "\n var user1 = User(\"张三\", 18)"

        val value1 = "\n\nuser1.name:" + user1.name + "\n" +
                "user1.age:" + user1.age

        user1.age = 20
        val value2 = "\n\n user1.age = 20\n\n" +
                "user1.name:" + user1.name + "\n" +
                "user1.age:" + user1.age

        val value3 = "\n\nuser1.toString():" + user1.toString()

        var user2 = user1.copy()
        val value4 = "\n\n var user2 = user1.copy()：user2.name:" + user2.name + "\n" +
                "user2.age:" + user2.age

        tvRunResult.append(value0)
        tvRunResult.append(value1)
        tvRunResult.append(value2)
        tvRunResult.append(value3)
        tvRunResult.append(value4)

        val sumUpStr = "\n我们经常创建一些只保存数据的类。 在这些类中，一些标准函数往往是从数据机械推导而来的。在 Kotlin 中，这叫做 数据类 并标记为 data：" +
                "\n所有属性的 getters （对于 var 定义的还有 setters）\n" +
                "equals()\n" +
                "hashCode()\n" +
                "toString()\n" +
                "copy()\n" +
                "所有属性的 component1()、 component2()……等等\n\n" +
                "注意：\n" +
                "   1、在 JVM 中，如果生成的类需要含有一个无参的构造函数，则所有的属性必须指定默认值\n" +
                "   2、主构造函数需要至少有一个参数,如下述：\n\n" +
                "data class Customer(var name: String = \"李四\")\n\n" +
                "是可以直接val customer = Customer()\n"

        tvSumUp.append(sumUpStr)
    }

    override fun iniitListener() {

    }
}
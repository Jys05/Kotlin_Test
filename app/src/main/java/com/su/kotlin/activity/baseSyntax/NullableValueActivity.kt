package com.su.kotlin.activity.baseSyntax

import android.os.Bundle
import android.view.View
import com.su.kotlin.R
import com.su.kotlin.frame.BaseActivity
import com.su.kotlin.utils.TvSpanUtil
import kotlinx.android.synthetic.main.activity_nullable_value.*

/**
 * Created by Sujiayong on 2018/2/27.
 * 使用可空值及 null 检测——界面
 */
class NullableValueActivity : BaseActivity() {

    val urlForDetails = "https://www.kotlincn.net/docs/reference/null-safety.html"
    val urlFlagForDetails = "空安全"

    override fun setKotlinWeb(): String = "https://www.kotlincn.net/docs/reference/basic-syntax.html#使用可空值及-null-检测"

    override fun layoutResId(): Int = R.layout.activity_nullable_value

    override fun getIntentExtras(extrasBundle: Bundle) {
    }

    override fun initData() {
    }

    override fun initView() {
        //设置官网链接
//        TvSpanUtil.setTvSpan(tvKotlinWeb, url, url)
        TvSpanUtil.setTvSpan(tvKotlinDetailsWeb, urlForDetails, urlFlagForDetails)

        tvFun.text = "    fun parseInt(str: String): Int? {\n" +
                "        //方法“toIntOrNull()”：str 的内容不是数字返回 null\n" +
                "        return str.toIntOrNull()\n" +
                "    }"


        val sumUpStr = "\n当某个变量的值可以为 null 的时候，必须在声明处的类型后添加 ? 来标识该引用可为空\n" +
                "由于返回值可能为null（空值），所以Int后面加了“?”符号\n" +
                "“?”代表——可能为null，或者说是变量可以为null\n" +
                "注意：String类中toIntOrNull函数方法，是Kotlin的，Java并没有"
        tvSumUp.append(sumUpStr)

        scrollView.smoothScrollTo(0, 0)
    }

    override fun iniitListener() {
        btnRun.setOnClickListener { v: View? ->
            tvRunResult.text = parseInt(etValue.text.toString()).toString()
        }
    }

    fun parseInt(str: String): Int? {
        //方法“toIntOrNull()”：str 的内容不是数字返回 null
        return str.toIntOrNull()
    }
}
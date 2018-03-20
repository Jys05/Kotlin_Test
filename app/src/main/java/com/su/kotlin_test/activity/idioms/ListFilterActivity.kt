package com.su.kotlin_test.activity.idioms

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import com.su.kotlin_test.R
import com.su.kotlin_test.frame.BaseActivity
import kotlinx.android.synthetic.main.activity_list_filter.*

/**
 * Created by Mr.Su on 2018/3/11.
 * 过滤List
 */
class ListFilterActivity : BaseActivity(), View.OnClickListener {

    val mStrList = ArrayList<String>()

    override fun setKotlinWeb(): String = "https://www.kotlincn.net/docs/reference/idioms.html#过滤-list"

    override fun layoutResId(): Int = R.layout.activity_list_filter

    override fun getIntentExtras(extrasBundle: Bundle) {

    }

    override fun initData() {
        tvFun.text = "函数方法:\n" +
                "    private fun listFilterr(): String {\n" +
                "        if (mStrList.size > 0) {\n" +
                "            var newStrList = mStrList.filter { it.length > 4 }\n" +
                "            return newStrList.toString()\n" +
                "        } else {\n" +
                "            return \"\"\n" +
                "        }\n" +
                "    }\n\n" +
                "或者\n\n" +
                "mStrList.filter { x -> x.length > 4 }"

        val sumUpStr = "\nList的filter：“Returns a list containing only elements matching the given [predicate].”\n" +
                "List中不至有filter，还有\n" +
                "  1.map\n" +
                "  2.mapTo\n" +
                "  3.forEach\n" +
                "等等强大的用法"
        tvSumUp.append(sumUpStr)
    }

    override fun initView() {

    }

    override fun iniitListener() {
        btnAdd.setOnClickListener(this)
        btnRun.setOnClickListener(this)
    }

    private fun listFilterr(): String {
        if (mStrList.size > 0) {
            var newStrList = mStrList.filter { it.length > 4 }
            return newStrList.toString()
        } else {
            Toast.makeText(this, getString(R.string.list_empty), Toast.LENGTH_SHORT).show()
            return ""
        }
    }


    override fun onClick(v: View?) {
        when (v!!.id) {
            btnAdd.id -> {
                var valueStr = etValueStr.text.toString().trim()
                if (!TextUtils.isEmpty(valueStr)) {
                    Toast.makeText(this, getString(R.string.added) + valueStr, Toast.LENGTH_SHORT).show()
                    mStrList.add(valueStr)
                } else {
                    Toast.makeText(this, R.string.input_string, Toast.LENGTH_SHORT).show()
                }
            }

            btnRun.id -> {
                tvRunResult.text = listFilterr()
            }

        }
    }
}
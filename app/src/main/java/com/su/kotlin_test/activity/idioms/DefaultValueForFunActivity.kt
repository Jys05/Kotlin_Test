package com.su.kotlin_test.activity.idioms

import android.os.Bundle
import com.su.kotlin_test.R
import com.su.kotlin_test.frame.BaseActivity

/**
 * Created by Mr.Su on 2018/3/8.
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

    }

    override fun iniitListener() {
    }

    fun defautValue(num: Int  , str : String = "This is default value") :String {
        return str+num.toString()
    }
}
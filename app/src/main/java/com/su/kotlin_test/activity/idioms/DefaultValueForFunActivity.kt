package com.su.kotlin_test.activity.idioms

import android.os.Bundle
import com.su.kotlin_test.R
import com.su.kotlin_test.frame.BaseActivity

/**
 * Created by Mr.Su on 2018/3/8.
 */
class DefaultValueForFunActivity : BaseActivity() {

    override fun setLayoutResId(): Int = R.layout.activity_common_for_radio_group

    override fun getIntentExtras(extrasBundle: Bundle) {

    }

    override fun initData() {

    }

    override fun initView() {

    }

    override fun iniitListener() {

    }

    fun defautValue(num: Int = 10 , str : String = "This is default value") {


    }
}
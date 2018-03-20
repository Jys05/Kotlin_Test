package com.su.kotlin_test.activity.idioms

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.su.kotlin_test.R
import com.su.kotlin_test.activity.idioms.dtos.CreatingDtosActivity
import com.su.kotlin_test.frame.BaseActivity
import kotlinx.android.synthetic.main.activity_idioms.*

/**
 * Created by Mr.Su on 2018/3/7.
 * 习惯用法
 */
class IdiomsActivity : BaseActivity(), View.OnClickListener {


    override fun setKotlinWeb(): String="https://www.kotlincn.net/docs/reference/idioms.html"

    override fun layoutResId(): Int = R.layout.activity_idioms

    override fun getIntentExtras(extrasBundle: Bundle) {
        
    }

    override fun initData() {
        
    }

    override fun initView() {
        
    }

    override fun iniitListener() {
        btnCreatingDTOs.setOnClickListener(this)
        btnDefaultValuesForFun.setOnClickListener(this)
        btnListFilter.setOnClickListener(this)
        btnStringInterpolation.setOnClickListener(this)
        btnInstanceChecks.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var intent = Intent()

        when(v!!.id){
            btnCreatingDTOs.id  -> intent.setClass(this , CreatingDtosActivity::class.java)

            btnDefaultValuesForFun.id  -> intent.setClass(this , DefaultValueForFunActivity::class.java)

            btnListFilter.id  -> intent.setClass(this , ListFilterActivity::class.java)

            btnStringInterpolation.id  -> intent.setClass(this , StringInterpolationActivity::class.java)

            btnInstanceChecks.id  -> intent.setClass(this , InstanceChecksActivity::class.java)
        }

        startActivity(intent)

    }
}
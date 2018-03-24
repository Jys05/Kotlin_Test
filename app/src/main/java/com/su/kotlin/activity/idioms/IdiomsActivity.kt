package com.su.kotlin.activity.idioms

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.su.kotlin.R
import com.su.kotlin.activity.idioms.dtos.CreatingDtosActivity
import com.su.kotlin.frame.BaseActivity
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
        btnMapOrPair.setOnClickListener(this)
        btnRang.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var intent = Intent()

        when(v!!.id){
            btnCreatingDTOs.id  -> intent.setClass(this , CreatingDtosActivity::class.java)

            btnDefaultValuesForFun.id  -> intent.setClass(this , DefaultValueForFunActivity::class.java)

            btnListFilter.id  -> intent.setClass(this , ListFilterActivity::class.java)

            btnStringInterpolation.id  -> intent.setClass(this , StringInterpolationActivity::class.java)

            btnInstanceChecks.id  -> intent.setClass(this , InstanceChecksActivity::class.java)

            btnMapOrPair.id  -> intent.setClass(this , MapOrPairActivity::class.java)

            btnRang.id  -> intent.setClass(this , RangActivity::class.java)
        }

        startActivity(intent)

    }
}
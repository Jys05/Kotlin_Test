package com.su.kotlin_test.activity.baseSyntax

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.su.kotlin_test.R
import com.su.kotlin_test.frame.BaseActivity
import kotlinx.android.synthetic.main.activity_base_grammar.*

/**
 * Created by Sujiayong on 2018/2/24.
 */
class BaseSyntaxActivity : BaseActivity(), View.OnClickListener {

    override fun setLayoutResId(): Int = R.layout.activity_base_grammar

    override fun getIntentExtras(extrasBundle: Bundle) {
    }

    override fun initData() {
    }

    override fun initView() {
    }

    override fun iniitListener() {
        btnDefineFun.setOnClickListener(this)
        btnDefineVar.setOnClickListener(this)
        btnComments.setOnClickListener(this)
        btnStringTemplates.setOnClickListener(this)
        btnConditionalExpressions.setOnClickListener(this)
        btnNullableValue.setOnClickListener(this)
        btnTypeChecks.setOnClickListener(this)
        btnForAndWhileLoop.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var intent = Intent()

        when (v?.id) {
        //基本语法——界面
            btnDefineFun.id -> intent.setClass(this, DefineFunActivity::class.java)

            btnDefineVar.id -> intent.setClass(this , DefineVarActivity::class.java)

            btnComments.id -> intent.setClass(this , CommentsActivity::class.java)

            btnStringTemplates.id -> intent.setClass(this , StringTemplatesActivity::class.java)

            btnConditionalExpressions.id -> intent.setClass(this , ConditionalExpressionsActivity::class.java)

            btnNullableValue.id -> intent.setClass(this , NullableValueActivity::class.java)

            btnTypeChecks.id -> intent.setClass(this , TypeChecksActivity::class.java)

            btnForAndWhileLoop.id -> intent.setClass(this , ForAndWhileLoopActivity::class.java)

        }

        startActivity(intent)
    }
}
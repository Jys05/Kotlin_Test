package com.su.kotlin_test.utils

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.widget.RadioButton
import com.su.kotlin_test.R
import java.lang.ref.WeakReference

/**
 * Created by Mr.Su on 2018/2/25.
 *
 * 这里展示的是kotlin中的static的写法（一共有两种写法）：
 * 1、：将class ----> 换成 object  ———— 这种是整个类都会类似static
 * 2、：companion object { ... } 包裹fun函数方法 ———— 这种是特指指定的fun函数方法
 *
 * 注意一：在使用时，导入的包名也不一样。
 * 1、：“import com.su.kotlin_test.utils.CreateRadioButton”
 * 2、：“import com.su.kotlin_test.utils.CreateRadioButton.Companion.createRadioButton”
 *（导入的包名不同，也很容易理解，第二种是在companion内部的，所以......）
 *
 *  注意二：两种写法只能用其一。
 */
class CreateRadioButton {

    companion object {
        /**
         * 原本入参是AppCompatActivity，接着使用弱引用,
         * 发现Context也可以，在Actvity中则直接传入applicationContext
         */
        fun createRadioButton(context: Context, text: String, id: Int): RadioButton {
//            //尝试使用弱引用(原本入参是AppCompatActivity，接着使用弱引用)
//            //发现这样也可以，在Actvity中则直接传入applicationContext
//            val weakActivity = WeakReference<AppCompatActivity>(activity)

            var radioButton = RadioButton(context)

            radioButton.text = text
            radioButton.setTextColor(context!!.resources.getColor(R.color.colorBlack))
            radioButton.id = id   //若不设置RadioButton的id，id会自动叠加

            return radioButton
        }
    }

}
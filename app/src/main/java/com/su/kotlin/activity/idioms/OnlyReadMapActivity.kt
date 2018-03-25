package com.su.kotlin.activity.idioms

import android.os.Bundle
import com.su.kotlin.R
import com.su.kotlin.frame.BaseActivity
import kotlinx.android.synthetic.main.activity_common.*

/**
 * Created by Mr.Su on 2018/3/25.
 * 只读Map,以及访问Map——界面
 */
class OnlyReadMapActivity : BaseActivity() {
    override fun setKotlinWeb(): String = "https://www.kotlincn.net/docs/reference/idioms.html#只读-map"

    override fun layoutResId(): Int = R.layout.activity_common

    override fun getIntentExtras(extrasBundle: Bundle) {

    }

    override fun initData() {
       tvFun.text = "    private fun processMap(): String {\n" +
               "        val onlyReadMap = mapOf(\"key1\" to \"Value1\"\n" +
               "                , \"key2\" to \"Value2\"\n" +
               "                , \"key3\" to \"Value3\")\n" +
               "        var resultStr = \"\"\n" +
               "\n" +
               "        resultStr += \"访问Map：\\n\" +\n" +
               "                \"\${onlyReadMap[\"key1\"]},\\n\" +\n" +
               "                \"\${onlyReadMap[\"key2\"]},\\n\" +\n" +
               "                \"\${onlyReadMap[\"key3\"]},\\n\" +\n" +
               "                \"尝试获取Map不包含的Key：\n" +
               "                \${onlyReadMap[\"key4\"]},\\n\"\n" +
               "\n" +
               "        resultStr += \"\\nmap的“.keys”：\\n\"\n" +
               "        onlyReadMap.keys.forEach { resultStr += (it + \"\\n\") }\n" +
               "\n" +
               "        resultStr += \"\\nmap的“.values”：\\n\"\n" +
               "        onlyReadMap.values.forEach { resultStr += (it + \"\\n\") }\n" +
               "\n" +
               "        return resultStr\n" +
               "    }"


        val sumUpStr = "\nMap：访问方法有：map[key]、map.get(key)、map.getValue(key)\n\n" +
                "map源代码介绍：\n" +
                " * Returns a new read-only map with the specified contents, given as a list of pairs\n" +
                " * where the first value is the key and the second is the value.\n" +
                " *\n" +
                " * If multiple pairs have the same key, the resulting map will contain the value from the last of those pairs.\n" +
                " *\n" +
                " * Entries of the map are iterated in the order they were specified.\n" +
                " *\n" +
                " * The returned map is serializable (JVM)."
        tvSumUp.append(sumUpStr)

    }

    override fun initView() {

    }

    override fun iniitListener() {
        btnRun.setOnClickListener { tvRunResult.text = processMap() }
    }

    private fun processMap(): String {
        val onlyReadMap = mapOf("key1" to "Value1"
                , "key2" to "Value2"
                , "key3" to "Value3")
        var resultStr = ""

        resultStr += "访问Map：\n" +
                "${onlyReadMap["key1"]},\n" +
                "${onlyReadMap["key2"]},\n" +
                "${onlyReadMap["key3"]},\n" +
                "尝试获取Map不包含的Key：${onlyReadMap["key4"]},\n"

        resultStr += "\nmap的“.keys”：\n"
        onlyReadMap.keys.forEach { resultStr += (it + "\n") }

        resultStr += "\nmap的“.values”：\n"
        onlyReadMap.values.forEach { resultStr += (it + "\n") }

        return resultStr
    }


}
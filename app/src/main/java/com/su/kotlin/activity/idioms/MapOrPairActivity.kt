package com.su.kotlin.activity.idioms

import android.os.Bundle
import android.view.View
import com.su.kotlin.R
import com.su.kotlin.frame.BaseActivity
import kotlinx.android.synthetic.main.activity_common.*

/**
 * Created by Mr.Su on 2018/3/20.
 */
class MapOrPairActivity : BaseActivity() {

    override fun setKotlinWeb(): String = "https://www.kotlincn.net/docs/reference/idioms.html#遍历-mappair型list"

    override fun layoutResId(): Int = R.layout.activity_common

    override fun getIntentExtras(extrasBundle: Bundle) {

    }

    override fun initData() {

    }

    override fun initView() {

        tvFun.text = "Map型：\n" +
                "    private fun processMap(): String {\n" +
                "        val hashMap = HashMap<String, String>()\n" +
                "        hashMap.put(\"key1\", \"Value1\")\n" +
                "        hashMap.put(\"key2\", \"Value2\")\n" +
                "        hashMap.put(\"key3\", \"Value3\")\n" +
                "\n" +
                "        var result = \"\"\n" +
                "        for ((k, v) in hashMap) {\n" +
                "            result += \"\$k -> \$v\\n\"\n" +
                "        }\n" +
                "\n" +
                "        return result\n" +
                "    }\n\n" +
                "Pair型List：\n" +
                "    private fun processPairList(): String {\n" +
                "        val pair1 = Pair(\"key1\", \"Value1\")\n" +
                "        val pair2 = Pair(\"key2\", \"Value2\")\n" +
                "        val pair3 = Pair(\"key3\", \"Value3\")\n" +
                "\n" +
                "        val pairList = ArrayList<Pair<String, String>>()\n" +
                "        pairList.add(pair1)\n" +
                "        pairList.add(pair2)\n" +
                "        pairList.add(pair3)\n" +
                "\n" +
                "        var result = \"\"\n" +
                "        for ((k, v) in pairList) {\n" +
                "            result += \"\$k -> \$v\\n\"\n" +
                "        }\n" +
                "        return result\n" +
                "    }"

        val sumUpStr = "\nPair型：\n" +
                "   * Represents a generic pair of two values.\n" +
                "   *\n" +
                "   * There is no meaning attached to values in this class, it can be used for any purpose.\n" +
                "   * Pair exhibits value semantics, i.e. two pairs are equal if both components are equal.\n" +
                "   *\n" +
                "   * @param A type of the first value.\n" +
                "   * @param B type of the second value.\n" +
                "   * @property first First value.\n" +
                "   * @property second Second value.\n" +
                "   * @constructor Creates a new instance of Pair.\n\n" +
                "Map型：\n" +
                "   * A collection that holds pairs of objects (keys and values) and supports efficiently retrieving\n" +
                "   * the value corresponding to each key. Map keys are unique; the map holds only one value for each key.\n" +
                "   * Methods in this interface support only read-only access to the map; read-write access is supported through\n" +
                "   * the [MutableMap] interface.\n" +
                "   * @param K the type of map keys. The map is invariant on its key type, as it\n" +
                "   *          can accept key as a parameter (of [containsKey] for example) and return it in [keys] set.\n" +
                "   * @param V the type of map values. The map is covariant on its value type."
        tvSumUp.append(sumUpStr)

    }

    override fun iniitListener() {
        btnRun.setOnClickListener(View.OnClickListener { tvRunResult.text = processMap() })
    }

    private fun processMap(): String {
        val hashMap = HashMap<String, String>()
        hashMap.put("key1", "Value1")
        hashMap.put("key2", "Value2")
        hashMap.put("key3", "Value3")

        var result = ""
        for ((k, v) in hashMap) {
            result += "$k -> $v\n"
        }

        return result
    }

    private fun processPairList(): String {
        val pair1 = Pair("key1", "Value1")
        val pair2 = Pair("key2", "Value2")
        val pair3 = Pair("key3", "Value3")

        val pairList = ArrayList<Pair<String, String>>()
        pairList.add(pair1)
        pairList.add(pair2)
        pairList.add(pair3)

        var result = ""
        for ((k, v) in pairList) {
            result += "$k -> $v\n"
        }
        return result
    }
}
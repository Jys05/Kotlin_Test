package com.su.kotlin_test.activity.idioms

import android.os.Bundle
import android.util.Log
import com.su.kotlin_test.R
import com.su.kotlin_test.frame.BaseActivity
import kotlinx.android.synthetic.main.activity_list_filter.*

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
        processMap()
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

    }

    val TAG = "MapOrPairActivity"
    private fun processMap() {
        val map = Pair("key1", 12L)
        val map2 = Pair("key2", 12L)
        val map3 = Pair("key3", 12L)

        val mapList = ArrayList<Pair<String, Long>>()
        mapList.add(map)
        mapList.add(map2)
        mapList.add(map3)

        for ((k, v) in mapList) {
          Log.e(TAG ,"processMap:$k -> $v")
        }
    }
}
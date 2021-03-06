package com.su.kotlin.activity.idioms.dtos

/**
 * Created by Mr.Su on 2018/3/11.
 *  * Dtos类（数据传输类）（POJOs/POCOs）
 *
 * 所有属性的 getters （对于 var 定义的还有 setters）
 * equals()
 * hashCode()
 * toString()
 * copy()
 * 所有属性的 component1()、 component2()……等等（参见数据类）
 */
data class Customer(var name: String = "李四")
package com.company.KotlinForAndroid

object myObject {
    val item = "someitem"
    fun say() {
        println("Hello")
    }
}

class Vehicle(var wheels: Int) {
    //    var wheels: Int = 4
//    constructor(wheels: Int){
//        this.wheels = wheels
//    }
    fun getAxles(): Int {
        return wheels / 2
    }
}

fun main() {
//    val v = Vehicle(3)
//    println(v.wheels)
//    println(v.getAxles())
    println(myObject.item)
    myObject.say()
}
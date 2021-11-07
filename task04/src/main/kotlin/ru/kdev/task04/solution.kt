package ru.kdev.task04

fun main(ignored: Array<String>) {
    val myNumber = 0xFF // 8
    println(solution(myNumber))
}

fun solution(number: Int): Int {
    var mutableNumber = (number and 85) + ((number shr 1) and 85)
    mutableNumber = (mutableNumber and 51) + ((mutableNumber shr 2) and 51)
    mutableNumber = (mutableNumber and 15) + (mutableNumber shr 4)
    return mutableNumber
}
package ru.kdev.task03

fun main(ignored: Array<String>) {
    val list = listOf(1, 5, 1, 4, 3, 2, 4, 2, 5)

    println(solution(list))
}

// O(n)
fun solution(list: List<Int>): Int = list.reduce { x, y -> x xor y }
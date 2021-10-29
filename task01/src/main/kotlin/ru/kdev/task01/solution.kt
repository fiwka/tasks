import java.util.*

typealias Guest = Pair<Int, Boolean>

fun main(ignored: Array<String>) {
    val maxNum = 1_000_000_000
    val maxPairs = 1_000_000
    val random = Random()

    fun generatePairs(): List<Guest> {
        val list = mutableListOf<Guest>()

        repeat(random.nextInt(maxPairs)) {
            val oneDate = random.nextInt(maxNum / 2)
            list.add(oneDate to random.nextBoolean())
            list.add(oneDate + random.nextInt(maxNum / 2)  to random.nextBoolean())
        }

        return list
    }

    val pairs = generatePairs().sortedBy(Guest::first)

    var counter = 0
    var answer = 0

    for (pair in pairs) {
        if(pair.second)
            counter++
        else
            counter--

        answer = answer.coerceAtLeast(counter)
    }

    println(answer)
}
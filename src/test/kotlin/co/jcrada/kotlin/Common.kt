package co.jcrada.kotlin

class Adder {
    fun add(o1: Int, o2: Int): Int = o1 + o2
    fun print(param: Int) = println(param)
}

class Multiplier(private val adder: Adder) {
    fun multiple(o1: Int, o2: Int): Int {
        var total = 0
        repeat(o2) { total = adder.add(total, o1) }
        return total
    }

    fun print(param: Int): Unit = adder.print(param)
}
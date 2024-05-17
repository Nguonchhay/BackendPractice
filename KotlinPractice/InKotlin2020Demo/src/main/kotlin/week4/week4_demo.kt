package week4

abstract class Shape {
    abstract fun getArea(): Double
}

class Square(val edge: Double) : Shape() {
    override fun getArea(): Double {
        return edge * edge
    }

    fun getTitle(): String = "Square Class"
}

class Rectangle(val width: Double, val height: Double) : Shape() {
    override fun getArea(): Double {
        return width * height
    }
}

fun shapeDemo() {
    val shapes = mutableListOf<Shape>(
        Square(4.0),
        Rectangle(2.0, 4.0),
        Square(3.0)
    )

    var sum: Double = 0.0
    shapes.forEach {
        sum += it.getArea()
        if (it is Square) {
            val s1 = it as Square
            println("Shape is: ${s1.getTitle()}")
        }
    }
    println("Total Area: $sum")
}

fun week4Main() {
    shapeDemo()
}
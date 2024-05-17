package week2

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

fun week2Main() {
    println("*** Week 2 ***")
    task6()
}

fun task2() {
    println("- Task 2")

//    print("Enter width: ")
//    val width = readLine()!!.toInt()
//
//    print("\nEnter height: ")s
//    val height = readLine()!!.toInt()

    print("Enter width and height: ")
    val (width, height) = readLine()!!.split(' ').map(String::toInt)

    print("\n S = ${width * height}, P = ${2 * (width + height)}")
}

fun task5() {
    println("- Task 5")
//    print("Enter date (MMMM d, yyyy): ")
//    val strDate: String = readLine()!!.toString()
//    val formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH)
//    val bod = LocalDate.parse(strDate, formatter)

    print("Enter date (15.01.1970): ")
//    val splitDate = readLine()!!.toString().split('.')
//    val strDate = "${splitDate[2]}-${splitDate[1]}-${splitDate[0]}"
//    val bod = LocalDate.parse(strDate, DateTimeFormatter.ISO_DATE)
    val currentDate = LocalDate.now()
    print(currentDate)
    val calendar = Calendar.getInstance()
    val currentYear = calendar.get(Calendar.YEAR)
    print(currentYear)
}

fun task6() {
    val str = "hello"
    println(str.replaceFirstChar(Char::titlecase))

    val sentence = listOf("foo", "bar", "baz").map { it.replaceFirstChar(Char::titlecase) }
    println(sentence)
}
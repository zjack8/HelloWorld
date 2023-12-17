import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    print("Enter the first number: ")
    System.out.flush()
    val number1 = scanner.nextLine().toDouble()

    print("Enter the second number: ")
    System.out.flush()
    val number2 = scanner.nextLine().toDouble()

    println("You entered: $number1 and $number2")

    print("Enter an operator (+ - * /): ")
    System.out.flush()
    val operator = scanner.nextLine()

    val result = when (operator) {
        "+" -> number1 + number2
        "-" -> number1 - number2
        "*" -> number1 * number2
        "/" -> if (number2 != 0.0) number1 / number2 else error("Cannot divide by zero.")
        else -> error("Invalid operator. Please enter +, -, *, or /.")
    }

    println("Result: $result")
}

import System.IO

main :: IO ()
main = do
    putStr "Enter the first number: "
    hFlush stdout  -- Flush the output buffer
    input1 <- getLine
    let number1 = read input1 :: Double

    putStr "Enter the second number: "
    hFlush stdout  -- Flush the output buffer
    input2 <- getLine
    let number2 = read input2 :: Double

    putStrLn ("You entered: " ++ show number1 ++ " and " ++ show number2)

    putStr "Enter an operator (+ - * /): "
    hFlush stdout  -- Flush the output buffer
    operator <- getLine
    
    let result = case operator of
            "+" -> number1 + number2
            "-" -> number1 - number2
            "*" -> number1 * number2
            "/" -> if number2 /= 0 then number1 / number2 else error "Cannot divide by zero."
            _   -> error "Invalid operator. Please enter +, -, *, or /."

    putStrLn ("Result: " ++ show result)


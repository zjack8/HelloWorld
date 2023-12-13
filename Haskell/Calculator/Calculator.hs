main :: IO ()
main = do
	putStrLn "Enter the first number:"
	input1 <- getLine
	let number1 = read input1 :: Int

	putStrLn "Enter the second number:"
	input2 <- getLine
	let number2 = read input2 :: Int

	putStrLn ("You entered: " ++ show number1 ++ " and " ++ show number2)

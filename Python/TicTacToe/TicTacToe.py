import random


# define global variables
board = [[" ", " ", " "], [" ", " ", " "], [" ", " ", " "]]
userTeam = "-"
cpuTeam = "-"
winner = "-"

def main():
    # Initialise Game 
    turn = chooseTeam()

    print("===============")
    while not isWinner():
        turn = turn + 1
        nextTurn(turn)
        printBoard()
        print("===============")
    
    print(getWinner())

def chooseTeam():
    while True:
        team = input("Enter Team (X or O): ")
    
        global userTeam
        global cpuTeam

        if team == "X":
            userTeam = "X"
            cpuTeam = "O"
            return -1
        elif team == "O":
            userTeam = "O"
            cpuTeam = "X"
            return 0
        else:
            print("Wrong Input! Try Again")
    
def nextTurn(turn):

    if turn % 2 == 0:
        userTurn()

    else:
        cpuTurn()


def userTurn():

    while True:
        try:
            result = input("Enter Position: ")

            if applyIfValid(result, userTeam):
                return
        except:
            print("Wrong Input! Try Again")

def cpuTurn():

    print("CPU's Response:")

    while True:
        result = getRandomNumberInRange(1, 9)

        if applyIfValid(result, cpuTeam):
            return

def applyIfValid(pos, team):

    pos = int(pos)
    count = 0
    for row in range(0, 3, 1):

        for column in range(0, 3, 1):

            count = count + 1

            if count == pos and board[row][column] == " ":
                board[row][column] = team
                return True
            
    return False

def getWinner():

    if winner == userTeam:
        return "The User Wins!!!"
    
    elif winner == cpuTeam:
        return "The CPU Wins!!!"
    
    else:
        return "There is no Winner!"

def isWinner():

    if checkRows() or checkColumns() or checkDiagonals():
        return True

    if isBoardFull():
        winner = "-"
        return True
    
    return False

def checkRows():

    for i in range (0, 3, 1):

        if board[i][0] == board[i][1] and board[i][1] == board[i][2] and not board[i][0] == " ":
            winner = board[i][0]
            return True
        
    return False

def checkColumns():

    for i in range (0, 3, 1):

        if board[0][i] == board[1][i] and board[1][i] == board[2][i] and not board[0][i] == " ":
            winner = board[0][i]
            return True
        
    return False

def checkDiagonals():

    if board[0][0] == board[1][1] and board[1][1] == board[2][2] and not board[0][0] == " ":
        winner = board[0][0]
        return True
    
    elif board[0][2] == board[1][1] and board[1][1] == board[2][0] and not board[0][2] == " ":
        winner = board[0][2]
        return True
    
    return False

def isBoardFull():

    for i in range (0, 3, 1):
        for j in range (0, 3, 1):

            if board[i][j] == " ":
                return False
            
    return True

def printBoard():

    print(board[0][0]+" | "+board[0][1]+" | "+board[0][2])
    print("--+---+---")
    print(board[1][0]+" | "+board[1][1]+" | "+board[1][2])
    print("--+---+---")
    print(board[2][0]+" | "+board[2][1]+" | "+board[2][2])

def getRandomNumberInRange(min, max):

    if min >= max:
        raise ValueError("Minimum value should be less than or equal to the maximum value.")

    return random.randint(min, max)
    


if __name__ == "__main__":
    main()
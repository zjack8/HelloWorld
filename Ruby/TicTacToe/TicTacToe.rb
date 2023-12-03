
# define global variables
$board = [[" ", " ", " "], [" ", " ", " "], [" ", " ", " "]]
$user_team = "-"
$cpu_eam = "-"
$winner = "-"

def main
    # Initialise Game
    turn = chooseTeam

    puts "==============="
    while not isWinner
        turn = turn + 1
        nextTurn(turn)
        printBoard
        puts "==============="
    end

    puts getWinner
end

def chooseTeam
    # TODO
end

def nextTurn(turn)
    # TODO
end

def userTurn
    # TODO
end

def cpuTurn
    # TODO
end

def applyIfValid(pos, team)
    # TODO
end

def getWinner
    # TODO
end

def isWinner
    # TODO
end

def checkRows
    # TODO
end

def checkColumns
    # TODO
end

def checkDiagonals
    # TODO
end

def isBoardFull
    # TODO
end

def print_board
    puts board[0][0]+" | "+board[0][1]+" | "+board[0][2]
    puts "--+---+---"
    puts board[1][0]+" | "+board[1][1]+" | "+board[1][2]
    puts "--+---+---"
    puts board[2][0]+" | "+board[2][1]+" | "+board[2][2]
end

def getRandomNumberInRange(min, max)
    # TODO
end

# Execute main function
main

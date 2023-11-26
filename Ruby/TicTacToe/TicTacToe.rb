
def main
    # Initialise Game 
    turn = chooseTeam

    puts "==============="
    while not isWinner:
        turn = turn + 1
        nextTurn(turn)
        printBoard
        puts "==============="
        
    puts getWinner

def chooseTeam
    # TODO

def isWinner
    # TODO

def nextTurn(turn)
    # TODO

def printBoard
    # TODO

def getWinner
    # TODO
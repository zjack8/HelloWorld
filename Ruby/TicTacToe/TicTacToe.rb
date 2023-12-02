
def main
    # Initialise Game
    turn = choose_team

    puts "==============="
    while not is_winner
        turn = turn + 1
        next_turn(turn)
        print_board
        puts "==============="
    end

    puts get_winner
end

def choose_team
    # TODO
end

def next_turn(turn)
    # TODO
end

def user_turn
  loop do
    begin
      print 'Enter Position: '
      string_pos = gets.chomp
      result = Integer(string_pos)
      return if apply_if_valid(result, user_team)
    rescue ArgumentError
      puts 'Wrong Input! Try Again'
    end
  end
end

def cpu_turn
  puts "CPU's Response:"
  loop do
    result = rand(1..9)
    return if apply_if_valid(result, cpu_team)
  end
end

def apply_if_valid(pos, team)
  # Map number pad positions to Tic Tac Toe board positions
  position_mapping = [
    [7, 8, 9],
    [4, 5, 6],
    [1, 2, 3]
  ]

  (0..2).each do |row|
    (0..2).each do |column|
      if position_mapping[row][column] == pos && board[row][column] == ' '
        board[row][column] = team
        return true
      end
    end
  end
  false
end

def get_winner
  if winner == user_team
    'The User Wins!!!'
  elsif winner == cpu_team
    'The CPU Wins!!!'
  else
    'There is no Winner!'
  end
end
  

def is_winner
    # TODO
end

def check_rows
    # TODO
end

def check_columns
    # TODO
end

def check_diagonals
    # TODO
end

def is_board_full
    # TODO
end

def print_board
    # TODO
end

# Execute main function
main

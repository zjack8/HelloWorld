class TicTacToe
	def initialize
	  @board = [[' ', ' ', ' '], [' ', ' ', ' '], [' ', ' ', ' ']]
	  @user_team = '-'
	  @cpu_team = '-'
	  @winner = '-'
	end
  
	def main
	  # Initialize Game
	  turn = choose_team
  
	  puts '==============='
	  until is_winner
		turn = turn + 1
		next_turn(turn)
		print_board
		puts '==============='
	  end
  
	  puts get_winner
	end
  
	def choose_team
	  loop do
		puts 'Enter Team (X or O): '
		team = gets.chomp
  
		if team == 'X'
		  @user_team = 'X'
		  @cpu_team = 'O'
		  return -1
		elsif team == 'O'
		  @user_team = 'O'
		  @cpu_team = 'X'
		  return 0
		else
		  print('Wrong Input! Try Again')
		end
	  end
	end
  
	def next_turn(turn)
	  turn % 2 == 0 ? user_turn : cpu_turn
	end
  
	def user_turn
	  loop do
		print 'Enter Position: '
		string_pos = gets.chomp
		result = Integer(string_pos)
		return if apply_if_valid(result, @user_team)
  
	  rescue ArgumentError
		puts 'Wrong Input! Try Again'
	  end
	end
  
	def cpu_turn
	  puts "CPU's Response:"
	  loop do
		result = rand(1..9)
		return if apply_if_valid(result, @cpu_team)
	  end
	end
  
	def apply_if_valid(pos, team)
	  position_mapping = [
		[7, 8, 9],
		[4, 5, 6],
		[1, 2, 3]
	  ]
  
	  3.times do |row|
		3.times do |column|
		  if position_mapping[row][column] == pos && @board[row][column].strip.empty?
			@board[row][column] = team
			return true
		  end
		end
	  end
	  false
	end
  
	def get_winner
	  if @winner == @user_team
		'The User Wins!!!'
	  elsif @winner == @cpu_team
		'The CPU Wins!!!'
	  else
		'There is no Winner!'
	  end
	end
  
	def is_winner
	  return true if check_rows || check_columns || check_diagonals
  
	  if is_board_full
		@winner = '-'
		return true
	  end
  
	  false
	end
  
	def check_rows
	  3.times do |i|
		if @board[i][0] == @board[i][1] && @board[i][1] == @board[i][2] && !@board[i][0].strip.empty?
		  @winner = @board[i][0]
		  return true
		end
	  end
	  false
	end
  
	def check_columns
	  3.times do |i|
		if @board[0][i] == @board[1][i] && @board[1][i] == @board[2][i] && !@board[0][i].strip.empty?
		  @winner = @board[i][0]
		  return true
		end
	  end
	  false
	end
  
	def check_diagonals
	  if @board[0][0] == @board[1][1] && @board[1][1] == @board[2][2] && !@board[0][0].strip.empty?
		@winner = @board[0][0]
		return true
	  elsif @board[0][2] == @board[1][1] && @board[1][1] == @board[2][0] && !@board[0][2].strip.empty?
		@winner = @board[0][2]
		return true
	  end
	  false
	end
  
	def is_board_full
		@board.flatten.none? { |cell| cell.strip.empty? }
	  end
	  
  
	def print_board
	  puts @board[0].join(' | ')
	  puts '--+---+---'
	  puts @board[1].join(' | ')
	  puts '--+---+---'
	  puts @board[2].join(' | ')
	end
  end
  
  # Instantiate the class and execute main function
  TicTacToe.new.main
  
Description
Implement a program that determines the loser of the Slides and Ladders game based on the given inputs.
Input:
1. Number of players
2. Players names
3. Starting player name
4. Count of the dice thrown
5. Dice values
Output:
1. The output should consist of the player's name, their current position, the remaining count to win the game, the number of slides used and the number of ladders used. This should be separated using the pipe symbol ("|"). For example, the output should look like: John|21|4|1|1
2. Name of the players who loss the game
Constraints:
1. The dice value must be an integer between 1 and 6.
2. Players will be seated in clockwise direction starting from the received input. Only when the player gets a '1' they will start moving ahead.
3. If two players occupy the same cell, the first player will be returned to the starting position. Players are granted an extra opportunity if they roll a dice value of 1 or 5, while for any other value, the next player will proceed.
5. When a player lands on a cell with a slider head, they move their position backward to the tail of the slider. Conversely, when they land on a cell with a ladder's base, they will move their position forward to the top of the ladder.
6. The player will be declared as the winner when they reach position 25 and the game will be stopped.
7. If the player's position exceeds 25 after rolling the dice, they will remain idle in their current position.
Note:
If no one won the game, print as "Game tie" after printing the players name, position and all. For
example,
John|21|4|1|1
Nick|20|5|1|2
Game tie
Please check the board for sliders and ladders

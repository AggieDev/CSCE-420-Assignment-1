CSCE-420-Assignment-1
=====================

Artificial Intelligence Java Assignment - In a peg game, recursively find all possible move solutions

The goal of the game is that the triangular board of 10 pegs has 1 hole and a peg in each of the others, and you may 
jump a peg into the hole and remove the jumped peg. You keep doing this until you run out of moves, the goal is to 
have one peg remaining before running out of moves. 

This program creates a Game Tree for this game, playing every possible combination of the game (using recursion)
to finish.

This program answers 2 questions: 1) How many game combinations end with a single peg.
                                  2) How many game combinations end with a single peg in a corner.
                                  
if the game starts like this    0
                               1 1
                              1 1 1
                             1 1 1 1
                            1 1 1 1 1

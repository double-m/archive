package com.marcellomessori.bowlingscore;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App 
{
    public static void main( String[] args )
    {
		try {
			Game game = new Game();
			game.init(0);
			
			game.roll(1); game.roll(4);
			
			game.roll(4); game.roll(5);
			
			game.roll(6); game.roll(4);
			
			game.roll(5); game.roll(5);
			
			game.roll(10);
			
			game.roll(0); game.roll(1);
			
			game.roll(7); game.roll(3);
			
			game.roll(6); game.roll(4);
			
			game.roll(10);
			
			game.roll(2); game.roll(8);
			game.roll(6); // extra ball

			System.out.println("The score of the game is " + game.score() + "!\n");
		} catch (Exception ex) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}
    }
}

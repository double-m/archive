package com.marcellomessori.bowlingscore;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private Game game;
	
    @Before
    public void setUp() {
		game = new Game();
    }

	@Test
	public void shouldReturnTheFinalResultGivenByTheExample() throws Exception {
		game.init(0);

		game.roll(1);
		game.roll(4);
		
		game.roll(4);
		game.roll(5);
		
		game.roll(6);
		game.roll(4);
		
		game.roll(5);
		game.roll(5);
		
		game.roll(10);
		
		game.roll(0);
		game.roll(1);
		
		game.roll(7);
		game.roll(3);
		
		game.roll(6);
		game.roll(4);
		
		game.roll(10);
		
		game.roll(2);
		game.roll(8);
		game.roll(6); // extra ball
		
		assertEquals(133, game.score());
	}
	
	@Test
	public void shouldComputeAFrameGivenAnInitialization() throws Exception {
		game.init(5);

		game.roll(4);
		game.roll(5);
		
		assertEquals(14, game.score());
	}
	
	@Test
	public void shouldComputeAFrameWithASpare() throws Exception {
		game.init(0);

		game.roll(6);
		game.roll(4);
		int pinsNextRoll = 5;
		game.roll(pinsNextRoll);
		
		assertEquals(10 + pinsNextRoll*2, game.score());
	}
	
	@Test
	public void shouldComputeAFrameWithAStrike() throws Exception {
		game.init(0);

		game.roll(10);
		int pinsNextRoll1 = 1;
		int pinsNextRoll2 = 2;
		game.roll(pinsNextRoll1);
		game.roll(pinsNextRoll2);
		
		assertEquals(10 + pinsNextRoll1*2 + pinsNextRoll2*2, game.score());
	}
	
	@Test
	public void shouldThrowAnExceptionInCaseOfExtraRolls() throws Exception {
		game.init(0);

		for (int pins = 0; pins < 10; pins++) {
			game.roll(1);
			game.roll(2);
		}
		
		try {
			game.roll(1);
			fail("Should have thrown an exception");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void shouldThrowAnExceptionInCaseOfExtraRollsAfterSpare() throws Exception {
		game.init(0);

		// frames 1 to 9
		for (int pins = 0; pins < 9; pins++) {
			game.roll(5);
			game.roll(0);
		}
		// frame 10: spare
		game.roll(5);
		game.roll(5);
		// extra ball
		game.roll(1);
		
		try {
			game.roll(1);
			fail("Should have thrown an exception");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void shouldThrowAnExceptionInCaseOfExtraRollsAfterStrike() throws Exception {
		game.init(0);

		// frames 1 to 9
		for (int pins = 0; pins < 9; pins++) {
			game.roll(5);
			game.roll(0);
		}
		// frame 10: strike
		game.roll(10);
		// extra ball
		game.roll(1);
		game.roll(1);
		
		try {
			game.roll(1);
			fail("Should have thrown an exception");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void shouldManageTheExtraBallOnSpare() throws Exception {
		game.init(0);

		// frames 1 to 9
		for (int pins = 0; pins < 9; pins++) {
			game.roll(5);
			game.roll(0);
		}
		// frame 10: spare
		game.roll(5);
		game.roll(5);
		// extra ball
		game.roll(5);
		
		assertEquals(60, game.score());
	}
	
	@Test
	public void shouldManageTheExtraBallOnStrike() throws Exception {
		game.init(0);

		// frames 1 to 9
		for (int pins = 0; pins < 9; pins++) {
			game.roll(5);
			game.roll(0);
		}
		// frame 10: strike
		game.roll(10);
		// extra ball
		game.roll(1);
		game.roll(1);
		
		assertEquals(45 + 10 + 1 + 1, game.score());
	}
}


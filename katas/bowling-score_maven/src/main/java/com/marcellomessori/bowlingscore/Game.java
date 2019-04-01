package com.marcellomessori.bowlingscore;

class Game {

	private int score;
	private boolean isSecondRollOfAFrame;
	private int valueOfPreviousRollWas;
	private int rollLeftToAddForSpareOrStrike;
	private int frame;
	
	public void roll(int pins) throws Exception {
		boolean isTheExtraBall = checkExtraBall();
		checkBonus(pins);
		
		if (!isTheExtraBall) {
			score += pins;
			setStatusForTheNextRoll(pins);
		}
	}

	public int score() {
		return score;
	}

	public void init(int previousScore) {
		score = previousScore;
		isSecondRollOfAFrame = false;
		valueOfPreviousRollWas = 0;
		rollLeftToAddForSpareOrStrike = 0;
		frame = 0;
	}

	private void setStatusForTheNextRoll(int pins) {
		boolean isSpare = isSecondRollOfAFrame && valueOfPreviousRollWas + pins == 10;
		boolean isStrike = !isSecondRollOfAFrame && pins == 10;
		
		if (isSpare) {
			rollLeftToAddForSpareOrStrike = 1;
		}

		if (isStrike) {
			rollLeftToAddForSpareOrStrike = 2;
		}
		
		if (!isStrike) {
			isSecondRollOfAFrame = !isSecondRollOfAFrame;
		}
		
		valueOfPreviousRollWas = pins;
	}

	private void updateFrame() {
		if (!isSecondRollOfAFrame) {
			frame++;
		}
	}

	private boolean checkExtraBall() throws Exception {
		boolean isAnExtraBall = false;
		
		updateFrame();

		if ( frame > 10 && !isSecondRollOfAFrame) {
			if (rollLeftToAddForSpareOrStrike > 0) {
				isAnExtraBall = true;
			}
			else {
				throw new Exception("Exceeded number of frames: this roll started frame number " + frame + " (only 10 allowed)");
			}
		}
		
		return isAnExtraBall;
	}

	private void checkBonus(int pins) {
		if (rollLeftToAddForSpareOrStrike > 0) {
			score += pins;
			rollLeftToAddForSpareOrStrike--;
		}
	}
}

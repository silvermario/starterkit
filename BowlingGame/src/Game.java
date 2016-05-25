
public class Game implements BowlingGameResultCalculator {

	public static void main(String[] args) {
		
	}
	
	private int rolls[] = new int[21];
	private int currentRoll = 0;
	private int currentFrame = 1;
	private int rollsRolledInFrame = 0;

	@Override
	public void roll(int numberOfPins) {
		//System.out.println("numberOfPins " + numberOfPins);
		rolls[currentRoll++] = numberOfPins;
		
		increaseFrameCounter(numberOfPins);		
	}

	@Override
	public int score() {
		int score = 0;
		int rollIndex = 0;
		for(int frame = 0; frame < currentFrame; frame++) {
			if(isStrike(rollIndex)) {
				score += 10 + rolls[rollIndex+1] + rolls[rollIndex+2];
				rollIndex++;
			} else if(isSpare(rollIndex)) {
				score += 10 + rolls[rollIndex+2];
				rollIndex += 2;
			} else {
				score += rolls[rollIndex] + rolls[rollIndex+1];
				rollIndex += 2;
			}
		}		
		return score;
	}

	@Override
	public boolean isFinished() {
		if(currentFrame == 10) {
			// scored less than 10 pins in 2 rolls in last frame
			if(rollsRolledInFrame == 2 && (rolls[currentRoll-1] + rolls[currentRoll-2]) < 10) {
				return true;
			} else if(rollsRolledInFrame == 3) {
				return true;
			} 
		}
		return false;		
	}
	
	private boolean isSpare(int rollIndex){
		return rolls[rollIndex] + rolls[rollIndex + 1] == 10;
	}
	
	private boolean isStrike(int rollIndex){
		return rolls[rollIndex] == 10;
	}
	
	private void increaseFrameCounter(int numberOfPins){	
		rollsRolledInFrame++;
		//increase frame counter after second roll or strike			
		if(currentFrame != 10){
			if(rollsRolledInFrame == 2 || numberOfPins == 10) {
				currentFrame++;
				rollsRolledInFrame = 0;
			}
		}
	}

}

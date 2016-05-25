import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class BowlingGameTest {
	
	Game g;
	
	@Before
	public void setUp(){
		g = new Game();		
	}
	
	public void rollMany(int numberOfRolls, int numberOfPins) {
		for (int i = 0; i < numberOfRolls; i++) {
			g.roll(numberOfPins);
		}
	}
	
	public void rollSpare(int firstRoll, int secondRoll){
		g.roll(firstRoll);
		g.roll(secondRoll);
	}
	
	@Test
	public void shouldReturnAllMissedShotsScore() {				
		rollMany(20, 0);
		assertEquals(0, g.score());
	}
	
	@Test
	public void shouldReturnAllOnesScore() {				
		rollMany(20, 1);
		assertEquals(20, g.score());		
	}
	
	@Test
	public void testOneSpare() {
		rollSpare(5, 5);
		g.roll(4);
		g.roll(5);
		assertEquals(23, g.score());		
	}
	
	@Test
	public void testNineSpares() {
		for ( int i = 0; i < 9; i++) {
			rollSpare(9, 1);			
		}		
		assertEquals(162, g.score());		
	}
	
	@Test
	public void testOneStrike() {
		g.roll(10);
		g.roll(4);
		g.roll(5);
		rollMany(17, 0);
		assertEquals(28, g.score());		
	}
	
	@Test
	public void shouldNotFinishGameOnLastFrameSpare(){
		g.roll(10);
		rollMany(14, 0);
		rollSpare(9, 1); // frame 9
		rollSpare(9, 1); // frame 10
		assertEquals(false, g.isFinished());
	}
	
	@Test
	public void shouldFinishGameOnLastFrameWithoutSpare(){
		g.roll(10);
		rollMany(14, 0);
		rollSpare(9, 1); // frame 9
		g.roll(9); // frame 10
		g.roll(0); // frame 10
		assertEquals(true, g.isFinished());	
	}
	
	@Test
	public void shouldNotFinishGameOnLastFrameWithTwoStrikes(){
		g.roll(10);
		rollMany(14, 0);
		rollSpare(9, 1); // frame 9
		g.roll(10); // frame 10
		g.roll(10); // frame 10
		assertEquals(false, g.isFinished());		
	}
	
	@Test
	public void shouldFinishGameOnLastFrameWithTwoStrikesAndARoll(){
		g.roll(10);
		rollMany(14, 0);
		rollSpare(9, 1); // frame 9
		g.roll(10); // frame 10
		g.roll(10); // frame 10
		g.roll(2); // frame 10
		assertEquals(true, g.isFinished());		
	}
	
	@Test
	public void testThreeStrikesInLastFrame(){
		g.roll(10);
		rollMany(14, 0);
		rollSpare(9, 1); // frame 9
		g.roll(10); // frame 10
		g.roll(10); // frame 10
		g.roll(10); // frame 10
		assertEquals(60, g.score());
	}
	
	@Test
	public void testPerfectGame(){
		rollMany(12, 10);
		assertEquals(300, g.score());
	}
	
	@Test
	public void testTwoStrikesInLastFrame(){
		rollMany(16, 0);
		rollSpare(9, 1); // frame 9
		g.roll(10); // frame 10
		g.roll(10); // frame 10
		assertEquals(10, g.score());
	}
}

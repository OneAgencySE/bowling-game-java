package bowlinggame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void allRollsInTheGutter() {
        manyRolls(20, 0);

        assertEquals(game.getScore(), 0);
    }

    @Test
    public void allRollsHitOnePin() {
        manyRolls(20, 1);

        assertEquals(game.getScore(), 20);
    }

    @Test
    public void rollsOneSpare() {
        rollSpare();
        game.roll(3);
        manyRolls(17, 0);

        assertEquals(game.getScore(), 16);
    }

    @Test
    public void rollsOneStrike() {
        rollStrike();
        game.roll(4);
        game.roll(3);
        manyRolls(16, 0);

        assertEquals(game.getScore(), 24);
    }

    @Test
    public void rollsPerfectGame() {
        manyRolls(20, 10);

        assertEquals(game.getScore(), 300);
    }

    private void manyRolls(int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollStrike() {
        game.roll(10);
    }
}

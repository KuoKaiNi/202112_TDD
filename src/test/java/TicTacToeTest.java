import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TicTacToeTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private TicTacTeoGame game;

    @Before
    public final void before(){
        game = new TicTacTeoGame();
    }

    @Test
    public void whenPutPieceinSpaceAreaThenSucess(){
        game.play(2, 2);
        Assert.assertEquals("O", game.getPiece(2, 2));
        game.play(1, 1);
        Assert.assertEquals("X", game.getPiece(1, 1));
    }

    @Test
    public void whenXOutsideBoardThenThrowRuntimeException(){
        expectedException.expect(RuntimeException.class);
        game.play(5, 2);
    }

    @Test
    public void whenYOutsideBoardThenThrowRuntimeException() {
        expectedException.expect(RuntimeException.class);
        game.play(2, 5);
    }

    @Test
    public void whenPutPieceInNonSpaceAreaThenThrowRuntimeException(){
        expectedException.expect(RuntimeException.class);
        game.play(2,2);
        game.play(2, 2);
    }

    @Test
    public void whenStartGameAndThreeSamePieceLineinThenFirstPlayerWin(){
        game.play(2,2);
        Assert.assertEquals(false, game.isWin());
        game.play(1,1);
        Assert.assertEquals(false, game.isWin());
        game.play(2, 1);
        Assert.assertEquals(false, game.isWin());
        game.play(3, 1);
        Assert.assertEquals(false, game.isWin());
        game.play(2, 3);
        Assert.assertEquals(true, game.isWin());
        Assert.assertEquals("O", game.getWinner());
    }

    @Test
    public void whenStartGameAndThreeSamePieceLineinThenSecondPlayerWin(){
        game.play(1, 1);  // O
        Assert.assertEquals(false, game.isWin());
        game.play(1, 2); // X
        Assert.assertEquals(false, game.isWin());
        game.play(2, 1); // O
        Assert.assertEquals(false, game.isWin());
        game.play(2, 2); // X
        Assert.assertEquals(false, game.isWin());
        game.play(1, 3); // O
        Assert.assertEquals(false, game.isWin());
        game.play(3,2); // X
        Assert.assertEquals(true, game.isWin());
        Assert.assertEquals("X", game.getWinner());
    }

    @Test
    public void whenGameStartAndDiagonalHasThreePieceLineinThenFirstPlayerWin(){
        game.play(1, 1);
        Assert.assertEquals(false, game.isWin());
        game.play(2, 1);
        Assert.assertEquals(false, game.isWin());
        game.play(2,2);
        Assert.assertEquals(false, game.isWin());
        game.play(3, 1);
        Assert.assertEquals(false, game.isWin());
        game.play(3,3);
        Assert.assertEquals(true, game.isWin());
        Assert.assertEquals("O", game.getWinner());
    }

    @Test
    public void whenGameStartAndDiagonalHasThreePieceLineinThenSecondPlayerWin(){
        game.play(2, 1);
        Assert.assertEquals(false, game.isWin());
        game.play(3, 1);
        Assert.assertEquals(false, game.isWin());
        game.play(1,2);
        Assert.assertEquals(false, game.isWin());
        game.play(2, 2);
        Assert.assertEquals(false, game.isWin());
        game.play(3,3);
        Assert.assertEquals(false, game.isWin());
        game.play(1, 3);
        Assert.assertEquals(true, game.isWin());
        Assert.assertEquals("X", game.getWinner());
    }

    @Test
    public void whenAllBoxesAreFilledThenDraw(){
        game.play(1, 1);
        game.play(2, 2);
        game.play(3, 3);
        game.play(2, 1);
        game.play(2, 3);
        game.play(1, 3);
        game.play(3, 1);
        game.play(3, 2);
        game.play(1, 2);
        Assert.assertEquals(false, game.isWin());
        Assert.assertEquals(true, game.isDraw());
    }

    @Test
    public void whenNoOneWintTheGameThenNoWin(){
        Assert.assertEquals(false, game.isDraw());
        Assert.assertEquals(false, game.isWin());
    }
}

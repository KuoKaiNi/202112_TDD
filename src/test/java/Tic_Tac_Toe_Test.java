import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class Tic_Tac_Toe_Test {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private TicTacTeo ticTacTeo;

    @Before
    public final void before(){
        ticTacTeo = new TicTacTeo();
    }

    @Test
    public void whenXOutsideBoardThenThrowRuntimeException() {
        exception.expect(RuntimeException.class);
        ticTacTeo.play(5, 2);
    }

    @Test
    public void whenYOutsideBoardThenThrowRuntimeException() {
        exception.expect(RuntimeException.class);
        ticTacTeo.play(2, 5);
    }

    @Test
    public void whenPutTwoSymbolAtSamePositionThenThrowRuntimeException(){
        exception.expect(RuntimeException.class);
        ticTacTeo.play(2, 2);
        ticTacTeo.play(2, 2);
    }

    @Test
    public void whenPutInBoardThenChcekThePosition(){
        ticTacTeo.play(2,2);
        Assert.assertEquals("O", ticTacTeo.checkPositionResult(2, 2));
    }

    @Test
    public void whenPlayOneRoundThenCheckBoard() {
        ticTacTeo.play(2, 2);
        ticTacTeo.play(1,1);
        ticTacTeo.play(1, 2);
        Assert.assertEquals("O", ticTacTeo.checkPositionResult(2, 2));
        Assert.assertEquals("X", ticTacTeo.checkPositionResult(1, 1));
    }

    @Test
    public void whenThreeSymoblLineinThenWin(){
        ticTacTeo.play(2, 2);
        ticTacTeo.play(1, 1);
        ticTacTeo.play(1, 2);
        ticTacTeo.play(3, 3);
        ticTacTeo.play(3,2);
        Assert.assertEquals(true, ticTacTeo.isWin());
        Assert.assertEquals("O", ticTacTeo.winner());
    }

    @Test
    public void whenDiagonalHasThreeSymbolLineinThenWin(){
        ticTacTeo.play(2,2);
        ticTacTeo.play(2, 1);
        ticTacTeo.play(1, 1);
        ticTacTeo.play(2,3);
        ticTacTeo.play(3,3);
        Assert.assertEquals(true, ticTacTeo.isWin());
        Assert.assertEquals("O", ticTacTeo.winner());
    }


    @Test
    public void whenAllBoxesAreFilledThenDraw(){
        ticTacTeo.play(1, 1);
        ticTacTeo.play(1, 2);
        ticTacTeo.play(1, 3);
        ticTacTeo.play(2, 1);
        ticTacTeo.play(2, 2);
        ticTacTeo.play(2, 3);
        ticTacTeo.play(3, 1);
        ticTacTeo.play(3, 2);
        ticTacTeo.play(3, 3);
        Assert.assertEquals(true, ticTacTeo.isDraw());
    }
}

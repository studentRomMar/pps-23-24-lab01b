package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GamePieceTest {

    public static final int SIZE = 5;
    private GamePiece knight;
    private GamePiece pawn;

    @BeforeEach
    public void createPieces() {
        this.knight = new Knight(2,2);
        this.pawn = new Pawn(1,3);
    }

    @Test
    public void correctlyCreateKnight() {
        assertEquals(new Pair<Integer, Integer>(2, 2), this.knight.getPosition());
    }

    @Test
    public void correctlyCreatePawn() {
        assertEquals(new Pair<Integer, Integer>(1, 3), this.pawn.getPosition());
    }


}

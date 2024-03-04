package e1;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class LogicTest {

  private static final int SIZE_TABLE = 5;

  private Logics logic;

  @Test
  public void correctlyCreatedKnight() {
    this.logic = new LogicsImpl(SIZE_TABLE);
    //Test the creation of Knight, but not in the first cell
    boolean cellHasKnight = this.logic.hasKnight(1, 1);
    assertFalse(cellHasKnight);
  }

  @Test
  void correctlyCreatedPawn() {
    this.logic = new LogicsImpl(SIZE_TABLE);
    //Test the creation of Pawn, but not in the first cell
    boolean cellHasPawn = this.logic.hasPawn(1, 1);
    assertFalse(cellHasPawn);
  }

  @Test
  public void throwsExceptionWhenOutOfTable() {
    this.logic = new LogicsImpl(SIZE_TABLE);
    assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(-1, -1));
  }

  @Test
  public void throwsExceptionOnTableBorder() {
    this.logic = new LogicsImpl(SIZE_TABLE);
    assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(SIZE_TABLE, SIZE_TABLE));
  }

  @Test
  public void hitCorrectlyFunctioning() {
    this.logic = new LogicsImpl(SIZE_TABLE, new Pair<>(2,2), new Pair<>(4,1));
    assertTrue(this.logic.hit(4,1));
  }

  @Test
  public void test() {
    // You can generate random inputs and assert the expected output
    // For example:
    // int result = Logic.someMethod(5, 10);
    // assertEquals(expectedResult, result);

    this.logic = new LogicsImpl(SIZE_TABLE);
    //Test the creation of Knight, but not in the first cell
    boolean cellHasKnight = this.logic.hasKnight(1, 1);
    assertFalse(cellHasKnight);
    //Test the creation of Pawn, but not in the first cell
    boolean cellHasPawn = this.logic.hasPawn(1, 1);
    assertFalse(cellHasPawn);

    //Test hit()'s exceptions
    assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(-1, -1));
    assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(SIZE_TABLE, SIZE_TABLE));

    this.logic = new LogicsImpl(SIZE_TABLE, new Pair<>(2,2), new Pair<>(4,1));
    assertTrue(this.logic.hit(4,1));
  }
}

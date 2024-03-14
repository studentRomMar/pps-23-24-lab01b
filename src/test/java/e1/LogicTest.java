package e1;
import e1.logic.Logics;
import e1.logic.LogicsImpl;
import e1.utils.Pair;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class LogicTest {

  private static final int SIZE_TABLE = 5;

  private Logics logic;

  @BeforeEach
  public void createTableTest() {
    this.logic = new LogicsImpl(SIZE_TABLE, new Pair<>(2,2), new Pair<>(4,1));
  }

  @Test
  public void correctlyCreatedKnight() {
    boolean cellHasKnight = this.logic.hasKnight(2, 2);
    assertTrue(cellHasKnight);
  }

  @Test
  void correctlyCreatedPawn() {
    boolean cellHasPawn = this.logic.hasPawn(4, 1);
    assertTrue(cellHasPawn);
  }

  @Test
  public void throwsExceptionWhenOutOfTable() {
    assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(-1, -1));
  }

  @Test
  public void throwsExceptionOnTableBorder() {
    assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(SIZE_TABLE, SIZE_TABLE));
  }

  @Test
  public void ExceptionWhenOutOfTablePlaying() {
    assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(SIZE_TABLE - 1, SIZE_TABLE));
  }

  @Test
  public void hitCorrectlyFunctioning() {
    assertTrue(this.logic.hit(4,1));
  }

}

package e1;
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
    boolean cellHasKnight = this.logic.hasKnight(1, 1);
    assertFalse(cellHasKnight);
  }

  @Test
  void correctlyCreatedPawn() {
    boolean cellHasPawn = this.logic.hasPawn(1, 1);
    assertFalse(cellHasPawn);
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
  public void hitCorrectlyFunctioning() {
    assertTrue(this.logic.hit(4,1));
  }

}

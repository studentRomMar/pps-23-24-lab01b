package e1;

import java.util.Random;

public class Pawn implements GamePiece {

    private Pair<Integer, Integer> coordinate;
    private final Random random = new Random();

    public Pawn(int tableSize) {
        this.coordinate = new Pair<>(this.random.nextInt(tableSize), this.random.nextInt(tableSize));
    }

    /**
     * Constructor made for testing purposes
     *
     * @param x
     * @param y
     */
    public Pawn (int x, int y) {
        this.coordinate = new Pair<>(x, y);
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.coordinate;
    }

    @Override
    public void setPosition(Pair<Integer, Integer> coordinates) {

    }
}

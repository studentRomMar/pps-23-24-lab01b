package e1.gamepiece;

import e1.utils.Pair;

import java.util.Random;

public class AbstractGamePiece implements GamePiece {

    private Pair<Integer, Integer> coordinate;
    private final Random random = new Random();

    public AbstractGamePiece(int tableSize) {
        this.coordinate = new Pair<>(this.random.nextInt(tableSize), this.random.nextInt(tableSize));
    }

    /**
     * Constructor made for testing purposes
     *
     * @param x
     * @param y
     */
    public AbstractGamePiece(int x, int y) {
        this.coordinate = new Pair<>(x, y);
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.coordinate;
    }

    @Override
    public void setPosition(Pair<Integer, Integer> newCoordinate) {
        this.coordinate = newCoordinate;
    }
}

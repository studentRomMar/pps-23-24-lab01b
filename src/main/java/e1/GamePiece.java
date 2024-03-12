package e1;

public interface GamePiece {

    /**
     *  Gets the actual piece's position.
     *
     * @return the piece's coordinates
     */
    Pair<Integer, Integer> getPosition();

    /**
     * Sets the new piece's coordinates
     *
     * @param coordinates
     */
    void setPosition(Pair<Integer, Integer> coordinates);
}
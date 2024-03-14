package e1.logic;

import e1.utils.Pair;
import e1.gamepiece.Knight;
import e1.gamepiece.Pawn;

import java.util.Random;

public class LogicsImpl implements Logics {
	
	private Pawn pawn;
	private Knight knight;
	private final Random random = new Random();
	private final int size;
	 
    public LogicsImpl(int size){
    	this.size = size;
        this.pawn = new Pawn(size);
        this.knight = new Knight(size);
    }

	public LogicsImpl(int size, Pair<Integer, Integer> knightPosition, Pair<Integer, Integer> pawnPosition) {
		this.size = size;
		this.knight = new Knight(knightPosition.getX(), knightPosition.getY());
		this.pawn = new Pawn(pawnPosition.getX(), pawnPosition.getY());
	}
    
	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn != null && this.pawn.getPosition().equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		// Below a compact way to express allowed moves for the knight
		int x = row-this.knight.getPosition().getX();
		int y = col-this.knight.getPosition().getY();

		if (x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3) {
			this.knight.setPosition(new Pair<>(row,col));
			return this.pawn.getPosition().equals(this.knight.getPosition());
		}
		return false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		Pair<Integer, Integer> knightPosition = this.knight.getPosition();
		return knightPosition.equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		Pair<Integer, Integer> pawnPosition = this.pawn.getPosition();
		return pawnPosition.equals(new Pair<>(row,col));
	}

	public Pair<Integer,Integer> getKnightPosition() {
		return this.knight.getPosition();
	}

	public Pair<Integer,Integer> getPawnPosition() {
		return this.pawn.getPosition();
	}
}

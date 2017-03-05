import java.util.Random;

public class DanceCat {
	
	private String name;
	private DanceMove[] danceMoves;

	private static final String[] NAME = new String[] {"Peter", "Cornelia"};

	public DanceCat(String unparsedMoves, String[] idealMoves) {
		this(parseMoves(unparsedMoves), idealMoves);
	}
	public DanceCat(String[] moves, String[] idealMoves) {
		this(createName(), createDanceMoves(moves, idealMoves));
	}
	public DanceCat(String name, DanceMove[] danceMoves) {
		this.name = name;
		this.danceMoves = danceMoves;
	}

	public static String[] parseMoves(String unparsedMoves) {
		String[] moves = new String[18];
		int i = 0;
		while (i < 18 && i < unparsedMoves.length()) {
			moves[i] = unparsedMoves.substring(i, i + 1);
			i++;
		}
		while (i < 18) {
			moves[i++] = "";
		}
		return moves;
	}

	public static DanceMove[] createDanceMoves(String[] moves, String[] idealMoves) {
		DanceMove[] tempDanceMoves = new DanceMove[18];
		for (int i = 0; i < 18; i++) {
			tempDanceMoves[i] = new DanceMove(idealMoves[i], moves[i]);
		}
		return tempDanceMoves;
	}

	public static String createName() {
		Random rm = new Random();
		return NAME[rm.nextInt(2)];
	}

	public String getName() {
		return name;
	}

	public DanceMove[] getDanceMoves() {
		return danceMoves;
	}

	public int getNumberOfCorrectMoves() {
		int numberOfCorrectMoves = 0;
		for (int i = 0; i < danceMoves.length; i++) {
			if (danceMoves[i].correctMove()) {
				numberOfCorrectMoves++;
			}
		}
		return numberOfCorrectMoves;
	}

	public static int getComputerLevel() {
		Random ra = new Random();
		int level = ra.nextInt(90);
		return level;
	}

}
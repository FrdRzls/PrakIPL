import java.util.ArrayList;
import java.util.List;

public class Minesweeper {
  public static final int STATUS_VALUE = 0;
  public static final int FLAGGED = 4;
  public List<int[]> getFlaggedCells() {
    List<int[]> flaggedCells = new ArrayList<int[]>();
    for (int[] cell : gameBoard) if (
      cell[STATUS_VALUE] == FLAGGED
    ) flaggedCells.add(cell);
    return flaggedCells;
  }
}

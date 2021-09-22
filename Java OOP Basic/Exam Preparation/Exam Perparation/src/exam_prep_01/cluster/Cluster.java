package exam_prep_01.cluster;

import exam_prep_01.cells.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cluster {
    private String id;
    private int rows;
    private int cols;
    private List<Cell> cells;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void addCell(Cell cell) {
        this.cells.add(cell);
    }

    public List<Cell> sortCells() {
        return this.cells.stream().sorted((cell1, cell2) -> {
            int compRow = Integer.compare(cell1.getPositionRow(), cell2.getPositionRow());
            if (compRow != 0) {
                return compRow;
            } else {
                return Integer.compare(cell1.getPositionCol(), cell2.getPositionCol());
            }
        }).collect(Collectors.toList());
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int sizeListCell() {
        return this.cells.size();
    }

    @Override
    public String toString() {
        StringBuilder clusterBuilder = new StringBuilder();
        clusterBuilder.append(String.format("----Cluster %s", this.getId()));
        List<Cell> sortedCell = this.sortCells();
        for (Cell cell : sortedCell) {
            clusterBuilder.append(System.lineSeparator()).append(cell);
        }

        return clusterBuilder.toString();
    }
}

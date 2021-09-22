package exam_prep_01.manager;

import exam_prep_01.cells.Cell;
import exam_prep_01.cells.blood_cells.RedBloodCell;
import exam_prep_01.cells.blood_cells.WhiteBloodCell;
import exam_prep_01.cells.microbes.Bacteria;
import exam_prep_01.cells.microbes.Fungi;
import exam_prep_01.cells.microbes.Virus;
import exam_prep_01.cluster.Cluster;
import exam_prep_01.constants.Messages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HealthManager {
    private Map<String, Organism> organisms;

    public HealthManager() {
        this.organisms = new LinkedHashMap<>();
    }

    public String checkCondition(String organismName) {
        if (this.organisms.containsKey(organismName)) {
            return this.organisms.get(organismName).toString();
        }
        return null;
    }

    //Complete
    public String createOrganism(String name) {
        if (!this.organisms.containsKey(name)) {
            Organism organism = new Organism(name);
            this.organisms.put(name, organism);
            return "Created organism " + name;
        } else {
            throw new IllegalArgumentException(String.format(Messages.MESSAGE_FOR_EXISTS_ORGANISM, name));
        }
    }

    //Problem with return null
    public String addCluster(String organismName, String id, int row, int col) {
        if (this.organisms.containsKey(organismName)) {
            Organism organism = this.organisms.get(organismName);
            Cluster cluster = new Cluster(id, row, col);
            if (!organism.getClusters().containsKey(cluster.getId())) {
                organism.addCluster(id, cluster);
                return String.format("Organism %s: Created cluster %s", organismName, id);
            } else {
                //TODO problem
                return null;
            }

        } else {
            //TODO problem
            return null;
        }
    }

    //Problems with cell's row and col
    public String addCell(String organismName, String clusterId, String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        Cell cell = null;

        switch (cellType) {
            case "WhiteBloodCell":
                cell = new WhiteBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "RedBloodCell":
                cell = new RedBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "Virus":
                cell = new Virus(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "Fungi":
                cell = new Fungi(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "Bacteria":
                cell = new Bacteria(cellId, health, positionRow, positionCol, additionalProperty);
                break;
        }

        if (this.organisms.containsKey(organismName)) {
            Organism organism = this.organisms.get(organismName);
            if (organism.getClusters().containsKey(clusterId) && positionRow >= 0 && positionRow < organism.getClusters().get(clusterId).getRows() && positionCol >= 0 && positionCol < organism.getClusters().get(clusterId).getCols()) {
                //TODO problems with cell's row and col
                organism.getClusters().get(clusterId).addCell(cell);
                return String.format("Organism %s: Created cell %s in cluster %s", organismName, cellId, clusterId);
            }
        }
        return null;
    }

    public String activateCluster(String name) {
        if (this.organisms.containsKey(name)) {
            Organism organism = organisms.get(name);

            String firstClusterId = null;
            for (Map.Entry<String, Cluster> stringOrganismEntry : organism.getClusters().entrySet()) {
                firstClusterId = stringOrganismEntry.getKey();
                break;
            }
            Cluster cluster = organism.getClusters().get(firstClusterId);
            organism.removeCluster(firstClusterId);

            List<Cell> cells = cluster.sortCells();

            while (cells.size() > 1) {
                Cell currentCell = cells.get(0);

                if (currentCell.getClass().getSimpleName().equals("RedBloodCell") || currentCell.getClass().getSimpleName().equals("WhiteBloodCell")) {
                    Cell nextCell = cells.get(1);
                    currentCell.addHealth(nextCell.getHealth());
                    cells.remove(1);
                    currentCell.setPositionRow(nextCell.getPositionRow());
                    currentCell.setPositionCol(nextCell.getPositionCol());


                } else {
                    while (cells.size() > 1) {
                        Cell nextCell = cells.get(1);
                        int damage = currentCell.getEnergy();
                        nextCell.removeHealth(damage);
                        if (nextCell.getHealth() <= 0) {
                            cells.remove(1);
                            currentCell.setPositionRow(nextCell.getPositionRow());
                            currentCell.setPositionCol(nextCell.getPositionCol());

                        } else {
                            damage = nextCell.getEnergy();
                            currentCell.removeHealth(damage);
                            if (currentCell.getHealth() <= 0) {
                                cells.remove(0);
                                currentCell = nextCell;

                            }
                        }
                    }
                }
            }
            cluster.setCells(cells);
            organism.addCluster(firstClusterId, cluster);
            return String.format("Organism %s: Activated cluster %s. Cells left: %d", name, firstClusterId, cells.size());
        }
        return null;
    }
}

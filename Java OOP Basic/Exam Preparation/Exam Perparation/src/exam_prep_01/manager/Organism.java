package exam_prep_01.manager;

import exam_prep_01.cluster.Cluster;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Organism {
    private String name;
    private Map<String, Cluster> clusters;

    public Organism(String name) {
        this.name = name;
        this.clusters = new LinkedHashMap<>();
    }

    protected Map<String, Cluster> getClusters() {
        return clusters;
    }

    public void addCluster(String id, Cluster cluster) {
        this.clusters.put(id, cluster);
    }

    public void removeCluster(String clusterId) {
        this.clusters.remove(clusterId);
    }

    @Override
    public String toString() {
        StringBuilder organism = new StringBuilder();
        organism.append(String.format("Organism - %s", this.name))
                .append(System.lineSeparator())
                .append(String.format("--Clusters: %d", this.clusters.size()))
                .append(System.lineSeparator());

        int sumCells = this.clusters.entrySet().stream().mapToInt(kv -> (kv.getValue().sizeListCell())).sum();
        organism.append(String.format("--Cells: %d", sumCells));
        for (Map.Entry<String, Cluster> entry : clusters.entrySet()) {
            organism.append(System.lineSeparator()).append(entry.getValue());
        }

        return organism.toString();
    }
}

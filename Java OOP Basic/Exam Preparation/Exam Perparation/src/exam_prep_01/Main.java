package exam_prep_01;

import exam_prep_01.manager.HealthManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        HealthManager healthManager = new HealthManager();

        while (!"BEER IS COMING".equals(line)) {
            try {
                String[] tokens = line.split("\\s+");
                String command = tokens[0];
                String organismName = tokens[1];
                switch (command) {

                    case "createOrganism":
                        System.out.println(healthManager.createOrganism(organismName));
                        break;

                    case "addCluster":
                        String id = tokens[2];
                        int rows = Integer.parseInt(tokens[3]);
                        int cols = Integer.parseInt(tokens[4]);

                        String addCluster = healthManager.addCluster(organismName, id, rows, cols);

                        if (addCluster != null) {
                            System.out.println(addCluster);
                        }
                        break;

                    case "addCell":
                        id = tokens[2];
                        String cellType = tokens[3];
                        String cellId = tokens[4];
                        int health = Integer.parseInt(tokens[5]);
                        int positionRow = Integer.parseInt(tokens[6]);
                        int positionCol = Integer.parseInt(tokens[7]);
                        int prop = Integer.parseInt(tokens[8]);

                        String addCell = healthManager.addCell(organismName, id, cellType, cellId, health, positionRow, positionCol, prop);

                        if (addCell != null) {
                            System.out.println(addCell);
                        }
                        break;

                    case "activateCluster":
                        String activateCluster = healthManager.activateCluster(organismName);
                        if (activateCluster != null) {
                            System.out.println(activateCluster);
                        }
                        break;

                    case "checkCondition":
                        String checkCondition = healthManager.checkCondition(organismName);
                        if (checkCondition != null) {
                            System.out.println(checkCondition);
                        }
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            line = reader.readLine();
        }
    }
}

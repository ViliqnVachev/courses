package exam_prep_02.races;

import exam_prep_02.cars.Car;

import java.util.List;
import java.util.stream.Collectors;

public class DragRace extends Race {


    public DragRace(int length, String rout, int prizePool) {
        super(length, rout, prizePool);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        List<Car> winners = super.getParticipants().stream()
                .sorted((c1, c2) -> Integer.compare(c2.getEnginePerformancePoints(), c1.getEnginePerformancePoints()))
                .limit(3)
                .collect(Collectors.toList());

        for (int i = 0; i < winners.size(); i++) {
            sb.append(System.lineSeparator())
                    .append(String.format("%d. %s %s %dPP - $%d", i + 1, winners.get(i).getBrand(), winners.get(i).getModel(), winners.get(i).getEnginePerformancePoints(), (super.getPrizePool() * super.getPercentagePriceValue(i)) / 100));
        }
        return sb.toString();
    }
}


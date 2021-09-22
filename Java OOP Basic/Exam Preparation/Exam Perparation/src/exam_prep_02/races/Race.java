package exam_prep_02.races;

import exam_prep_02.cars.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

public abstract class Race {
    //length (int), route (string), a prizePool (int), and participants (Collection of Cars),
    private int length;
    private String rout;
    private int prizePool;
    private List<Car> participants;

    protected Race(int length, String rout, int prizePool) {
        this.length = length;
        this.rout = rout;
        this.prizePool = prizePool;
        this.participants = new ArrayList<>();
    }

    public void addParticipant(Car car) {
        this.participants.add(car);
    }

    public boolean hasParticipantCar(Car car) {
        return this.participants.contains(car);
    }

    public boolean hasParticipant() {
        return !this.participants.isEmpty();
    }

    protected List<Car> getParticipants() {
        return Collections.unmodifiableList(this.participants);
    }

    public int getLength() {
        return length;
    }

    public String getRout() {
        return rout;
    }

    public int getPrizePool() {
        return prizePool;
    }

    protected int getPercentagePriceValue(int index) {
        switch (index) {
            case 0:
                return 50;
            case 1:
                return 30;
            case 2:
                return 20;
        }
        return 0;
    }

}

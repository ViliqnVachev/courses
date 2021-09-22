package froggy;

import java.util.Iterator;
import java.util.List;

public class Lake<T> implements Iterable<T> {
    private List<T> lake;

    public Lake(List<T> lake) {
        this.lake = lake;
    }

    @Override
    public Iterator<T> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<T> {
        private int index;
        private boolean isEven;

        public Frog() {
            this.index = 0;
            this.isEven = true;
        }

        @Override
        public boolean hasNext() {
            boolean hasNext = index < lake.size() ;
            if (isEven && hasNext) {
                return true;
            } else if (isEven && !hasNext) {
                if (lake.size() == 1) {
                    return false;
                }
                index = 1;
                isEven = false;
                return true;
            }
            return hasNext;
        }

        @Override
        public T next() {
            T t = lake.get(index);
            this.index += 2;
            return t;
        }
    }
}

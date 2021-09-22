package database;



import javax.naming.OperationNotSupportedException;
import java.util.Collections;

public class Database {
    private static final int MAX_CAPACITY = 16;

    private Integer[] args;
    private int tempLength;

    public Database(Integer... args) throws OperationNotSupportedException {
        this.setArgs(args);
    }

    public void setArgs(Integer... args) throws OperationNotSupportedException {
        if (args.length > MAX_CAPACITY) {
            throw new OperationNotSupportedException("The length is more than 16");
        } else if (isContainsNull(args)) {
            throw new OperationNotSupportedException();
        }
        this.tempLength = args.length;
        this.args = new Integer[MAX_CAPACITY];
        System.arraycopy(args, 0, this.args, 0, args.length);
    }

    private boolean isContainsNull(Integer... args) {
        for (Integer arg : args) {
            if (arg == null) {
                return true;
            }
        }
        return false;
    }

    public void add(Integer element) throws OperationNotSupportedException {
        if (this.tempLength >= MAX_CAPACITY) {
            throw new OperationNotSupportedException("The length is more than 16");
        } else if (element == null) {
            throw new OperationNotSupportedException("The element must be number");
        }
        this.args[tempLength++] = element;
    }

    public Integer removeNumber() throws OperationNotSupportedException {
        if (this.tempLength <= 0) {
            throw new OperationNotSupportedException("The array is empty");
        }
        Integer number = this.args[--tempLength];
        this.args[tempLength] = null;
        return number;
    }

    public Integer[] fetch() {
        Integer[] temp = new Integer[tempLength];

        for (int i = 0; i < tempLength; i++) {
            temp[i] = this.args[i];
        }
        return temp;
    }
}

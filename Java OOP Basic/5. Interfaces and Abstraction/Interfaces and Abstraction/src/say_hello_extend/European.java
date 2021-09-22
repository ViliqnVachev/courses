package say_hello_extend;

public class European extends BasePerson implements Person {


    protected European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}

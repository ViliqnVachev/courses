package mankind;

public class Human {

    private static final String INVALID_UPPER_CASE_FIRST_LETTER_NAME = "Expected upper case letter!Argument: firstName";
    private static final String INVALID_FIRST_NAME_LENGTH = "Expected length at least 4 symbols!Argument: firstName";
    private static final String INVALID_UPPER_CASE_FIRST_LETTER_LAST_NAME = "Expected upper case letter!Argument: lastName";
    private static final String INVALID_LAST_NAME_LENGTH = "Expected length at least 3 symbols!Argument: lastName";

    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    private void setFirstName(String firstName) {
        if (!Character.isUpperCase(firstName.charAt(0))) {
            throw new IllegalArgumentException(INVALID_UPPER_CASE_FIRST_LETTER_NAME);
        } else if (firstName.length() < 4) {
            throw new IllegalArgumentException(INVALID_FIRST_NAME_LENGTH);
        }
        this.firstName = firstName;
    }

    protected void setLastName(String lastName) {
        if (lastName.matches("^[A-Z]")) {
            throw new IllegalArgumentException(INVALID_UPPER_CASE_FIRST_LETTER_LAST_NAME);
        }else if(lastName.length() < 3){
            throw new IllegalArgumentException(INVALID_LAST_NAME_LENGTH);
        }
        this.lastName = lastName;
    }

    protected String getFirstName() {
        return firstName;
    }

    protected String getLastName() {
        return lastName;
    }
}

package telephony;


public class Smartphone implements Callable, Browsable {
    private static final String INVALID_URL = "Invalid URL!";
    private static final String INVALID_NUMBER = "Invalid number!";

    public Smartphone() {
    }

    @Override
    public String browsing(String url) {
        if (isURLContainsDigit(url)) {
            throw new IllegalArgumentException(INVALID_URL);
        }
        return String.format("Browsing: %s!", url);
    }

    @Override
    public String calling(String number) {
        if (!isNumberContainsNotDigit(number)) {
            throw new IllegalArgumentException(INVALID_NUMBER);
        }
        return String.format("Calling... %s", number);
    }

    private boolean isURLContainsDigit(String url) {
        for (int i = 0; i < url.length(); i++) {
            if (Character.isDigit(url.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumberContainsNotDigit(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

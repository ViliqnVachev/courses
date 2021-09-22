package book_shop;

public class Book {
    private static final String INVALID_AUTHOR = "Author not valid!";
    private static final String INVALID_TITLE = "Title not valid!";
    private static final String INVALID_PRICE = "Price not valid!";

    private String author;
    private String title;
    private double price;

    public Book(String author, String title, double price) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }

    private void setAuthor(String author) {
        if (author.matches("[a-zA-Z]+ [0-9][a-zA-Z]+")) {
            throw new IllegalArgumentException(INVALID_AUTHOR);
        }
        this.author = author;
    }

    private void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException(INVALID_TITLE);
        }
        this.title = title;
    }

    protected void setPrice(double price) {
        if (price < 0.1) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
    }

    private String getAuthor() {
        return author;
    }

    private String getTitle() {
        return title;
    }

    private double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());
        return sb.toString();

    }


}

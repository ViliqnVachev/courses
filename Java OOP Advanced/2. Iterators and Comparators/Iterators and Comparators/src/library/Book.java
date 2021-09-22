package library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Book {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
       // this.setAuthors(authors);
        this.authors = new ArrayList<>(Arrays.asList(authors));
        //Collections.addAll(this.authors, authors);

    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(String... authors) {
        Collections.addAll(this.authors, authors);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Title: ").append(this.getTitle()).append(" Year: ").append(this.getYear())
                .append(" Authors: ").append(String.join(", ", this.authors));

        return sb.toString();
    }
}

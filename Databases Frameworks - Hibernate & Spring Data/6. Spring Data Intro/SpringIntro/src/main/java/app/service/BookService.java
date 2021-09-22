package app.service;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface BookService {
    void seedBook() throws IOException;
    List<String> getAllBooksTitlesAfter();
    Set<String> getAllAuthorsWithBookBefore();
}

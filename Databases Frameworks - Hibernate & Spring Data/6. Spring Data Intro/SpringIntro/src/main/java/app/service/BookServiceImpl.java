package app.service;

import app.entity.*;
import app.repository.AuthorRepository;
import app.repository.BookRepository;
import app.repository.CategoryRepository;
import app.util.FileUtil;
import org.springframework.aop.interceptor.SimpleTraceInterceptor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private static final String BOOKS_FILE_PATH = "C:\\Users\\Viliyan\\Desktop\\SpringIntro\\src\\main\\resources\\files\\books.txt";

    private final BookRepository bookRepository;
    private final FileUtil fileUtil;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    public BookServiceImpl(BookRepository bookRepository, FileUtil fileUtil, AuthorRepository authorRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.fileUtil = fileUtil;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedBook() throws IOException {
        String[] fileContent = fileUtil.getFileContent(BOOKS_FILE_PATH);

        for (String line : fileContent) {
            String[] data = line.split("\\s+");

            Book book = new Book();

            book.setAuthor(this.getRandomAuthor());

            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            book.setEditionType(editionType);

            LocalDate date = LocalDate.parse(data[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
            book.setReleaseDate(date);

            int copies = Integer.parseInt(data[2]);
            book.setCopies(copies);


            BigDecimal price = new BigDecimal(data[3]);
            book.setPrice(price);

            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
            book.setAgeRestriction(ageRestriction);

            StringBuilder title = new StringBuilder();

            for (int i = 5; i < data.length; i++) {
                title.append(data[i]).append(" ");
            }
            book.setTitle(title.toString().trim());

            Set<Category> categories = this.getRandomCategories();
            book.setCategories(categories);

            this.bookRepository.saveAndFlush(book);
        }

    }

    @Override
    public List<String> getAllBooksTitlesAfter() {
        List<Book> books = this.bookRepository.findAllByReleaseDateAfter(LocalDate.parse("2000-12-31"));


        return books.stream().map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public Set<String> getAllAuthorsWithBookBefore() {
        List<Book> authors = this.bookRepository.findAllByReleaseDateBefore(LocalDate.parse("1990-01-01"));

        return authors.stream().map(b -> String.format("%s %s", b.getAuthor().getFirstName(), b.getAuthor().getLastName())).collect(Collectors.toSet());

    }

    private Author getRandomAuthor() {
        Random random = new Random();
        int randomId = random.nextInt((int) (this.authorRepository.count() - 1)) + 1;
        return this.authorRepository.findById(randomId).orElse(null);
    }

    private Set<Category> getRandomCategories() {
        Set<Category> categories = new LinkedHashSet<>();
        Random random = new Random();
        int length = random.nextInt(5);

        for (int i = 0; i < length; i++) {
            Category category = this.getRandomCategory();
            categories.add(category);
        }
        return categories;
    }

    private Category getRandomCategory() {
        Random random = new Random();
        int randomId = random.nextInt((int) (this.categoryRepository.count() - 1)) + 1;
        return this.categoryRepository.findById(randomId).orElse(null);
    }

}

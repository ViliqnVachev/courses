package app.service;

import app.entity.Author;
import app.repository.AuthorRepository;
import app.util.FileUtil;
import app.util.FileUtilImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthorServiceImpl implements AuthorService {
    private static final String AUTHOR_FILE_PATH = "C:\\Users\\Viliyan\\Desktop\\SpringIntro\\src\\main\\resources\\files\\authors.txt";

    private final FileUtil fileUtil;
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, FileUtil fileUtil) {
        this.authorRepository = authorRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (this.authorRepository.count() != 0) {
            return;
        }

        String[] authorFileContent = this.fileUtil.getFileContent(AUTHOR_FILE_PATH);

        for (String line : authorFileContent) {
            String[] names = line.split("\\s+");
            Author author = new Author();
            author.setFirstName(names[0]);
            author.setLastName(names[1]);
            this.authorRepository.saveAndFlush(author);
        }
    }
}


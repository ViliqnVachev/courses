package app.service;

import app.entity.Author;
import app.entity.Category;
import app.repository.CategoryRepository;
import app.util.FileUtil;
import app.util.FileUtilImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final String CATEGORY_FILE_PATH = "C:\\Users\\Viliyan\\Desktop\\SpringIntro\\src\\main\\resources\\files\\categories.txt";

    private final FileUtil fileUtil;
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(FileUtilImpl fileUtil, CategoryRepository categoryRepository) {
        this.fileUtil = fileUtil;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategory() throws IOException {
        if (this.categoryRepository.count() != 0) {
            return;
        }

        String[] authorFileContent = this.fileUtil.getFileContent(CATEGORY_FILE_PATH);

        for (String line : authorFileContent) {
            String[] names = line.split("\\s+");
            Category category = new Category();
            category.setName(names[0]);
            this.categoryRepository.saveAndFlush(category);
        }
    }
}

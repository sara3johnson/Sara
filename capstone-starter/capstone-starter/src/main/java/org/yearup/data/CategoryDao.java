package org.yearup.data;

import org.yearup.models.Category;

import java.util.List;

public interface CategoryDao
{
    List<Category> getAllCategories();
    Category getById(int categoryId);
    Category create(Category category);
    void update(int categoryId, Category category);
    void delete(int categoryId);
    Category addCategory(Category category);
    void updateCategory(int id, Category category);
}

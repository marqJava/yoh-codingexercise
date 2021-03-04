package com.yoh.codingexcercise.rest.dto.results;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * To represent the quiz with categories level data on the provided result from this web service
 */
public class QuizDto implements Serializable {
    private List<CategoryDto> categories = new ArrayList<>();

    public List<CategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDto> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("QuizDto{");
        sb.append("categories=").append(categories);
        sb.append('}');
        return sb.toString();
    }
}

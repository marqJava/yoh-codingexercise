package com.yoh.codingexcercise.rest.dto.results;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * To represent the category level data on the provided result from this web service
 */
public class CategoryDto {
    private String category;
    private List<ResultItemDto> results = new ArrayList<>();

    public CategoryDto(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<ResultItemDto> getResults() {
        return results;
    }

    public void setResults(List<ResultItemDto> results) {
        this.results = results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDto that = (CategoryDto) o;
        return category.equals(that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CategoryDto{");
        sb.append("category='").append(category).append('\'');
        sb.append(", results=").append(results);
        sb.append('}');
        return sb.toString();
    }
}

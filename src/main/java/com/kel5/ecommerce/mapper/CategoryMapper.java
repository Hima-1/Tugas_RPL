package com.kel5.ecommerce.mapper;

import com.kel5.ecommerce.dto.CategoryDTO;
import com.kel5.ecommerce.entity.Category;

public class CategoryMapper {
    // Category: Entity to DTO
    public static CategoryDTO toCategoryDTO(Category category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .status(category.getStatus())
                .build();
    }

    // Category: DTO to Entity
    public static Category toCategoryEntity(CategoryDTO categoryDTO) {
        return Category.builder()
                .id(categoryDTO.getId())
                .name(categoryDTO.getName())
                .status(categoryDTO.getStatus())
                // For products, you'll need to fetch or create instances as they involve relations
                .build();
    }
}

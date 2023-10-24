package com.kel5.ecommerce.mapper;

import com.kel5.ecommerce.dto.ImageDTO;
import com.kel5.ecommerce.entity.Image;

public class ImageMapper {
    public static ImageDTO toImageDTO(Image image) {
        return ImageDTO.builder()
                .id(image.getId())
                .image(image.getImage())
                .date(image.getDate())
                .build();
    }

    // Image: DTO to Entity
    public static Image toImageEntity(ImageDTO imageDTO) {
        Image image = new Image();
        image.setId(imageDTO.getId());
        image.setImage(imageDTO.getImage());
        image.setDate(imageDTO.getDate());
        return image;
    }
}

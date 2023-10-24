package com.kel5.ecommerce.dto;

import lombok.*;

import java.sql.Blob;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageDTO {
    private long id;
    private Blob image;
    private Date date;
}

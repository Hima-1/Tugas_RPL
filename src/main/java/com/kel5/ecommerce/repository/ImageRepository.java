package com.kel5.ecommerce.repository;

import com.kel5.ecommerce.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<Image, Long>, JpaRepository<Image, Long> {

}

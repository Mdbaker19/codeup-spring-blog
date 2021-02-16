package com.jupiterspring.springblog.repositories;

import com.jupiterspring.springblog.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface PostRepository extends JpaRepository<Post, Long> {

    Post findPostByTitle(String title);

    @Query("select post from Post post where title like %?1%")
    Page<Post> pageDisplay(String search, Pageable pageable);

}

package com.jupiterspring.springblog.repositories;

import com.jupiterspring.springblog.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("from Post post where post.title like %?1%")
    List<Post> findAllByTitle(String title);

    @Query("from Post post where post.title like %?1%")
    Page<Post> findByTitle(String title, Pageable pageable);


    Page<Post> findAll(Pageable pageable);

    @Query(nativeQuery = true, value = "select * from posts where user_id = ?")
    List<Post> findAllByUserId(long id);

}

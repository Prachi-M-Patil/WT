package org.example.springboot_usingdao.repository;

import org.example.springboot_usingdao.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer> {

}

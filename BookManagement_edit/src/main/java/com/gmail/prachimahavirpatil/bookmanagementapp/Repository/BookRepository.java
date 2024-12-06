package com.gmail.prachimahavirpatil.bookmanagementapp.Repository;

import com.gmail.prachimahavirpatil.bookmanagementapp.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}


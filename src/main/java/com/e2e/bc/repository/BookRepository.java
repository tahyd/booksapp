package com.e2e.bc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e2e.bc.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}

package com.example.demo.oneToOne;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookCatalog, Integer> {
}

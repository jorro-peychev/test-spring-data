package com.example.demo.oneToOne;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OneToOneService {

  private static final Logger LOGGER = LoggerFactory.getLogger(OneToOneService.class);
  private BookRepository bookRepository;

  public OneToOneService(BookRepository bookRepository) {

    this.bookRepository = bookRepository;
  }

  public void test(){
      // save a couple of books
      List<BookCatalog> books = new ArrayList<>();
      books.add(new BookCatalog("Book A", new BookDetail(49)));
      books.add(new BookCatalog("Book B", new BookDetail(59)));
      books.add(new BookCatalog("Book C", new BookDetail(69)));
      bookRepository.save(books);

      // fetch all books
      for (BookCatalog book : bookRepository.findAll()) {
        LOGGER.info(book.toString());
      }
  }
}

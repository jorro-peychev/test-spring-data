package com.example.demo.oneToManyEAGER;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BookService {

  private static final org.slf4j.Logger logger = LoggerFactory.getLogger(BookService.class);
  @Autowired
  private BookCategoryRepository bookCategoryRepository;

  @Autowired
  private BookRepository bookRepository;

  public BookService(){}

  public void loadBooks() throws Exception {
    // save a couple of categories
    BookCategory categoryA = new BookCategory("Category A");
    Set bookAs = new HashSet<Book>() {{
      add(new Book("Books A1", categoryA));
      add(new Book("Books A2", categoryA));
      add(new Book("Books A3", categoryA));
    }};
    categoryA.setBooks(bookAs);

    BookCategory categoryB = new BookCategory("Category B");
    Set bookBs = new HashSet<Book>() {{
      add(new Book("Books B1", categoryB));
      add(new Book("Books B2", categoryB));
      add(new Book("Books B3", categoryB));
    }};
    categoryB.setBooks(bookBs);

    bookCategoryRepository.save(new HashSet<BookCategory>() {{
      add(categoryA);
      add(categoryB);
    }});
  }

  public List<BookCategory> findAllBooks(){
    return bookCategoryRepository.findAll();
  }

  public void deleteCategory(){
    for (BookCategory bookCategory : bookCategoryRepository.findAll()) {
      Object[] books = bookCategory.getBooks().toArray();
      bookCategory.getBooks().remove((Book) books[1]);
//      bookCategoryRepository.save(bookCategory);
      bookRepository.delete((Book) books[1]);
    }
  }
}

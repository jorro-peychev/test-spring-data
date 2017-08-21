package com.example.demo.manyToMany;


import java.util.HashSet;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ManyToManyService {

  private static final Logger LOGGER = LoggerFactory.getLogger(ManyToManyService.class);
  private BooksRepository bookRepository;
  private PublisherRepository publisherRepository;

  public ManyToManyService(BooksRepository bookRepository, PublisherRepository publisherRepository) {

    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  public void test(){
    // save a couple of books
    Publisher publisherA = new Publisher("Publisher A");
    Publisher publisherB = new Publisher("Publisher B");
    Publisher publisherC = new Publisher("Publisher C");

    bookRepository.save(new HashSet<Books>(){{
      add(new Books("Books A", new HashSet<Publisher>(){{
        add(publisherA);
        add(publisherB);
      }}));

      add(new Books("Books B", new HashSet<Publisher>(){{
        add(publisherA);
        add(publisherC);
      }}));
    }});

    // fetch all books
    for(Books book : bookRepository.findAll()) {
      LOGGER.info(book.toString());
    }

    // save a couple of publishers
    Books bookA = new Books("Books A");
    Books bookB = new Books("Books B");

    publisherRepository.save(new HashSet<Publisher>() {{
      add(new Publisher("Publisher A", new HashSet<Books>() {{
        add(bookA);
        add(bookB);
      }}));

      add(new Publisher("Publisher B", new HashSet<Books>() {{
        add(bookA);
        add(bookB);
      }}));
    }});

    // fetch all publishers
    for(Publisher publisher : publisherRepository.findAll()) {
      LOGGER.info(publisher.toString());
    }
  }

}

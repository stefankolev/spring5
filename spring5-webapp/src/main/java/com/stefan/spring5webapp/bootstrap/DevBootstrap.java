package com.stefan.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.stefan.spring5webapp.model.Author;
import com.stefan.spring5webapp.model.Book;
import com.stefan.spring5webapp.model.Publisher;
import com.stefan.spring5webapp.repositories.AuthorRepository;
import com.stefan.spring5webapp.repositories.BookRepository;
import com.stefan.spring5webapp.repositories.PublisherRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		initData();

	}

	private void initData() {
		
		
		Publisher publisher = Publisher.builder().address("stefan street").name("stefan publisher").build();
		publisherRepository.save(publisher);

		Author eric = Author.builder().firstName("Eric").lastName("Evans").build();
		Book ddd = Book.builder().title("Domain Driven Design").isbn("1234").publisher(publisher).build();
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);

		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		Author stefan = Author.builder().firstName("Stefan").lastName("Stefan").build();
		Book bbb = Book.builder().title("Stefan Driven Design").isbn("1234111").publisher(publisher).build();
		stefan.getBooks().add(bbb);
		bbb.getAuthors().add(stefan);
		
		authorRepository.save(stefan);
		bookRepository.save(bbb);

	}


}

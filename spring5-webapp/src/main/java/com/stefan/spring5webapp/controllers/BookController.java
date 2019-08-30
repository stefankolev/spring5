package com.stefan.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stefan.spring5webapp.repositories.BookRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BookController {
	
	private final BookRepository bookRepository;
	
	@RequestMapping("/books")
	public String getBooks(Model model) {
		
		model.addAttribute("books", bookRepository.findAll());
		
		return "books";
		
	}

}

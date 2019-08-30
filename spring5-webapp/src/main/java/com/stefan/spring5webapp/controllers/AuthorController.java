package com.stefan.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stefan.spring5webapp.repositories.AuthorRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AuthorController {
	
	private final AuthorRepository authorRepository;
	
	@RequestMapping("/authors")
	public String getAuthors(Model model) { 
		
		model.addAttribute("authors", authorRepository.findAll());
		
		return "authors";
	}

}

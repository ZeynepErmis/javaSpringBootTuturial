package com.kodlama.io.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.business.abstracts.ProgrammingLanguageService;
import com.kodlama.io.business.requests.CreateProgrammingLanguagesRequest;
import com.kodlama.io.business.requests.UpdateProgrammingLanguageRequest;
import com.kodlama.io.business.responses.GetAllProgrammingLanguagesResponse;

@RestController
@RequestMapping("/api/programmmingLanguages")
public class ProgrammingLanguagesController {
	@Autowired
	private ProgrammingLanguageService programmingLanguageService;

	@GetMapping()
	List<GetAllProgrammingLanguagesResponse> getAll() {
		return this.programmingLanguageService.getAll();
	}

	@PostMapping()
	public void add(@RequestBody CreateProgrammingLanguagesRequest createProgrammingLanguagesRequest) {
		this.programmingLanguageService.add(createProgrammingLanguagesRequest);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.programmingLanguageService.delete(id);
	}

	@PutMapping()
	public void update(@RequestBody UpdateProgrammingLanguageRequest request) {
		programmingLanguageService.update(request);
	}
}

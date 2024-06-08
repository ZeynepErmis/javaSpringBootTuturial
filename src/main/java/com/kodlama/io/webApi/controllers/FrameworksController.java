package com.kodlama.io.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.business.abstracts.FrameworkService;
import com.kodlama.io.business.requests.CreateFrameworksRequest;
import com.kodlama.io.business.requests.UpdateFrameworkRequest;
import com.kodlama.io.business.responses.GetAllFrameworksResponse;

@RestController
@RequestMapping("/api/frameworks")
public class FrameworksController {
	@Autowired
	private FrameworkService frameworkService;

	@GetMapping()
	public List<GetAllFrameworksResponse> getAll() {
		return frameworkService.getAll();
	}

	@PostMapping()
	public void add(@RequestBody CreateFrameworksRequest createFrameworksRequest) {
		this.frameworkService.add(createFrameworksRequest);
	}

	@PutMapping()
	public void update(@RequestBody UpdateFrameworkRequest request) {
		frameworkService.update(request);
	}

	@DeleteMapping("/{id}")
	public void delete(@RequestParam int id) {
		frameworkService.delete(id);
	}

}

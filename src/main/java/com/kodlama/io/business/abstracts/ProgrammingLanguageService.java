package com.kodlama.io.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlama.io.business.requests.CreateProgrammingLanguagesRequest;
import com.kodlama.io.business.requests.UpdateProgrammingLanguageRequest;
import com.kodlama.io.business.responses.GetAllProgrammingLanguagesResponse;

@Service
public interface ProgrammingLanguageService {
	List<GetAllProgrammingLanguagesResponse> getAll();

	void add(CreateProgrammingLanguagesRequest createProgrammingLanguagesRequest);

	void delete(int id);

	void update(UpdateProgrammingLanguageRequest request);
}

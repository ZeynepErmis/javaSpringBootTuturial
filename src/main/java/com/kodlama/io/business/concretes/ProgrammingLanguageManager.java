package com.kodlama.io.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.business.abstracts.ProgrammingLanguageService;
import com.kodlama.io.business.core.utilities.mappers.ModelMapperService;
import com.kodlama.io.business.requests.CreateProgrammingLanguagesRequest;
import com.kodlama.io.business.requests.UpdateProgrammingLanguageRequest;
import com.kodlama.io.business.responses.GetAllProgrammingLanguagesResponse;
import com.kodlama.io.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.kodlama.io.entity.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	@Autowired
	private ProgrammingLanguageRepository programmingLanguageRepository;
	@Autowired
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
		List<GetAllProgrammingLanguagesResponse> responseProgrammingLanguage = programmingLanguages.stream()
				.map(ogrammingLanguage -> this.modelMapperService.forResponse().map(ogrammingLanguage,
						GetAllProgrammingLanguagesResponse.class))
				.collect(Collectors.toList());
		return responseProgrammingLanguage;
	}

	@Override
	public void add(CreateProgrammingLanguagesRequest createProgrammingLanguagesRequest) {
		ProgrammingLanguage programmingLanguage = this.modelMapperService.forRequest()
				.map(createProgrammingLanguagesRequest, ProgrammingLanguage.class);
		programmingLanguageRepository.save(programmingLanguage);
	}

	@Override
	public void delete(int id) {
		programmingLanguageRepository.deleteById(id);
	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
		ProgrammingLanguage programmingLanguage = this.modelMapperService.forRequest()
				.map(updateProgrammingLanguageRequest, ProgrammingLanguage.class);
		programmingLanguageRepository.save(programmingLanguage);
	}

}

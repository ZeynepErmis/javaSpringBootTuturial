package com.kodlama.io.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.business.abstracts.FrameworkService;
import com.kodlama.io.business.core.utilities.mappers.ModelMapperService;
import com.kodlama.io.business.requests.CreateFrameworksRequest;
import com.kodlama.io.business.requests.UpdateFrameworkRequest;
import com.kodlama.io.business.responses.GetAllFrameworksResponse;
import com.kodlama.io.dataAccess.abstracts.FrameworkRepository;
import com.kodlama.io.entity.concretes.Framework;

@Service
public class FrameworkManager implements FrameworkService {
	@Autowired
	private FrameworkRepository frameworkRepository;
	@Autowired
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllFrameworksResponse> getAll() {
		List<Framework> frameworks = frameworkRepository.findAll();
		List<GetAllFrameworksResponse> frameworksResponse = frameworks.stream()
				.map(framework -> this.modelMapperService.forResponse().map(framework, GetAllFrameworksResponse.class))
				.collect(Collectors.toList());

		return frameworksResponse;
	}

	@Override
	public void add(CreateFrameworksRequest createFrameworkRequest) {
		Framework framework = this.modelMapperService.forRequest().map(createFrameworkRequest, Framework.class);
		frameworkRepository.save(framework);
	}

	@Override
	public void delete(int id) {
		frameworkRepository.deleteById(id);
	}

	@Override
	public void update(UpdateFrameworkRequest updateFrameworkRequest) {
		Framework framework = this.modelMapperService.forRequest().map(updateFrameworkRequest, Framework.class);
		frameworkRepository.save(framework);
		frameworkRepository.save(framework);
	}

}

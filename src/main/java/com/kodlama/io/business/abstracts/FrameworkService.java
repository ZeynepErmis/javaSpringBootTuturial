package com.kodlama.io.business.abstracts;

import java.util.List;

import com.kodlama.io.business.requests.CreateFrameworksRequest;
import com.kodlama.io.business.requests.UpdateFrameworkRequest;
import com.kodlama.io.business.responses.GetAllFrameworksResponse;

public interface FrameworkService {
	List<GetAllFrameworksResponse> getAll();

	void add(CreateFrameworksRequest createFrameworkRequest);

	void delete(int id);

	void update(UpdateFrameworkRequest request);

}

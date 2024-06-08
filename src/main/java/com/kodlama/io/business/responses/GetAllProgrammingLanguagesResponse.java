package com.kodlama.io.business.responses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProgrammingLanguagesResponse {
	private int id;
	private String name;
	private List<GetAllFrameworksResponse> framework;
}

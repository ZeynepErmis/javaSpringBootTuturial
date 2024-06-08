package com.kodlama.io.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFrameworksRequest {

	private int programmingLanguageId;
	private String name;
}

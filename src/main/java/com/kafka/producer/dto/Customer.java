package com.kafka.producer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
	private Integer id;
	private String name;
	private String email;
	private String contactNo;
}

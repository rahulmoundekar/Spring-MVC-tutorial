package com.app.bean;

import java.util.List;

import lombok.Data;

@Data
public class ProductDto {

	private Integer id;
	private String name;
	private Double price;
	private List<ColorDto> colors;

}

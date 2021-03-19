package com.app.bean;

import com.app.entity.ColorEntity;

public class ColorTransformer {

	public static ColorDto transformEntityToBean(ColorEntity colorEntity) {
		ColorDto colorDto = new ColorDto();
		colorDto.setId(colorEntity.getId());
		colorDto.setColor(colorEntity.getColor());
		return colorDto;
	}

}

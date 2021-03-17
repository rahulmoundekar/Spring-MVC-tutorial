package com.app.transformer;

import com.app.dto.AddressDto;
import com.app.entity.Address;

public class AddressTransformer {

	public static Address addressBeanToEntity(AddressDto addressDto) {
		Address address = new Address();
		if (address.getId() != null)
			address.setId(addressDto.getId());
		address.setCity(addressDto.getCity());
		address.setPincode(addressDto.getPincode());
		return address;
	}

}

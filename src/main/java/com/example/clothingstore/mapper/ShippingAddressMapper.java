package com.example.clothingstore.mapper;

import com.example.clothingstore.dto.shippingaddress.ShippingAddressRequestDTO;
import com.example.clothingstore.dto.shippingaddress.ShippingAddressResponseDTO;
import com.example.clothingstore.model.ShippingAddress;

public class ShippingAddressMapper {

    public static ShippingAddress convertShippingAddressRequestDTOToModel(
            ShippingAddressRequestDTO shippingAddressRequestDTO, ShippingAddress shippingAddress) {
        shippingAddress.setRecipientName(shippingAddressRequestDTO.getRecipientName());

        shippingAddress.setPhoneNumber(shippingAddressRequestDTO.getPhoneNumber());

        shippingAddress.setDetailedAdress(shippingAddressRequestDTO.getDetailedAdress());

        shippingAddress.setWard(shippingAddressRequestDTO.getWard());

        shippingAddress.setProvince(shippingAddressRequestDTO.getProvince());
        return shippingAddress;
    }

    public static ShippingAddressResponseDTO convertModelToShippingAddressResponseDTO(ShippingAddress shippingAddress) {
        ShippingAddressResponseDTO shippingAddressResponseDTO = new ShippingAddressResponseDTO();

        shippingAddressResponseDTO.setAddressId(shippingAddress.getAddressId());

        shippingAddressResponseDTO.setRecipientName(shippingAddress.getRecipientName());

        shippingAddressResponseDTO.setPhoneNumber(shippingAddress.getPhoneNumber());

        shippingAddressResponseDTO.setDetailedAdress(shippingAddress.getDetailedAdress());

        shippingAddressResponseDTO.setWard(shippingAddress.getWard());

        shippingAddressResponseDTO.setProvince(shippingAddress.getProvince());

        return shippingAddressResponseDTO;
    }
}

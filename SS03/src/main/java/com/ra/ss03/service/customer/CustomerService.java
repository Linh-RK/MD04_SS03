package com.ra.ss03.service.customer;

import com.ra.ss03.model.dto.customer.request.CustomerRequestDTO;
import com.ra.ss03.model.dto.customer.response.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerResponseDTO> findAll();
    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO findById(Long id);
}

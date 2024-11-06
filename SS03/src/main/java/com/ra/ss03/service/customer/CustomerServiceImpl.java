package com.ra.ss03.service.customer;

import com.ra.ss03.model.dto.customer.request.CustomerRequestDTO;
import com.ra.ss03.model.dto.customer.response.CustomerResponseDTO;
import com.ra.ss03.model.entity.customer.Customer;
import com.ra.ss03.repository.CustomerRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerResponseDTO> findAll() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponseDTO> customerResponseDTOS;
        customerResponseDTOS = customers.stream().map(customer -> {
            return CustomerResponseDTO.builder()
                    .id(customer.getId())
                    .email(customer.getEmail())
                    .fullName(customer.getFullName())
                    .birthday(customer.getBirthday())
                    .status(customer.getStatus())
                    .build();
        }).toList();
        return customerResponseDTOS;
    }

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        Customer customerNew = Customer.builder()
                .fullName(customerRequestDTO.getFullName())
                .email(customerRequestDTO.getEmail())
                .password(customerRequestDTO.getPassword())
                .birthday(customerRequestDTO.getBirthday())
                .status(customerRequestDTO.getStatus())
                .build();
        Customer savedCustomer = customerRepository.save(customerNew);
        return CustomerResponseDTO.builder()
                .id(customerNew.getId())
                .email(customerNew.getEmail())
                .fullName(customerNew.getFullName())
                .birthday(customerNew.getBirthday())
                .status(customerNew.getStatus())
                .build();
    }

    @Override
    public CustomerResponseDTO findById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new NoSuchElementException( "Customer not found"));

        return CustomerResponseDTO.builder()
                .id(customer.getId())
                .email(customer.getEmail())
                .fullName(customer.getFullName())
                .birthday(customer.getBirthday())
                .status(customer.getStatus())
                .build();
    }
}

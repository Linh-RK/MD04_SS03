package com.ra.ss03.controller;

import com.ra.ss03.model.dto.customer.request.CustomerRequestDTO;
import com.ra.ss03.model.dto.customer.response.CustomerResponseDTO;
import com.ra.ss03.model.entity.customer.Customer;
import com.ra.ss03.service.customer.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> findAll() {
        List<CustomerResponseDTO> responseDTOs = customerService.findAll();
        return new ResponseEntity<>(responseDTOs, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CustomerResponseDTO> save(@Valid @RequestBody CustomerRequestDTO customerRequestDTO) {

        return new ResponseEntity<>(customerService.save(customerRequestDTO), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> findById(@PathVariable Long id) {
        CustomerResponseDTO customerResponseDTO = customerService.findById(id);
        return new ResponseEntity<>(customerResponseDTO, HttpStatus.OK);
    }
}

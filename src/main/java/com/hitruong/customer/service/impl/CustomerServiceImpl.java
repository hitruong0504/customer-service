package com.hitruong.customer.service.impl;

import com.hitruong.customer.domain.Customer;
import com.hitruong.customer.enumration.CustomerCode;
import com.hitruong.customer.enumration.CustomerRole;
import com.hitruong.customer.enumration.CustomerStatus;
import com.hitruong.customer.domain.dto.CustomerDTO;
import com.hitruong.customer.domain.mapper.CustomerMapper;
import com.hitruong.customer.domain.vm.CustomerVM;
import com.hitruong.customer.exception.ApiException;
import com.hitruong.customer.repository.CustomerRepository;
import com.hitruong.customer.service.CustomerService;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerVM createCustomer(CustomerDTO dto) {
        Customer customer = customerMapper.toEntity(dto);
        customer.setCreatedAt(Instant.now());
        customer.setStatus(CustomerStatus.PENDING);
        customer.setRole(CustomerRole.CUSTOMER);
        customerRepository.save(customer);
        return customerMapper.toVM(customer);
    }

    @Override
    public CustomerVM getCustomer(Long id) throws BadRequestException {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ApiException(CustomerCode.CUSTOMER_NOT_FOUND));
        return customerMapper.toVM(customer);
    }
}

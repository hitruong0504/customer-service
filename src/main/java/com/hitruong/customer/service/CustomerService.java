package com.hitruong.customer.service;

import com.hitruong.customer.domain.dto.CustomerDTO;
import com.hitruong.customer.domain.vm.CustomerVM;
import jakarta.validation.Valid;

public interface CustomerService {
    CustomerVM createCustomer(@Valid CustomerDTO dto);
}

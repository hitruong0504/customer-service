package com.hitruong.customer.service;

import com.hitruong.customer.domain.dto.CustomerDTO;
import com.hitruong.customer.domain.vm.CustomerVM;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;

public interface CustomerService {
    CustomerVM createCustomer(@Valid CustomerDTO dto);

    CustomerVM getCustomer(Long id);

    CustomerVM updateCustomer(Long id, @Valid CustomerDTO dto);
}

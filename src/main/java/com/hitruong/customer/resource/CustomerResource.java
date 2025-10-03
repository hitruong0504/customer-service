package com.hitruong.customer.resource;

import com.hitruong.customer.domain.dto.CustomerDTO;
import com.hitruong.customer.domain.vm.CustomerVM;
import com.hitruong.customer.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerResource {
    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("")
    public ResponseEntity<CustomerVM> createCustomer(
            @Valid @RequestBody CustomerDTO dto
    ){
        CustomerVM customerVM = customerService.createCustomer(dto);
        return ResponseEntity.ok().body(customerVM);
    }
}

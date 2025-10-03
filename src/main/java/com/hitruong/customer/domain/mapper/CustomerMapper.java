package com.hitruong.customer.domain.mapper;

import com.hitruong.customer.domain.Customer;
import com.hitruong.customer.domain.dto.CustomerDTO;
import com.hitruong.customer.domain.vm.CustomerVM;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO toDto(Customer customer);
    Customer toEntity(CustomerDTO dto);
    CustomerVM toVM(Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer partialUpdate(CustomerDTO dto, @MappingTarget Customer customer);
}

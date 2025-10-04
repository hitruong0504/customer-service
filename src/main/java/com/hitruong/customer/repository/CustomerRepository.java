package com.hitruong.customer.repository;

import com.hitruong.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END " +
            "FROM Customer c " +
            "WHERE c.email = :#{#email} AND c.isDeleted = false")
    boolean existsByEmail(@Param("email") String email);

    @Query("SELECT c FROM Customer c WHERE c.email = :email AND c.id = :id AND c.isDeleted = false")
    Optional<Customer> findByEmailAndId(@Param("email") String email, @Param("id") Long id);
}

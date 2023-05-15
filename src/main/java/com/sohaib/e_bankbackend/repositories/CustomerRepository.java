package com.sohaib.e_bankbackend.repositories;

import com.sohaib.e_bankbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

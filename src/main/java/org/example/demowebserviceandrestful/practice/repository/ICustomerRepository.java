package org.example.demowebserviceandrestful.practice.repository;

import org.example.demowebserviceandrestful.practice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}

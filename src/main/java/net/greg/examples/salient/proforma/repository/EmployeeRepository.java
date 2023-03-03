package net.greg.examples.salient.proforma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.greg.examples.salient.proforma.model.Employee;


@Repository
public interface EmployeeRepository
    extends JpaRepository<Employee, Long>
      { /* Marker */ }

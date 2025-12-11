package com.empresa.empleados.service;

import com.empresa.empleados.repository.EmployeeRepository;
import com.empresa.empleados.service.EmployeeService;

import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EmployeeService {
private final EmployeeRepository repo;
public EmployeeService(EmployeeRepository repo) {
this.repo = repo;
}
public List<Employee> findAll() {
return repo.findAll();
}
public Employee findById(Long id) {
return repo.findById(id).orElse(null);
}
public void save(Employee e) {
repo.save(e);
}
public void delete(Long id) {
repo.deleteById(id);
}
}
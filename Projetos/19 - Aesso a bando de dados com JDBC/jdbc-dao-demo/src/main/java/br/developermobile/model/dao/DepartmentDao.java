package br.developermobile.model.dao;

import br.developermobile.model.entities.Department;

import java.util.List;

public interface DepartmentDao {
    void insert(Department department);
    void update(Department department);
    void delete(Integer id);
    Department findById(Integer id);
    List<Department> findAll();
}

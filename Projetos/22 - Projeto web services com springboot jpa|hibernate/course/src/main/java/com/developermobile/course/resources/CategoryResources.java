package com.developermobile.course.resources;

import com.developermobile.course.entities.Category;
import com.developermobile.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryResources {
    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> userList = service.findAll();
        return ResponseEntity.ok().body(userList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}

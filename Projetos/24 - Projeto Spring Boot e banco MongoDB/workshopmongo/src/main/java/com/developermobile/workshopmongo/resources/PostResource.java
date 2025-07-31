package com.developermobile.workshopmongo.resources;

import com.developermobile.workshopmongo.domain.Post;
import com.developermobile.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}

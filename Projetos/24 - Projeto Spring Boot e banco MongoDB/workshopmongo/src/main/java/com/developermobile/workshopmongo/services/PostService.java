package com.developermobile.workshopmongo.services;

import com.developermobile.workshopmongo.domain.Post;
import com.developermobile.workshopmongo.repository.PostRepository;
import com.developermobile.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
    }
}

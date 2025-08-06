package com.developermobile.workshopmongo.services;

import com.developermobile.workshopmongo.domain.Post;
import com.developermobile.workshopmongo.repository.PostRepository;
import com.developermobile.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return repository.findByTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24L * 60 * 60 * 1000);
        return repository.fullSearch(text, minDate, maxDate);
    }
}

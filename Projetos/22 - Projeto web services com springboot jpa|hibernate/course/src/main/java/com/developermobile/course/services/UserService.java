package com.developermobile.course.services;

import com.developermobile.course.entities.User;
import com.developermobile.course.repositories.UserRepository;
import com.developermobile.course.services.exception.DatabaseException;
import com.developermobile.course.services.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return repository.save(user);
    }

    /***
     * Apartir da versao 3 ou superior do springboot a excecao EmptyResultDataAccessException
     * Ja e tratada por padrao.
     * Para gerar uma excecao personalizada e necessario implementar da forma abaixo.
     */
    public void delete(Long id) {
       try {
           if (repository.existsById(id)) {
               repository.deleteById(id);
           } else {
               throw new ResourceNotFoundException(id);
           }
       } catch (EmptyResultDataAccessException e) {
           throw new ResourceNotFoundException(id);
       } catch (DataIntegrityViolationException e) {
          throw new DatabaseException(e.getMessage());
       }
    }

    public User update(Long id, User user) {
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, user);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}

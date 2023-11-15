package br.com.leobarreto.userapi.impl;

import br.com.leobarreto.userapi.domain.User;
import br.com.leobarreto.userapi.repository.UserRepository;
import br.com.leobarreto.userapi.services.UserService;
import br.com.leobarreto.userapi.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public User findUserById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found with this id!"));
    }

    public List<User> listAllUsers() {
        return repository.findAll();
    }
}

package br.com.leobarreto.userapi.impl;

import br.com.leobarreto.userapi.domain.User;
import br.com.leobarreto.userapi.repository.UserRepository;
import br.com.leobarreto.userapi.services.UserService;
import br.com.leobarreto.userapi.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final Environment env;
    private final UserRepository repository;

    public User findUserById(Long id) {
        log.info("USER_SERVICE ::: Get request on port " + env.getProperty("local.server.port"));
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found with this id!"));
    }

    public List<User> listAllUsers() {
        return repository.findAll();
    }
}

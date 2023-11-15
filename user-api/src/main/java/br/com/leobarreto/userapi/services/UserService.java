package br.com.leobarreto.userapi.services;

import br.com.leobarreto.userapi.domain.User;

import java.util.List;

public interface UserService {
    User findUserById(Long id);
    List<User> listAllUsers();
}

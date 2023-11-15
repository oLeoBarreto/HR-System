package br.com.leobarreto.userapi.resources.Impl;

import br.com.leobarreto.userapi.domain.User;
import br.com.leobarreto.userapi.resources.UserResource;
import br.com.leobarreto.userapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserResourceImpl implements UserResource {

    private final UserService service;

    public ResponseEntity<User> getUserById(Long id) {
        return new ResponseEntity<>(service.findUserById(id), HttpStatus.FOUND);
    }

    public ResponseEntity<List<User>> getUserList() {
        return new ResponseEntity<>(service.listAllUsers(), HttpStatus.OK);
    }
}

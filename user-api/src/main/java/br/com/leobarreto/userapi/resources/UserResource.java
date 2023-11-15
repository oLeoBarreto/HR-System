package br.com.leobarreto.userapi.resources;

import br.com.leobarreto.userapi.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserResource {
    @GetMapping("/{id}")
    ResponseEntity<User> getUserById(@PathVariable Long id);

    @GetMapping()
    ResponseEntity<List<User>> getUserList();
}

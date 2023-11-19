package br.com.leobarreto.payrollapi.feignClients;

import br.com.leobarreto.payrollapi.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "user-api")
public interface UserFeign {
    @GetMapping("/api/users/{id}")
    ResponseEntity<User> getUserById(@PathVariable Long id);

    @GetMapping("/api/users")
    ResponseEntity<List<User>> getUserList();
}

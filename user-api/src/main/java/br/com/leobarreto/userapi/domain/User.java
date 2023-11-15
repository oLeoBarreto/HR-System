package br.com.leobarreto.userapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import static lombok.EqualsAndHashCode.Include;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Include
    private Long id;
    private String name;
    private String email;
    private String password;
    private Double hourlyPrice;
}

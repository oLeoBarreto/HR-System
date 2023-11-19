package br.com.leobarreto.payrollapi.services;

import br.com.leobarreto.payrollapi.domain.Payroll;
import br.com.leobarreto.payrollapi.feignClients.UserFeign;
import br.com.leobarreto.payrollapi.services.exceptions.ObjectNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PayrollService {

    private final UserFeign feign;

    public Payroll getPayment(Long workerId, Payroll payroll) {
        try {
            var user = feign.getUserById(workerId).getBody();

            if (Objects.nonNull(user)) {
                return new Payroll(
                        user.getName(),
                        payroll.getDescription(),
                        user.getHourlyPrice(),
                        payroll.getWorkedHours(),
                        user.getHourlyPrice() * payroll.getWorkedHours()
                );
            }
        } catch (FeignException.NotFound ex) {
            throw new ObjectNotFoundException("Object not found!");
        } catch (Exception ex) {
            throw new IllegalArgumentException("illegal argument exception!");
        }
        return null;
    }
}

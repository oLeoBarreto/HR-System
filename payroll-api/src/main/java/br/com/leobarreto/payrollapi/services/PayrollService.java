package br.com.leobarreto.payrollapi.services;

import br.com.leobarreto.payrollapi.domain.Payroll;
import br.com.leobarreto.payrollapi.feignClients.UserFeign;
import br.com.leobarreto.payrollapi.services.exceptions.ObjectNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class PayrollService {

    private final Environment env;
    private final UserFeign feign;

    public Payroll getPayment(Long workerId, Payroll payroll) {
        log.info("PAYROLL_SERVICE ::: Get request on port " + env.getProperty("local.server.port"));

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

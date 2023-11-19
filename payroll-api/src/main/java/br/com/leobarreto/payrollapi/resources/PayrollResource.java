package br.com.leobarreto.payrollapi.resources;

import br.com.leobarreto.payrollapi.domain.Payroll;
import br.com.leobarreto.payrollapi.services.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/payments")
@RequiredArgsConstructor
public class PayrollResource {

    private final PayrollService payrollService;

    @GetMapping("/{workerId}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payment) {
        return new ResponseEntity<>(payrollService.getPayment(workerId, payment), HttpStatus.OK);
    }
}

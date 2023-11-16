package br.com.leobarreto.payrollapi.resources;

import br.com.leobarreto.payrollapi.domain.Payroll;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/payments")
public class PayrollResource {
    @GetMapping("/{workerId}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payment) {
        Payroll payroll = new Payroll(
                "User1",
                payment.getDescription(),
                payment.getHourlyPrice(),
                100.0,
                payment.getHourlyPrice() * payment.getWorkedHours()
        );
        return new ResponseEntity<>(payroll, HttpStatus.OK);
    }
}

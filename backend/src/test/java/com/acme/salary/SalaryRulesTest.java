package com.acme.salary;
import org.junit.jupiter.api.Test;import java.math.BigDecimal;import java.time.LocalDate;import static org.junit.jupiter.api.Assertions.*;
class SalaryRulesTest{
 @Test void acceptsValidSalary(){assertDoesNotThrow(()->SalaryRules.validate(new BigDecimal("75000"),new BigDecimal("5000"),"INR",LocalDate.parse("2026-01-01"),"Annual review"));}
 @Test void rejectsNegativeSalary(){assertThrows(IllegalArgumentException.class,()->SalaryRules.validate(new BigDecimal("-1"),BigDecimal.ZERO,"INR",LocalDate.now(),"Correction"));}
 @Test void rejectsInvalidCurrency(){assertThrows(IllegalArgumentException.class,()->SalaryRules.validate(BigDecimal.ONE,BigDecimal.ZERO,"US",LocalDate.now(),"Reason"));}
 @Test void rejectsBlankReason(){assertThrows(IllegalArgumentException.class,()->SalaryRules.validate(BigDecimal.ONE,BigDecimal.ZERO,"USD",LocalDate.now()," "));}
 @Test void rejectsMissingDate(){assertThrows(IllegalArgumentException.class,()->SalaryRules.validate(BigDecimal.ONE,BigDecimal.ZERO,"USD",null,"Reason"));}
}

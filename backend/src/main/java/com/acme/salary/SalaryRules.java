package com.acme.salary;
import java.math.BigDecimal;import java.time.LocalDate;import java.util.Locale;import java.util.regex.Pattern;
public final class SalaryRules{
 private static final Pattern CURRENCY=Pattern.compile("[A-Z]{3}");private SalaryRules(){}
 public static void validate(BigDecimal amount,BigDecimal bonus,String currency,LocalDate date,String reason){
  if(amount==null||amount.signum()<0)throw new IllegalArgumentException("Salary must be zero or greater");
  if(bonus==null||bonus.signum()<0)throw new IllegalArgumentException("Bonus must be zero or greater");
  if(currency==null||!CURRENCY.matcher(currency.toUpperCase(Locale.ROOT)).matches())throw new IllegalArgumentException("Currency must be a three-letter code");
  if(date==null)throw new IllegalArgumentException("Effective date is required");
  if(reason==null||reason.isBlank())throw new IllegalArgumentException("Reason is required");
 }
}

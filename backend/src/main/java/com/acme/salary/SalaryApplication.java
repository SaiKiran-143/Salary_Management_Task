package com.acme.salary;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import java.util.List;
@SpringBootApplication
public class SalaryApplication {
 public static void main(String[] args){SpringApplication.run(SalaryApplication.class,args);}
 @Bean CommandLineRunner seed(JdbcTemplate db){return args->{
  Integer count=db.queryForObject("SELECT COUNT(*) FROM employee",Integer.class); if(count!=null&&count>0)return;
  List<String> countries=List.of("India","United States","United Kingdom","Germany","Singapore","Australia");
  List<String> depts=List.of("Engineering","Finance","Human Resources","Sales","Operations","Marketing");
  List<String> titles=List.of("Software Engineer","Analyst","HR Specialist","Account Manager","Operations Lead","Product Manager");
  String[] first={"Aarav","Maya","Noah","Sofia","Liam","Anaya","Oliver","Isha","Ethan","Zara"};
  String[] last={"Sharma","Patel","Smith","Brown","Garcia","Wilson","Kumar","Taylor","Martin","Lee"};
  db.batchUpdate("INSERT INTO employee(employee_number,first_name,last_name,email,country,department,job_title,employment_status) VALUES(?,?,?,?,?,?,?,?)",
   java.util.stream.IntStream.rangeClosed(1,10000).mapToObj(i->new Object[]{String.format("AC%05d",i),first[(i-1)%10],last[(i*7)%10],"employee"+i+"@acme.example",countries[(i-1)%6],depts[(i-1)%6],titles[(i-1)%6],i%23==0?"INACTIVE":"ACTIVE"}).toList());
  db.batchUpdate("INSERT INTO salary_record(employee_id,amount,currency,bonus,effective_date,reason) VALUES(?,?,?,?,?,?)",
   java.util.stream.IntStream.rangeClosed(1,10000).mapToObj(i->new Object[]{i,35000+(i%20)*2500,currency(i),(i%10)*500,"2026-01-01","Initial seeded salary"}).toList());
 };}
 static String currency(int i){return switch((i-1)%6){case 0->"INR";case 1->"USD";case 2->"GBP";case 3->"EUR";case 4->"SGD";default->"AUD";};}
}

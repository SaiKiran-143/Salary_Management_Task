CREATE TABLE IF NOT EXISTS employee(id INTEGER PRIMARY KEY AUTOINCREMENT,employee_number TEXT NOT NULL UNIQUE,first_name TEXT NOT NULL,last_name TEXT NOT NULL,email TEXT NOT NULL UNIQUE,country TEXT NOT NULL,department TEXT NOT NULL,job_title TEXT NOT NULL,employment_status TEXT NOT NULL DEFAULT 'ACTIVE');
CREATE TABLE IF NOT EXISTS salary_record(id INTEGER PRIMARY KEY AUTOINCREMENT,employee_id INTEGER NOT NULL,amount NUMERIC NOT NULL CHECK(amount>=0),currency TEXT NOT NULL CHECK(length(currency)=3),bonus NUMERIC NOT NULL DEFAULT 0 CHECK(bonus>=0),effective_date TEXT NOT NULL,reason TEXT NOT NULL,FOREIGN KEY(employee_id) REFERENCES employee(id));
CREATE INDEX IF NOT EXISTS idx_employee_country ON employee(country);
CREATE INDEX IF NOT EXISTS idx_employee_department ON employee(department);
CREATE INDEX IF NOT EXISTS idx_employee_name ON employee(last_name,first_name);
CREATE INDEX IF NOT EXISTS idx_salary_employee_date ON salary_record(employee_id,effective_date DESC);

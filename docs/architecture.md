# Architecture

React HR console -> JSON REST -> Spring Boot controllers -> JDBC repository queries -> SQLite.

`employee` stores identity and organizational attributes. `salary_record` stores amount, currency, bonus, effective date and reason. Salary changes insert a row, preserving history. Employee list is paginated and filtered in SQL; country and department analytics group by currency so unlike currencies are not added.

10,000 rows is modest for a relational database. SQLite is convenient for a single-instance assessment; PostgreSQL is recommended for production multi-user deployment. Seed data is synthetic. Add SSO/RBAC, TLS, encryption at rest, secrets management, immutable audit events, backups, monitoring, rate limiting and privacy/retention controls before production.

AI is used to accelerate requirements, scaffolding and test ideation; generated code must be reviewed and tested by the engineer. Runtime analytics are deterministic SQL, not AI-generated salary decisions.

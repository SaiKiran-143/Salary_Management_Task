# ACME Salary Management
Java 17 + Spring Boot 3.3 + Spring JDBC + SQLite backend; React 18 + Vite frontend.

## Run
Backend: `cd backend && mvn spring-boot:run` (http://localhost:8080/api)
Frontend: `cd frontend && npm install && npm run dev` (http://localhost:5173)
Tests: `cd backend && mvn test`

The backend creates a local SQLite database and seeds 10,000 synthetic employees on first startup. The UI supports paginated employee search/filter, salary update and salary analytics.

## Decisions
Salary history is append-only in a separate table. Amounts are grouped by currency; unlike currencies are never summed. Employee list queries are paginated server-side. SQLite is chosen for simple local assessment setup; use PostgreSQL for production. Authentication/SSO, RBAC, payroll/tax calculations, payment execution, approvals, external HRIS integrations and FX conversion are excluded because the brief supplies no identity provider, legal rules, integration details or exchange-rate source.

Before production: add SSO/RBAC, TLS, encryption, immutable audit events, backups, monitoring, privacy controls and approval workflow. Seed data is synthetic only.

## Suggested incremental commits
1. `docs: add requirements and architecture`
2. `feat: add employee and salary persistence`
3. `feat: add employee and salary REST APIs`
4. `feat: add dashboard and analytics`
5. `feat: add React HR dashboard`
6. `test: cover salary validation`

# ACME Salary Management

A web application that lets an HR Manager manage employee salary records and understand
compensation across ACME's workforce of 10,000 employees in six countries.

## Features

### Employees
- Directory of all 10,000 employees: name, email, employee ID, country, department,
  job title, base salary (with currency) and employment status.
- Live search by name, email or employee ID.
- Filter by country and department; the record count updates with every filter.
- Update an employee's salary directly from the list.
- Summary cards: total employees, active employees, and total compensation of active
  employees, grouped by currency (no currency conversion, so figures are never mixed).

### Salary insights
- Number of employees plus average, minimum and maximum base salary,
  grouped by country and by department.
- Figures are shown in each group's own currency.

### General
- Refresh button reloads the latest data.
- Seeded with 10,000 synthetic employees (not for production payroll).

## Known limitations
- Seed data is synthetic; each department maps to a single country, so the
  department breakdown mirrors the country breakdown.
- No authentication (single HR Manager persona).
- Amounts are not converted between currencies.

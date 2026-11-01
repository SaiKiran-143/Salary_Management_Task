# ACME Salary Management — Requirements

## Goal
Replace spreadsheet-based salary administration for 10,000 employees across multiple countries with web-based software for HR managers to maintain salary records and answer questions about compensation.

## User
HR Manager.

## In scope
- Employee directory with server-side search, country/department filters and pagination.
- Employee identity, country, department, job title and employment status.
- Record salary changes with amount, currency, bonus, effective date and reason.
- Preserve salary history instead of overwriting prior values.
- Dashboard: employee count, active employee count and compensation totals grouped by currency.
- Analytics: average/minimum/maximum salary by country and department, grouped by currency.
- Deterministic seed script for 10,000 synthetic employees.
- REST backend, responsive React UI, validation and unit tests.

## Deliberately out of scope
- Payroll execution, payslips, tax/benefit calculations and bank transfers: country-specific rules and integrations are unspecified.
- SSO, authentication and granular RBAC: no identity provider or access model was supplied. These are mandatory before real data is used.
- Approval workflows, salary bands, budgeting and performance management: beyond the initial spreadsheet replacement.
- External HRIS/finance/AI integrations and FX conversion: no systems, credentials or trusted exchange-rate source are specified.

## Assumptions and acceptance
An employee has many salary records; latest effective date is current. Salary and bonus must be non-negative; currency is a three-letter code; effective date and reason are mandatory. App seeds 10,000 records only on an empty database. HR can search/filter/page employees, update employee details, add a salary record, and view currency-aware dashboard/analytics.

## Non-functional
Clear controller/service/repository separation, indexed filters, SQL pagination, deterministic tests, predictable errors and synthetic-only seed data. Production requires PostgreSQL, access controls, encryption, audit logging, backups and country-specific privacy controls.

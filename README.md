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

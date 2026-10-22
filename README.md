# EcoSphere AI

EcoSphere AI is a self-contained Java Spring Boot product for e-waste tracking, sustainability intelligence, innovation projects, ESG reporting, and school-community engagement.

## Features
- Role-based access for student, teacher, coordinator, principal, and corporate partner views
- Waste registry and collection tracking
- Project innovation pipeline
- Leaderboard and badges
- ESG dashboard and sustainability metrics
- Startup-style dashboard UI
- Local demo mode with embedded H2 database

## Run locally
1. Install Java 17+
2. Clone the repo
3. Run:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
4. Open in browser:
   ```text
   http://localhost:8080/dashboard
   ```

## Demo login
- Email: admin@ecosphere.ai
- Password: password123

## Notes
This is a self-contained scalable app version designed for local demos and investor presentations. It is structured so it can later be upgraded to a production cloud deployment with PostgreSQL and full CI/CD.

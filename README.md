# projektor-api
The application [Application Name] is a project management platform designed to help teams collaborate effectively and organize their projects throughout their lifecycle. It offers a range of features aimed at simplifying project planning, execution, and monitoring, while fostering communication and collaboration among team members.

Here are some of the main objectives and functionalities of the application:

    Task and Progress Management:
        Creation and assignment of tasks to team members.
        Tracking of progress and task completion stages.
        Prioritization and setting of deadlines for tasks.

    Project Planning:
        Creation of detailed project plans with milestones, dependencies, and schedules.
        Resource management and work allocations.

    Resource Tracking:
        Management of human and material resources allocated to each project.
        Tracking of work hours and associated costs for resources.

    Team Collaboration:
        Integrated communication tools to allow team members to discuss, share files, and coordinate their efforts.
        Customizable dashboards to display progress, tasks to be done, upcoming events, etc.

    Analysis and Reporting:
        Generation of reports on project performance, timelines, budgets, etc.
        Tracking of key performance indicators (KPIs) to assess the overall health of the project.

    Customization and Flexibility:
        Customization of workflows, project templates, and application settings to meet the specific needs of each team and project.

The application aims to streamline project management by providing a centralized and collaborative solution to organize, plan, and execute projects successfully. Whether for a small software development team or a large enterprise managing multiple projects simultaneously, [Application Name] aims to provide the necessary tools to ensure effective and transparent project management.

# Projektor API Backend

## Description
The Projektor API Backend serves as the server-side component of the Projektor project management platform. It provides the necessary logic and APIs to facilitate project management functionalities, including task management, project planning, resource tracking, team collaboration, and more.

## Features
- Task and Progress Management
- Project Planning
- Resource Tracking
- Team Collaboration
- Analysis and Reporting
- Customization and Flexibility

## Docker Setup
The Docker Compose file provided in the repository can be used to set up the MySQL database for the Projektor API Backend. Follow the instructions below to get started:

1. Ensure that Docker is installed on your system.

2. Create a `.env` file in the root directory of the project with the following environment variables:

DB_ROOT_PASSWORD=your_root_password
DB_DATABASE=your_database_name
DB_USER=your_database_user
DB_USER_PASSWORD=your_database_user_password
DB_LOCAL_PORT=your_local_mysql_port
DB_DOCKER_PORT=3306
PMA_LOCAL_PORT=your_local_phpmyadmin_port
PMA_DOCKER_PORT=8080

bash


3. Run the following command to start the MySQL database and PHPMyAdmin containers:

docker-compose up --build

csharp


4. Access PHPMyAdmin via `http://localhost:your_local_phpmyadmin_port` in your web browser to manage the MySQL database.

## Development Environment
- The project is developed using IntelliJ IDEA.
- GitHub is used for project management.
- MySQL database is dockerized for development purposes.

## Contact
For questions or support, please contact Stephanie Ursulet at [your_email@example.com].


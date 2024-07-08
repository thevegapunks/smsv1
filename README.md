# SMSv1 Project

## Overview
SMSv1 is a School Management System designed to manage and streamline various school operations. This project is built using Java and Gradle, following a robust and scalable architecture that includes controllers, services, repositories, mappers, and models.

## Project Structure
```
smsv1
├── .gradle
├── .idea
├── build
├── gradle
├── src
├── .gitignore
├── build.gradle
├── gradlew
├── gradlew.bat
└── settings.gradle
```

### Detailed Directory Structure
- **.gradle/**: Gradle-specific files and caches.
- **.idea/**: IntelliJ IDEA project files.
- **build/**: Compiled classes, generated sources, reports, and other build outputs.
- **gradle/**: Gradle wrapper files.
- **src/**: Source code for the application.

  - **main/**: Main application source code.
    - **java/**: Java source files.
      - **com.digitechbb.smsv1**: Base package.
        - **controllers**: REST controllers handling HTTP requests.
        - **enums**: Enumeration types used in the project.
        - **exception**: Custom exception handling classes.
        - **mappers**: Mapper interfaces and implementations for DTO to entity conversions.
        - **model**: Data models, including entities and DTOs.
        - **repositories**: Spring Data JPA repositories.
        - **services**: Business logic services and their implementations.
        - **Smsv1Application.java**: Main application class.
    - **resources**: Application resources (e.g., properties files).

  - **test/**: Test source code.
    - **java**: Java test files.
      - **com.digitechbb.smsv1**: Base test package.
        - **Smsv1ApplicationTests.java**: Main test class.

## Key Components
### Controllers
- **AbsenceController**
- **AccountController**
- **ClassroomController**
- **EmployeeController**
- **ProfessorController**
- **ScholarLevelController**
- **StudentController**
- **SubjectController**
- **YearController**

### Services
- **AbsenceService**
- **AccountService**
- **ClassroomService**
- **EmployeeService**
- **ProfessorService**
- **ScholarLevelService**
- **StudentService**
- **SubjectService**
- **YearService**

### Mappers
- **AbsenceMapper**
- **AccountMapper**
- **ClassroomMapper**
- **EmployeeMapper**
- **ProfessorMapper**
- **ScholarLevelMapper**
- **StudentMapper**
- **SubjectMapper**
- **YearMapper**

### Models
- **Entities**: Absence, Account, Classroom, Employee, Person, Professor, ScholarLevel, Session, Student, Subject, Year
- **DTOs**: AbsenceDto, AccountDto, ClassroomDto, EmployeeDto, ProfessorDto, ScholarLevelDto, StudentDto, SubjectDto, YearDto

### Repositories
- **AbsenceRepository**
- **AccountRepository**
- **ClassroomRepository**
- **EmployeeRepository**
- **ProfessorRepository**
- **ScholarLevelRepository**
- **StudentRepository**
- **SubjectRepository**
- **YearRepository**

### Exception Handling
- **ControllerExceptionHandler**
- **ErrorMessage**
- **ResourceNotFoundException**


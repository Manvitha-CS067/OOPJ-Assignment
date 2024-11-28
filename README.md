# OOPJ Assignment

## Software Requirements
- Java JDK: Java Development Kit (JDK) 11 or later.
- Text Editor: Notepad
- Operating System: Compatible with Windows, macOS, or Linux.

## Project Overview
This project is an OOPJ (Object Oriented Programming in Java) assignment aimed at practicing class and object-oriented concepts. The project involves reading input from a file, processing the data, and outputting results to another file.

## Classes and Interfaces

### MaintenanceReport
- Attributes:
  - String reportId
  - String usn
  - String problemDescription
  - String reporterName
  - String status
  - String assignedTo
  - LocalDate reportDate
  - LocalDate lastUpdated
  - String department
- Methods:
  - displayReportDetails()
  - updateStatus(String newStatus)
  - needsEscalation()
  - escalateToPrincipal()
  - assignTask(String assignedTo)
  - closeReport()

### Principal
- Attributes:
  - String principalName
- Methods:
  - takeAction(MaintenanceReport report)

### Department
- Attributes:
  - String departmentName
  - String hodName
- Methods:
  - notifyHOD(MaintenanceReport report)
  - getHodName()

### MaintenanceTeam
- Attributes:
  - String teamName
- Methods:
  - assignTask(String assignedTo)
  - closeReport()

### Reporter
- Attributes:
  - String reporterName
  - String usn
- Methods:
  - displayReporterDetails()

### MaintenanceActions
- Methods:
  - assignTask(String assignedTo)
  - closeReport()

### USNParser
- Methods:
  - getBranchFromUSN(String usn)

## GitHub Actions Setup
This repository uses GitHub Actions for Continuous Integration (CI) to automatically compile and test the Java code. The configuration is specified in the .github/workflows/java-ci.yml file.

## Setup Instructions
1. Clone the Repository:
   sh git clone https://github.com/Manvitha-CS067/OOPJ-Assignment.git
    
2. Navigate to the Project Directory:
    sh cd OOPJ-Assignment
    
3. Compile the Java Files:
    sh javac -d bin *.java
    
4. Run the Main Class:
    sh java -cp bin TestClassInput
    

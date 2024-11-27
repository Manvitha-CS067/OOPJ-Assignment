# OOPJ-Assignment

## Software Requirements
-> Operating System : Windows
-> Programming Language : Java 
-> Text Editor : Notepad
-> JDK version : 22

## Project Overview 
This project is an OOPJ (Object Oriented Programming in Java) assignment aimed at practicing class and object-oriented concepts. The project involves reading input from a file, processing the data, and outputting results to another file. 

## Classes and Interfaces 
### MaintenanceReport
  **Attributes**:
    ->`String reportId`
    ->`String usn`
    ->`String problemDescription`
    ->`String reporterName`
    ->`String status`
    ->`String assignedTo`
    ->`LocalDate reportDate`
    ->`LocalDate lastUpdated`
  **Methods**:
    ->`displayReportDetails()`
    ->`updateStatus(String newStatus)`
    ->`needsEscalation()`
    ->`escalateToPrincipal()` 
 ### Principal
   **Attributes**:
   ->`String principalName`
   **Methods**:
   ->`takeAction(MaintenanceReport report)` 
### Department
  **Attributes**:
  ->`String departmentName`
  ->`String hodName`
  **Methods**:
  ->`notifyHOD(MaintenanceReport report)` 
## Input/Output Files
  **Input File**: 
  ->`input1.txt` containing maintenance report data.
  **Output File**: 
  ->`output.txt` for processed results and notifications.

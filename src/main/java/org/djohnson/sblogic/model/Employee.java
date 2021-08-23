package org.djohnson.sblogic.model;

/**
 * Employee represents an employee object (name, rank, serial number).
 * 
 * @author DJohnson
 * @since 1.0.0
 *
 */
public class Employee {

 private final int id;
 private final String name;
 private final String designation;
 private final String department;

 /**
  * Create a new instance of Employee.
  * 
  * @param id			the unique identifier of the employee
  * @param name			the employee's name
  * @param designation	the employee's designation
  * @param department	the employee's department
  */
 public Employee(final int id, final String name, final String designation, final String department) {
     this.id = id;
     this.name = name;
     this.designation = designation;
     this.department = department;
 }

 public Integer getId() {
     return id;
 }
 
 public String getName() {
     return name;
 }
 
 public String getDesignation() {
     return designation;
 }
 
 public String getDepartment() {
     return department;
 }
 
}
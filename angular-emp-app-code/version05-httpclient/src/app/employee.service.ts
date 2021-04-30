import { Injectable } from '@angular/core';
import { Employee } from 'src/model/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  employees: Employee[] =  [
    { empid: 100, name: "Anil Kumar", salary: 25000},
    { empid: 200, name: "Surendra Reddy", salary: 15000},
    { empid: 300, name: "Alok Singh", salary: 18000},
    { empid: 400, name: "Sunitha Rao", salary: 22000},
    { empid: 500, name: "Arathi Gupthar", salary: 16000}
  ]

  constructor() { }

  getEmployees(): Employee[] {
    return this.employees;
  }

  getEmployee(pos: number) {
    return this.employees[pos];
  }

  updateEmployee(pos: number, employee: Employee): void {
    this.employees[pos] = employee;
  }

  deleteEmployee(pos: number): void {
    this.employees.splice(pos, 1);
  }

  addEmployee(newEmp: Employee): string {

    if (newEmp.empid == null)
      return "Invalid or missing Employee Id";

    if (newEmp.salary == null)
      return "Invalid salary";
      
    let pos: number = this.employees.findIndex(
      (emp) => emp.empid == newEmp.empid
    )
    if (pos != -1)
      return "Employee already exists";

    this.employees.push(newEmp);
    return null;
  }
}

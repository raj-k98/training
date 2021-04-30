import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/model/employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'emp-list',
  templateUrl: './emp-list.component.html',
  styleUrls: ['./emp-list.component.css']
})
export class EmpListComponent implements OnInit {

  constructor(private service: EmployeeService) { }

  ngOnInit(): void {
    this.loadData();
  }

  header: string = "List of Employees";

  employees: Employee[];
  message: string = null;

  delete(pos): void {
    this.message = `employee data with id ${this.employees[pos].empid} deleted`
    this.service.deleteEmployee(pos);
    this.loadData();
  }

  loadData(): void {
    this.employees = this.service.getEmployees();
  }

}

import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/model/employee';
import { EmployeeServerService } from '../services/employee-server.service';

@Component({
  selector: 'emp-list',
  templateUrl: './emp-list.component.html',
  styleUrls: ['./emp-list.component.css']
})
export class EmpListComponent implements OnInit {

  constructor(private service: EmployeeServerService) { }

  ngOnInit(): void {
    this.loadData();
  }

  header: string = "List of Employees";

  employees: Employee[];
  message: string = null;
  errorMessage: string = null;

  delete(empid: number): void {
    this.service.deleteEmployee(empid).subscribe(
      (response) => {
        this.message = response;
        this.loadData();
      },
      (error) => console.log(error)
    );

  }

  loadData(): void {

    this.service.getEmployees().subscribe(
      (data) => {
        this.employees = data;
        this.errorMessage = null;
      },
      (failResponse) => {
        this.errorMessage = failResponse.error.errorMessage;
      }
    )
  }

}

import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/model/employee';

@Component({
  selector: 'emp-list',
  templateUrl: './emp-list.component.html',
  styleUrls: ['./emp-list.component.css']
})
export class EmpListComponent {

  constructor() { }

  updtEmployee: Employee = null;
  header: string = "List of Employees";

  employees: Employee[] = [
    { empid: 100, name: "Anil Kumar", salary: 25000, gender: 'M' },
    { empid: 200, name: "Surendra Reddy", salary: 15000, gender: 'M' },
    { empid: 300, name: "Alok Singh", salary: 18000, gender: 'x' },
    { empid: 400, name: "Sunitha Rao", salary: 22000, gender: 'F' },
    { empid: 1400, name: "Arathi Gupthar", salary: 16000, gender: 'F' }
  ]

  create: boolean = false;
  message: string = null;
  createMessage: string = null;

  empToUpdate: Employee = null;

  empid: number;
  name: string;
  salary: number;
  gender: string;

  delete(pos): void {
    this.message = `employee data with id ${this.employees[pos].empid} deleted`
    this.employees.splice(pos, 1);
  }

  modify(pos): void {
    this.empToUpdate = this.employees[pos];
  }

  jobDone(message: string) {
    this.empToUpdate = null;
    this.message = message;
  }

  createNew(): void {

    let pos: number = this.employees.findIndex(
      (obj) => obj.empid == this.empid
    )
    if (pos != -1) {
      this.createMessage = "Employee Id already exists"
    }
    else {
      let newEmp: Employee = { empid: this.empid, name: this.name, salary: this.salary, gender: this.gender };
      this.employees.push(newEmp)
      this.create = false;
    }

  }

  cancel():void{
    this.create=false;
  }
}

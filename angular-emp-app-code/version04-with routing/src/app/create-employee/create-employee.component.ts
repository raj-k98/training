import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/model/employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  message: string = null;
  success: boolean;

  gender: string = 'M'

  constructor(private service: EmployeeService) { }

  ngOnInit() {
  }

  createNew(data: Employee) {
    let result: string = this.service.addEmployee(data)
    if (result) {
      this.message = result;
      this.success = false;
    }
    else {
      this.message = "Data successfully saved";
      this.success = true;
    }
  }
}

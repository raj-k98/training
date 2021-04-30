import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from 'src/model/employee';
import { EmployeeServerService } from '../employee-server.service';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'emp-update',
  templateUrl: './emp-update.component.html',
  styleUrls: ['./emp-update.component.css']
})
export class EmpUpdateComponent implements OnInit {
  employee: Employee;

  validationMessages: string[] = null;
  errorMessage: string = null;
  successMessage: string = null;
  dataFound: boolean = false;
  constructor(private service: EmployeeServerService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {

    this.route.paramMap.subscribe(
      (params) => {
        let eid: number = +params.get('empid');

        this.service.getEmployee(eid).subscribe(
          (data) => {
            this.employee = data
            this.dataFound=true
          },
          (fail) => {
            this.errorMessage = fail.error.errorMessage;
            this.dataFound = false;
          }
        )
      }
    )
  }

  updated() {
    this.service.updateEmployee(this.employee).subscribe(
      (message) => {
        this.successMessage=message
        this.validationMessages = null
        this.errorMessage = null
      },
      (failure) => {
        this.successMessage = null;
        this.validationMessages = JSON.parse(failure.error).errors;
        this.errorMessage = JSON.parse(failure.error).errorMessage;
      }

    )

  }


  goBack(){
    this.router.navigate(["emplist"]);
  }
}

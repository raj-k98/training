import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from 'src/model/employee';
import { EmployeeServerService } from '../services/employee-server.service';


@Component({
  selector: 'emp-update',
  templateUrl: './emp-update.component.html',
  styleUrls: ['./emp-update.component.css']
})
export class EmpUpdateComponent implements OnInit {
  employee: Employee=null;

  validationMessages: string[] = null;
  errorMessage: string = null;
  successMessage: string = null;
  
  constructor(private service: EmployeeServerService, 
              private route: ActivatedRoute, 
              private router: Router) { }

  ngOnInit() {

    this.route.paramMap.subscribe(
      (params) => {
        let eid: number = +params.get('empid');

        this.service.getEmployee(eid).subscribe(
          (data) => {
            this.employee = data
          },
          (fail) => {
            this.errorMessage = fail.error.errorMessage;
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

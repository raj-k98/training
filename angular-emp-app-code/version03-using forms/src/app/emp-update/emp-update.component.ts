import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Employee } from 'src/model/employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'emp-update',
  templateUrl: './emp-update.component.html',
  styleUrls: ['./emp-update.component.css']
})
export class EmpUpdateComponent implements OnInit {

  @Input() position: number
  @Output() completed = new EventEmitter();

  employee: Employee;

  constructor(private service: EmployeeService) { }

  ngOnInit() {
    this.employee = this.service.getEmployee(this.position);
  }


  updated() {
    this.service.updateEmployee(this.position, this.employee);
    this.completed.emit("Employee Data Updated");
  }
}

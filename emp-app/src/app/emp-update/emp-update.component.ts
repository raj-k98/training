import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Employee } from 'src/model/employee';

@Component({
  selector: 'emp-update',
  templateUrl: './emp-update.component.html',
  styleUrls: ['./emp-update.component.css']
})
export class EmpUpdateComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  @Input() emp: Employee;
  @Output() completed = new EventEmitter();

  updated() {
      this.completed.emit("Employee Data Updated");
  }
}

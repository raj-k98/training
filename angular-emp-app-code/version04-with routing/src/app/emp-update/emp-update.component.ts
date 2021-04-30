import { Component, OnInit } from '@angular/core';
import { ActivatedRoute ,Router} from '@angular/router';
import { Employee } from 'src/model/employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'emp-update',
  templateUrl: './emp-update.component.html',
  styleUrls: ['./emp-update.component.css']
})
export class EmpUpdateComponent implements OnInit {
  employee: Employee;

  constructor(private service: EmployeeService ,private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {

    this.route.paramMap.subscribe(
      (params) => {
        let pos: number = +params.get('position');
        this.employee = this.service.getEmployee(pos);
      }
    )
  }

  updated(){

    this.router.navigate(["emplist"]);
  }

}

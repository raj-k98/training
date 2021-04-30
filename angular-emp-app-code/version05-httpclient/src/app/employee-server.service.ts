import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from 'src/model/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeServerService {

  baseUrl: string = "http://localhost:9090/employees"

  constructor(private http: HttpClient) { }

  getEmployees(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  getEmployee(eid: number):Observable<any> {
    return this.http.get(`${this.baseUrl}/${eid}`)
  }

  updateEmployee(employee: Employee):Observable<any> {
    return this.http.put(this.baseUrl, employee, { responseType: 'text' });
  }

  deleteEmployee(eid: number): Observable<any> {
    //include responseType in options because response by default is JSON
    return this.http.delete(`${this.baseUrl}/${eid}`, { responseType: 'text' })  // this.baseUrl+"/"+eid
  }

  addEmployee(newEmp: Employee) :Observable<any>{
    return this.http.post(this.baseUrl, newEmp, { responseType: 'text' });
  }
}


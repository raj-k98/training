import { HttpClient, HttpHeaders } from '@angular/common/http';
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
    const headers = new HttpHeaders({ Authorization: localStorage.getItem('token') });
    return this.http.get(this.baseUrl,{headers});
  }

  getEmployee(eid: number): Observable<any> {
    const headers = new HttpHeaders({ Authorization: localStorage.getItem('token') });
    return this.http.get(`${this.baseUrl}/${eid}`, { headers })
  }

  updateEmployee(employee: Employee): Observable<any> {
    const headers = new HttpHeaders({ Authorization: localStorage.getItem('token') });
    return this.http.put(this.baseUrl, employee, { headers, responseType: 'text' });
  }

  deleteEmployee(eid: number): Observable<any> {
    const headers = new HttpHeaders({ Authorization: localStorage.getItem('token') });
    return this.http.delete(`${this.baseUrl}/${eid}`, { headers, responseType: 'text' })
  }

  addEmployee(newEmp: Employee): Observable<any> {
    const headers = new HttpHeaders({ Authorization: localStorage.getItem('token') });
    return this.http.post(this.baseUrl, newEmp, { headers, responseType: 'text' });
  }
}


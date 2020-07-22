import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) { }

  createEmployee(employee: Object): Observable<Object> {
    return this.http.post('http://localhost:8090/employee/employees', employee);
  }

  updateEmployee(id: number, value: any): Observable<Object> {
    return this.http.put('/employee/employees/${id}', value);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.http.delete('/employee/employees/${id}', { responseType: 'text' });
  }

  getEmployeesList(): Observable<any> {
    return this.http.get('http://localhost:8080/employee/employees');
  }

  getEmployee(id: number): Observable<any> {
    return this.http.get('/employee/employees/${id}');
  }

  getEmployeeBy(searchParam, Department): Observable<any> {
    let searchParams = new URLSearchParams();
    searchParams.append('Department', Department);
    return this.http.get('/employee/employees/${id}');
  }


}

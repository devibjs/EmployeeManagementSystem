import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from "rxjs";
import {EmployeeService} from 'src/app/employee.service';
import {Employee} from 'src/app/employee';

@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})    
export class ListEmployeeComponent implements OnInit {
  employees: Observable<Employee[]>;
  employeeArr: Employee[] = [];
  order: boolean = false;
  filterValue: Array<any> = [];

  constructor(private employeeService: EmployeeService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.employees = this.employeeService.getEmployeesList();
  }

  deleteEmployee(id: number) {
    this.employeeService.deleteEmployee(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  employeeDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updateEmployee(id: number){
    this.router.navigate(['update', id]);
  }

  sortData() {
    this.employeeService.getEmployeesList().subscribe(emp => this.employeeArr = emp);
    if (this.order) {
      this.employeeArr = this.employeeArr.sort((i, j) => (j.id > i.id ? -1 : 1));
    }
    else {
      this.employeeArr = this.employeeArr.sort((i, j) => (j.id > i.id ? 1 : -1));
    }
    this.order = !this.order;
  }

  filterByText(initial: string) {
    this.employeeArr = this.filterValue;
    this.employeeArr = this.employeeArr.filter(i => i.department.DeptName.toLowerCase().indexOf(initial.toLocaleLowerCase()) !== -1);
    console.log(this.employeeArr);
  }

}

import { Component, OnInit } from '@angular/core';
import { Department} from 'src/app/department';
import { EmployeeService } from 'src/app/employee.service';
import { Employee } from 'src/app/employee';
import { Router } from '@angular/router';
import { Observable } from "rxjs";

@Component({
  selector: 'app-employee-filter',
  templateUrl: './employee-filter.component.html',
  styleUrls: ['./employee-filter.component.css']
})
export class EmployeeFilterComponent implements OnInit {
  private departments: Department[];
  employees: Observable<Employee[]>;


  constructor(private employeeService: EmployeeService,
    private router: Router) { }

  ngOnInit(): void {this.reloadData();
  }

  reloadData() {
    this.employees = this.employeeService.getEmployeesList();
  }

}

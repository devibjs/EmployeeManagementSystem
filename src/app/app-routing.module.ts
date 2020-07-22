  
import { CreateEmployeeComponent } from './CreateEmployee/create-employee/create-employee.component'
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UpdateEmployeeComponent } from './UpdateEmployee/update-employee/update-employee.component';
import { ListEmployeeComponent } from './ListEmployee/list-employee/list-employee.component';
import { EmployeeFilterComponent } from './EmployeeFilter/employee-filter/employee-filter.component';

const routes: Routes = [
  { path: '', redirectTo: 'employee', pathMatch: 'full' },
  { path: 'employeeslist', component: ListEmployeeComponent },
  { path: 'create', component: CreateEmployeeComponent },
  { path: 'update/:id', component: UpdateEmployeeComponent },
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

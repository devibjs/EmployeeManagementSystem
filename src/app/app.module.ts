import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateEmployeeComponent } from './CreateEmployee/create-employee/create-employee.component';
import { UpdateEmployeeComponent } from './UpdateEmployee/update-employee/update-employee.component';
import { ListEmployeeComponent } from './ListEmployee/list-employee/list-employee.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule  } from '@angular/common/http';
import { EmployeeService} from './employee.service';
import { EmployeeFilterComponent } from './EmployeeFilter/employee-filter/employee-filter.component';
import { NgpSortModule } from "ngp-sort-pipe";

@NgModule({
  declarations: [
    AppComponent,
    CreateEmployeeComponent,
    UpdateEmployeeComponent,
    ListEmployeeComponent,
    EmployeeFilterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,FormsModule,
    HttpClientModule, NgpSortModule
  ],
  providers: [EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }

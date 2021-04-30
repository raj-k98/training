import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { EmpListComponent } from './emp-list/emp-list.component';
import { EmpUpdateComponent } from './emp-update/emp-update.component';
import { HomeComponent } from './home/home.component';
import { InstructionsComponent } from './instructions/instructions.component';

const routes: Routes = [
  {path:'emplist',component:EmpListComponent},
  {path:'create',component:CreateEmployeeComponent},
  {path:'update/:empid',component:EmpUpdateComponent},
  {path:'home', component:HomeComponent},
  {path:'instructions',component:InstructionsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

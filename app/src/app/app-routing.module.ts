import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {RegisterComponent} from "../auth/register/register.component";
import {LoginComponent} from "../auth/login/login.component"; // CLI imports router

const routes: Routes = [
  {path: 'login' , component: LoginComponent},
  {path: 'register' ,component:  RegisterComponent}

]; // sets up routes constant where you define your routes

// configures NgModule imports and exports
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {


}

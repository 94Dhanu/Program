
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RegisterComponent } from './component/register/register.component';

import { LoginComponent } from './component/login/login.component';

import { ForgotpasswordComponent} from './component/forgotpassword/forgotpassword.component';

const routes: Routes = [
 
 { path: 'register', component:RegisterComponent },
 { path: 'login', component:LoginComponent },
 { path: 'forgotpassword', component:ForgotpasswordComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
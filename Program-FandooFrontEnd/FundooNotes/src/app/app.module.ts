import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {MatFormFieldModule} from '@angular/material/form-field';
  import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './component/register/register.component';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material';
import {MatCardModule} from '@angular/material/card';
import{FormsModule,ReactiveFormsModule} from '@angular/forms'
import {MaterialModule} from '../app/material.module';

import { HttpClientModule } from '@angular/common/http';

import { LoginComponent } from './component/login/login.component';
@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
 
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,MatFormFieldModule,MatIconModule,MatInputModule,MatCardModule,
    FormsModule,ReactiveFormsModule,MaterialModule,HttpClientModule,BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PacientsViewComponent } from './pages/pacients-view/pacients-view.component';

import {HttpClientModule} from '@angular/common/http';
import { NewPatientComponent } from './pages/new-patient/new-patient.component';
import { NewHistoryComponent } from './pages/new-history/new-history.component';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { SignupPageComponent } from './pages/signup-page/signup-page.component';
import { EditPatientComponent } from './pages/edit-patient/edit-patient.component';
import { EditHistoryComponent } from './pages/edit-history/edit-history.component';
import { MainPageComponent } from './pages/main-page/main-page.component';
import { NewHospitalComponent } from './pages/new-hospital/new-hospital.component'

@NgModule({
  declarations: [
    AppComponent,
    PacientsViewComponent,
    NewPatientComponent,
    NewHistoryComponent,
    LoginPageComponent,
    SignupPageComponent,
    EditPatientComponent,
    EditHistoryComponent,
    MainPageComponent,
    NewHospitalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

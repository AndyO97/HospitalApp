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
import { NewHospitalComponent } from './pages/new-hospital/new-hospital.component';
import { DoctorsViewComponent } from './pages/doctors-view/doctors-view.component';
import { NewDoctorComponent } from './pages/new-doctor/new-doctor.component';
import { EditDoctorComponent } from './pages/edit-doctor/edit-doctor.component';
import { AddSpecialityComponent } from './pages/add-speciality/add-speciality.component';
import { SpecialitiesViewComponent } from './pages/specialities-view/specialities-view.component';
import { NewSpecialityComponent } from './pages/new-speciality/new-speciality.component'

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
    NewHospitalComponent,
    DoctorsViewComponent,
    NewDoctorComponent,
    EditDoctorComponent,
    AddSpecialityComponent,
    SpecialitiesViewComponent,
    NewSpecialityComponent
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

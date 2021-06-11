import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PacientsViewComponent } from './pages/pacients-view/pacients-view.component';
import { NewPatientComponent } from './pages/new-patient/new-patient.component';
import { NewHospitalComponent } from './pages/new-hospital/new-hospital.component';
import { EditPatientComponent } from './pages/edit-patient/edit-patient.component';
import { EditHistoryComponent } from './pages/edit-history/edit-history.component';
import { NewHistoryComponent } from './pages/new-history/new-history.component';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { SignupPageComponent } from './pages/signup-page/signup-page.component';
import { MainPageComponent } from './pages/main-page/main-page.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' }, 
  { path: 'new-patient', component: NewPatientComponent},
  { path: 'new-hospital', component: NewHospitalComponent},
  { path: 'main', component: MainPageComponent},
  { path: 'main/:hospitalId', component: MainPageComponent},
  { path: 'edit-patient/:patientId', component: EditPatientComponent},
  { path: 'patients/:patientId/edit-history/:historyId', component: EditHistoryComponent},
  { path: 'login', component: LoginPageComponent},
  { path: 'signup', component: SignupPageComponent},
  { path: 'patients', component: PacientsViewComponent},
  { path: 'patients/:patientId', component: PacientsViewComponent},
  { path: 'patients/:patientId/new-history', component: NewHistoryComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

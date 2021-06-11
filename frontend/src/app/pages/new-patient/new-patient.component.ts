import { Component, OnInit } from '@angular/core';
import { HistoryService } from 'src/app/history.service';
import {Router} from '@angular/router'
import {AuthService} from 'src/app/auth.service'

@Component({
  selector: 'app-new-patient',
  templateUrl: './new-patient.component.html',
  styleUrls: ['./new-patient.component.scss']
})
export class NewPatientComponent implements OnInit {

  constructor(private authService: AuthService, private historyService: HistoryService, private router: Router) { }

  ngOnInit(): void {
  }

  createPatient(firstName: string, lastName: string, birthdayYear: string, birthdayMonth: string, birthdayDay: string, address: string, 
    pictureUrl: string, createdbyId: string, updatedbyId: string){
      updatedbyId = this.authService.globalUserId;
      createdbyId = this.authService.globalUserId;
    this.historyService.createPatient(firstName, lastName, parseInt(birthdayYear), parseInt(birthdayMonth), parseInt(birthdayDay), address, pictureUrl, 
    new Date, new Date, createdbyId, updatedbyId,[],[] ).subscribe((response: any) =>{
      console.log(response);
      // Now we navigate to /patients/response.id
      this.router.navigate(['/patients', response.id])  //need to return element created on db 
    });
  }

}

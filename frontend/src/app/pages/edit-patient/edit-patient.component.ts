import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { HistoryService } from 'src/app/history.service';
import {Router} from '@angular/router'
import {AuthService} from 'src/app/auth.service'

@Component({
  selector: 'app-edit-patient',
  templateUrl: './edit-patient.component.html',
  styleUrls: ['./edit-patient.component.scss']
})
export class EditPatientComponent implements OnInit {

  patientId: string;

  constructor(private authService: AuthService, private route: ActivatedRoute, private historyService: HistoryService, private router: Router) {
    this.patientId ='';
   }

  ngOnInit(): void {
    this.route.params.subscribe(
      (params: Params) => {
        console.log(params);
        this.patientId = params.patientId;
      }
    )
  }


  updatePatient(firstName: string, lastName: string, birthdayYear: string, birthdayMonth: string, birthdayDay: string, address: string, 
    pictureUrl: string, updatedbyId: string){
      updatedbyId = this.authService.globalUserId;
    this.historyService.updatePatient(this.patientId, firstName, lastName, parseInt(birthdayYear), parseInt(birthdayMonth), parseInt(birthdayDay), address, pictureUrl, 
    new Date, updatedbyId,[],[] ).subscribe((response: any) =>{
      console.log(response);
      // Now we navigate to /patients/response.id
      this.router.navigate(['/patients', this.patientId])  //need to return element created on db 
    });
  }

}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { HistoryService } from 'src/app/history.service';
import {Router} from '@angular/router'
import {AuthService} from 'src/app/auth.service'

@Component({
  selector: 'app-edit-doctor',
  templateUrl: './edit-doctor.component.html',
  styleUrls: ['./edit-doctor.component.scss']
})
export class EditDoctorComponent implements OnInit {

  doctorId: string;

  constructor(private authService: AuthService, private route: ActivatedRoute, private historyService: HistoryService, private router: Router) {
    this.doctorId ='';
   }

   ngOnInit(): void {
    this.route.params.subscribe(
      (params: Params) => {
        console.log(params);
        this.doctorId = params.doctorId;
      }
    )
  }

  updateDoctor(firstName: string, lastName: string, birthdayYear: string, birthdayMonth: string, birthdayDay: string, address: string, 
    pictureUrl: string, updatedbyId: string){
      updatedbyId = this.authService.globalUserId;
    this.historyService.updateDoctor(this.doctorId, firstName, lastName, parseInt(birthdayYear), parseInt(birthdayMonth), parseInt(birthdayDay), address, pictureUrl, 
    new Date, updatedbyId,[],[],[]).subscribe((response: any) =>{
      console.log(response);
      // Now we navigate to /patients/response.id
      this.router.navigate(['/doctors', this.doctorId])  //need to return element created on db 
    });
  }

}

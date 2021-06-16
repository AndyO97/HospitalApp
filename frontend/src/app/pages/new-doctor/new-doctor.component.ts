import { Component, OnInit } from '@angular/core';
import { HistoryService } from 'src/app/history.service';
import {Router} from '@angular/router'
import {AuthService} from 'src/app/auth.service'

@Component({
  selector: 'app-new-doctor',
  templateUrl: './new-doctor.component.html',
  styleUrls: ['./new-doctor.component.scss']
})
export class NewDoctorComponent implements OnInit {

  constructor(private authService: AuthService, private historyService: HistoryService, private router: Router) { }

  ngOnInit(): void {
  }

  createDoctor(firstName: string, lastName: string, birthdayYear: string, birthdayMonth: string, birthdayDay: string, address: string, 
    pictureUrl: string, createdbyId: string, updatedbyId: string){
      updatedbyId = this.authService.globalUserId;
      createdbyId = this.authService.globalUserId;
    this.historyService.createDoctor(firstName, lastName, parseInt(birthdayYear), parseInt(birthdayMonth), parseInt(birthdayDay), address, pictureUrl, 
    new Date, new Date, createdbyId, updatedbyId,[],[],[] ).subscribe((response: any) =>{
      console.log(response);
      // Now we navigate to /doctors/response.id
      this.router.navigate(['/doctors', response.id])  //need to return element created on db 
    });
  }
}

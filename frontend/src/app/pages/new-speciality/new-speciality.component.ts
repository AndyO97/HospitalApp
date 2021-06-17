import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { HistoryService } from 'src/app/history.service';
import {AuthService} from 'src/app/auth.service'

@Component({
  selector: 'app-new-speciality',
  templateUrl: './new-speciality.component.html',
  styleUrls: ['./new-speciality.component.scss']
})
export class NewSpecialityComponent implements OnInit {

  constructor(private authService: AuthService, private historyService: HistoryService, private route: ActivatedRoute, private router: Router ) { 
    
  }

  ngOnInit(): void {
  }

  createSpeciality(title: string, description: string, iconUrl: string, createdbyId: String, updatedbyId: String){
    updatedbyId = this.authService.globalUserId;
    createdbyId = this.authService.globalUserId;
    this.historyService.createSpeciality(title, description, iconUrl, new Date, new Date, createdbyId, updatedbyId, []).subscribe((response: any)=>{
      this.router.navigate(['/specialities', response.id])  
      console.log(response);
    })
}

}

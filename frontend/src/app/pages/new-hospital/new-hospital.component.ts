import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { HistoryService } from 'src/app/history.service';
import {AuthService} from 'src/app/auth.service'

@Component({
  selector: 'app-new-hospital',
  templateUrl: './new-hospital.component.html',
  styleUrls: ['./new-hospital.component.scss']
})
export class NewHospitalComponent implements OnInit {


  constructor(private authService: AuthService, private historyService: HistoryService, private route: ActivatedRoute, private router: Router ) { 
    
  }

  ngOnInit(): void {
  }

  createHospital(title: string, createdbyId: String, updatedbyId: String){
      updatedbyId = this.authService.globalUserId;
      createdbyId = this.authService.globalUserId;
      this.historyService.createHospital(title, new Date, new Date, createdbyId, updatedbyId, [],[]).subscribe((response: any)=>{
        this.router.navigate(['/main', response.id])  
        console.log(response);
      })
  }
}

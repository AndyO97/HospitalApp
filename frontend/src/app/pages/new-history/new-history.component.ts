import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { HistoryService } from 'src/app/history.service';
import {AuthService} from 'src/app/auth.service'

@Component({
  selector: 'app-new-history',
  templateUrl: './new-history.component.html',
  styleUrls: ['./new-history.component.scss']
})
export class NewHistoryComponent implements OnInit {

  constructor(private authService: AuthService, private historyService: HistoryService, private route: ActivatedRoute, private router: Router ) { 
    this.patientId='';
  }

  patientId: string;

  ngOnInit(){
    this.route.params.subscribe(
      (params: Params) => {
        this.patientId = params['patientId'];
      }
    )
  }

  createHistory(description: string, userDateYear: string, userDateMonth: string, userDateDay: string,
    createdbyId: String, updatedbyId: String){
      updatedbyId = this.authService.globalUserId;
      createdbyId = this.authService.globalUserId;
      this.historyService.createHistory(description, parseInt(userDateYear), parseInt(userDateMonth), 
      parseInt(userDateDay), this.patientId, new Date, new Date, createdbyId, updatedbyId).subscribe((newHistory: any)=>{
        this.router.navigate(['../'], { relativeTo: this.route });
        console.log(newHistory);
      })
  }

}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { HistoryService } from 'src/app/history.service';
import {Router} from '@angular/router'
import {AuthService} from 'src/app/auth.service'

@Component({
  selector: 'app-edit-history',
  templateUrl: './edit-history.component.html',
  styleUrls: ['./edit-history.component.scss']
})
export class EditHistoryComponent implements OnInit {

  historyId: string;
  patientId: string;

  constructor(private authService: AuthService, private route: ActivatedRoute, private historyService: HistoryService, private router: Router) {
    this.historyId ='';
    this.patientId ='';
   }

  ngOnInit(): void {
    this.route.params.subscribe(
      (params: Params) => {
        console.log(params);
        this.historyId = params.historyId;
        this.patientId = params.patientId;
      }
    )
  }

  updateHistory(description: string, userDateYear: string, userDateMonth: string, userDateDay: string,
    updatedbyId: String){
      updatedbyId = this.authService.globalUserId;
      this.historyService.updateHistory(this.historyId, description, parseInt(userDateYear), parseInt(userDateMonth), 
      parseInt(userDateDay), this.patientId, new Date, updatedbyId).subscribe((newHistory: any)=>{
        this.router.navigate(['./patients', this.patientId]);
        console.log(newHistory);
      })
  }

}

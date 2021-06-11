import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { HistoryService } from 'src/app/history.service';

@Component({
  selector: 'app-pacients-view',
  templateUrl: './pacients-view.component.html',
  styleUrls: ['./pacients-view.component.scss']
})
export class PacientsViewComponent implements OnInit {

  patients: any;
  history: any;

  selectedPatientId: string;

  constructor(private historyService: HistoryService, private route: ActivatedRoute, private router: Router) {
    this.selectedPatientId='';
   }

  ngOnInit(){
    this.route.params.subscribe(
      (params: Params) => {
        console.log(params);
          if(params.patientId){
            this.selectedPatientId = params.patientId;
            this.historyService.getHistory(params.patientId).subscribe((history: any) =>{
            this.history = history;
          })
        }
        else{
          this.history = undefined;
        }
        
      }
    )


    this.historyService.getPatients().subscribe((patients: any) => {
      console.log(patients);
      this.patients = patients;
    })
  }

  onSearchPatientsFirstNameClick(firstName: string){
    this.historyService.searchPatientsByFirstName(firstName).subscribe((patients: any) => {
      console.log(patients);
      this.patients = patients;
    })
  }

  onSearchPatientsLastNameClick(lastName: string){
    this.historyService.searchPatientsByLastName(lastName).subscribe((patients: any) => {
      console.log(patients);
      this.patients = patients;
    })
  }

  onDeletePatientClick(){
    this.historyService.deletePatient(this.selectedPatientId).subscribe((res :any)=>{
      this.router.navigate(['/patients']);
      console.log(res);
    });
  }
  onDeleteHistoryClick(id: string){
    this.historyService.deleteHistory(id).subscribe((res :any)=>{
      this.router.navigate(['/patients']);
      //this.history = this.history.filter(val => val.id !== id);
      console.log(res);
    });
  }
}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { HistoryService } from 'src/app/history.service';

@Component({
  selector: 'app-doctors-view',
  templateUrl: './doctors-view.component.html',
  styleUrls: ['./doctors-view.component.scss']
})
export class DoctorsViewComponent implements OnInit {

  doctors: any;
  specialities: any;

  selectedDoctorId: string;

  constructor(private historyService: HistoryService, private route: ActivatedRoute, private router: Router) {
    this.selectedDoctorId='';
   }

  ngOnInit(){

    this.route.params.subscribe(
      (params: Params) => {
        console.log(params);
          if(params.doctorId){
            this.selectedDoctorId = params.doctorId;
            this.historyService.getSpeciality(params.doctorId).subscribe((specialities: any) =>{
            this.specialities = specialities;
          })
        }
        else{
          this.specialities = undefined;
        }
        
      }
    )

    this.historyService.getDoctors().subscribe((doctors: any) => {
      console.log(doctors);
      this.doctors = doctors;
    })
  }

  onSearchDoctorsFirstNameClick(firstName: string){
    this.historyService.searchDoctorsByFirstName(firstName).subscribe((doctors: any) => {
      console.log(doctors);
      this.doctors = doctors;
    })
  }

  onSearchDoctorsLastNameClick(lastName: string){
    this.historyService.searchDoctorsByLastName(lastName).subscribe((doctors: any) => {
      console.log(doctors);
      this.doctors = doctors;
    })
  }

  onDeleteDoctorClick(){
    this.historyService.deleteDoctor(this.selectedDoctorId).subscribe((res :any)=>{
      this.router.navigate(['/doctors']);
      console.log(res);
    });
  }

}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { HistoryService } from 'src/app/history.service';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.scss']
})
export class MainPageComponent implements OnInit {

  hospitals: any;

  selectedHospitalId: string;

  constructor(private historyService: HistoryService, private route: ActivatedRoute, private router: Router) {
    this.selectedHospitalId='';
   }

  ngOnInit(){
    this.route.params.subscribe(
      (params: Params) => {
        console.log(params);
          if(params.HospitalId){
            this.selectedHospitalId = params.HospitalId;
        }
      }
    )
    
    this.historyService.getHospitals().subscribe((hospitals: any) => {
      console.log(hospitals);
      this.hospitals = hospitals;
    })
  }

  alerta(mensaje: string){
    alert(mensaje);
  }

  onSearchHospitalsNameClick(title: string){
    this.historyService.searchHospitalsByTitle(title).subscribe((hospitals: any) => {
      console.log(hospitals);
      this.hospitals = hospitals;
    })
  }

  onDeleteHospitalClick(id: string){
    this.historyService.deleteHospital(id).subscribe((res :any)=>{
      this.router.navigate(['/main']);
      //this.history = this.history.filter(val => val.id !== id);
      console.log(res);
    });
  }

}

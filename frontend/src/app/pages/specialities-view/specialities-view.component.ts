import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { HistoryService } from 'src/app/history.service';

@Component({
  selector: 'app-specialities-view',
  templateUrl: './specialities-view.component.html',
  styleUrls: ['./specialities-view.component.scss']
})
export class SpecialitiesViewComponent implements OnInit {

  specialities: any;

  selectedSpecialityId: string;

  constructor(private historyService: HistoryService, private route: ActivatedRoute, private router: Router) {
    this.selectedSpecialityId='';
   }

  ngOnInit(){
    this.route.params.subscribe(
      (params: Params) => {
        console.log(params);
          if(params.specialityId){
            this.selectedSpecialityId = params.specialityId;
        }
      }
    )

    this.historyService.getSpecialities().subscribe((specialities: any) => {
      console.log(specialities);
      this.specialities = specialities;
    })
  }

  onSearchSpecialitiesNameClick(title: string){
    this.historyService.searchSpecialitiesByTitle(title).subscribe((specialities: any) => {
      console.log(specialities);
      this.specialities = specialities;
    })
  }

}

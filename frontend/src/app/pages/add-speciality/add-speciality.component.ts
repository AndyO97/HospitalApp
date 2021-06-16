import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { HistoryService } from 'src/app/history.service';
import {AuthService} from 'src/app/auth.service'

@Component({
  selector: 'app-add-speciality',
  templateUrl: './add-speciality.component.html',
  styleUrls: ['./add-speciality.component.scss']
})
export class AddSpecialityComponent implements OnInit {

  doctorId: string;

  constructor(private authService: AuthService, private historyService: HistoryService, private route: ActivatedRoute, private router: Router ) { 
    this.doctorId='';
  }

  ngOnInit(){
    this.route.params.subscribe(
      (params: Params) => {
        this.doctorId = params['doctorId'];
      }
    )
  }

  addSpeciality(title: string){
      this.historyService.addSpeciality(title, this.doctorId).subscribe((res: any)=>{
        this.router.navigate(['../'], { relativeTo: this.route });
        console.log(res);
      })
  }

}

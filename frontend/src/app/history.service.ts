import { Injectable } from '@angular/core';
import { WebRequestService } from './web-request.service';
//import { History } from './../app/models/history.model';

@Injectable({
  providedIn: 'root'
})
export class HistoryService {

  constructor(private webReqService: WebRequestService) { }

  

  getPatients(){
    return this.webReqService.get('patients');
  }

  getHospitals(){
    return this.webReqService.get('hospitals');
  }

  searchPatientsByFirstName(firstName: string){
    return this.webReqService.get(`patients/getByFirstName/${firstName}`);
  }

  searchPatientsByLastName(lastName: string){
    return this.webReqService.get(`patients/getByLastName/${lastName}`);
  }

  createPatient(firstName: string, lastName: string, birthdayYear: number, birthdayMonth: number, birthdayDay: number, address: string, pictureUrl: string,
    creationDate: Date, lastUpdate: Date,createdbyId: string, updatedbyId: string, hospitalId: string[], doctorId: string[]) {
      var birthday = new Date(birthdayYear, birthdayMonth-1, birthdayDay, 0,0,0)
    // We want to send a web request to create a patient
    return this.webReqService.post('patients', { firstName, lastName, birthday, address, pictureUrl, 
      creationDate, lastUpdate,createdbyId, updatedbyId, hospitalId, doctorId }); 
  }

  updatePatient(id: string, firstName: string, lastName: string, birthdayYear: number, birthdayMonth: number, birthdayDay: number, address: string, pictureUrl: string,
    lastUpdate: Date, updatedbyId: string, hospitalId: string[], doctorId: string[]) {
      var birthday = new Date(birthdayYear, birthdayMonth-1, birthdayDay, 0,0,0)
    // We want to send a web request to update a patient
    return this.webReqService.patch('patients', { id, firstName, lastName, birthday, address, pictureUrl, 
      lastUpdate, updatedbyId, hospitalId, doctorId }); 
  }

  deletePatient(id: string){
    return this.webReqService.delete(`patients/${id}`);
  }

  getHistory(patientId: string){
    return this.webReqService.get(`history/getByPatientId/${patientId}`);
  }

  createHistory(description: string, userDateYear: number, userDateMonth: number, userDateDay: number,
    patientId: string, creationDate: Date, lastUpdate: Date, createdbyId: String, updatedbyId: String){
      var userDate = new Date(userDateYear, userDateMonth-1, userDateDay, 0,0,0)
    // We want to send a web request to create a history note
    return this.webReqService.post('history', { description, userDate, patientId, 
      creationDate, lastUpdate,createdbyId, updatedbyId}); 
  }

  updateHistory(id: string, description: string, userDateYear: number, userDateMonth: number, userDateDay: number,
    patientId: string, lastUpdate: Date, updatedbyId: String){
      var userDate = new Date(userDateYear, userDateMonth-1, userDateDay, 0,0,0)
    // We want to send a web request to create a history note
    return this.webReqService.patch('history', { id, description, userDate, patientId, 
      lastUpdate, updatedbyId}); 
  }

  deleteHistory(id: string){
    return this.webReqService.delete(`history/${id}`);
  }

  createHospital(title: string, creationDate: Date, lastUpdate: Date, createdbyId: String, updatedbyId: String, patientId: string[], doctorId: string[]){
    // We want to send a web request to create a hospital
    return this.webReqService.post('hospitals', { title,
      creationDate, lastUpdate,createdbyId, updatedbyId, patientId, doctorId}); 
  }

  searchHospitalsByTitle(title: string){
    return this.webReqService.get(`hospitals/getByTitle/${title}`);
  }

  deleteHospital(id: string){
    return this.webReqService.delete(`hospitals/${id}`);
  }

}

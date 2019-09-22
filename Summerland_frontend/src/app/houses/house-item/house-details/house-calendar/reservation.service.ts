
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {HttpHeaders} from "@angular/common/http";
import {Subject} from "rxjs";
@Injectable()
export class ReservationService{

  public confirmed_Reservations=new Subject();
  public reservations_Requests=new Subject();

  constructor(private httpClient:HttpClient){}

  createReservation(reservation){

    const headers = new HttpHeaders()
      .set('Authorization', 'my-auth-token')
      .set('Content-Type', 'application/json');
    return this.httpClient.post('http://localhost:8080/saveReservation',reservation,{headers: headers});
  }

  getHouseConfirmedReservations(id){
    return this.httpClient.get(`http://localhost:8080/getConfirmedReservations/${id}`);
  }

  getHouseReservationsRequests(id){
    return this.httpClient.get(`http://localhost:8080/getReservationsRequests/${id}`);
  }

  acceptReservation(id){
    return this.httpClient.get(`http://localhost:8080/acceptReservation/${id}`);
  }

  refuseReservation(id){
    return this.httpClient.get(`http://localhost:8080/refuseReservation/${id}`);
  }

  getCustomerReservation(id){
    return this.httpClient.get(`http://localhost:8080/customerReservation/${id}`);
  }
}

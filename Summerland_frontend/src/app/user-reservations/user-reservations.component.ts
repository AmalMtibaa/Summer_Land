import { Component, OnInit } from '@angular/core';
import {ReservationService} from "../houses/house-item/house-details/house-calendar/reservation.service";
import {Reservation} from "../houses/house-item/house-details/house-calendar/reservation";

@Component({
  selector: 'app-user-reservations',
  templateUrl: './user-reservations.component.html',
  styleUrls: ['./user-reservations.component.css']
})
export class UserReservationsComponent implements OnInit {

  constructor(private reservationService:ReservationService) { }
  reservations=[];
  ngOnInit() {
    let customer_id=sessionStorage.getItem('user_id');
    this.reservationService.getCustomerReservation(customer_id).subscribe(
      data=>{
        this.reservations=<Reservation[]>data;
      }
    )
  }

}

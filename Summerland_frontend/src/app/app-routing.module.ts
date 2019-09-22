import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {HousesComponent} from "./houses/houses.component";
import {HouseDetailsComponent} from "./houses/house-item/house-details/house-details.component";
import {UserPropretiesComponent} from "./user-propreties/user-propreties.component";
import {HouseCalendarComponent} from "./houses/house-item/house-details/house-calendar/house-calendar.component";
import {UpdatePropretyComponent} from "./user-propreties/update-proprety/update-proprety.component";
import {ContactComponent} from "./contact/contact.component";
import {UserProfileComponent} from "./user-profile/user-profile.component";
import {UserReservationsComponent} from "./user-reservations/user-reservations.component";

const routes: Routes = [
  {path:"",component:HomeComponent },
  {path:"houses",component:HousesComponent },
  {path:"house-detail/:id",component:HouseDetailsComponent },
  {path:"user-properties/:id",component:UserPropretiesComponent },
  {path:"house-calendar/:id",component:HouseCalendarComponent },
  {path:"update-property/:id",component:UpdatePropretyComponent },
  {path:"contact",component:ContactComponent },
  {path:"profile",component:UserProfileComponent },
  {path:"user-reservations",component:UserReservationsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

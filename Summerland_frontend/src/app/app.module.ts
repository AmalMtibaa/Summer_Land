import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HousesComponent } from './houses/houses.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HouseItemComponent } from './houses/house-item/house-item.component';
import { HouseDetailsComponent } from './houses/house-item/house-details/house-details.component';
import { FamousHousesComponent } from './home/famous-houses/famous-houses.component';
import { FamousHouseItemComponent } from './home/famous-houses/famous-house-item/famous-house-item.component';
import {FormsModule, ReactiveFormsModule, NG_VALUE_ACCESSOR} from "@angular/forms";
import {IgxSliderModule, IgxInputGroupModule} from "igniteui-angular";
import {SharedService} from "./shared-services/shared.service";
import { UserPropretiesComponent } from './user-propreties/user-propreties.component';
import { AddPropretyFormComponent } from './user-propreties/add-proprety-form/add-proprety-form.component';
import { UserPropertiesItemComponent } from './user-propreties/user-properties-item/user-properties-item.component';
import { HouseCalendarComponent } from './houses/house-item/house-details/house-calendar/house-calendar.component';
import {CommonModule} from "@angular/common";


//For Calendar
import { NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import {FlatpickrModule} from "angularx-flatpickr";
import { CalendarModule, DateAdapter } from 'angular-calendar';
import {adapterFactory} from "angular-calendar/date-adapters/date-fns";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {HttpClientModule} from "@angular/common/http";
import {HousesService} from "./houses/houses.service";
import {UserPropertiesService} from "./user-propreties/user-propreties.service";
import {ReservationService} from "./houses/house-item/house-details/house-calendar/reservation.service";
import {AuthentificationServcie} from "./shared-services/authentification.service";
import { UpdatePropretyComponent } from './user-propreties/update-proprety/update-proprety.component';
import { UserReservationsComponent } from './user-reservations/user-reservations.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { ContactComponent } from './contact/contact.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HousesComponent,
    HeaderComponent,
    FooterComponent,
    HouseItemComponent,
    HouseDetailsComponent,
    FamousHousesComponent,
    FamousHouseItemComponent,
    UserPropretiesComponent,
    AddPropretyFormComponent,
    UserPropertiesItemComponent,
    HouseCalendarComponent,
    UpdatePropretyComponent,
    UserReservationsComponent,
    UserProfileComponent,
    ContactComponent,
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    IgxSliderModule,
    IgxInputGroupModule,
    HttpClientModule,

    //For Calendar
    NgbModalModule,
    FlatpickrModule.forRoot(),
    CalendarModule.forRoot({
      provide: DateAdapter,
      useFactory: adapterFactory
    }),
    BrowserAnimationsModule,

  ],
  providers: [
    SharedService,
    HousesService,
    UserPropertiesService,
    ReservationService,



    //For uploading Photo
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: AddPropretyFormComponent,
      multi: true
    }

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

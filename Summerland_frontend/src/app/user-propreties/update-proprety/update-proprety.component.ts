import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Params} from "@angular/router";
import {House, Place} from "../../houses/house-item/house";
import {HousesService} from "../../houses/houses.service";
import {FormGroup, FormControl, FormArray} from "@angular/forms";

@Component({
  selector: 'app-update-proprety',
  templateUrl: './update-proprety.component.html',
  styleUrls: ['./update-proprety.component.css']
})
export class UpdatePropretyComponent implements OnInit {

  constructor(private route:ActivatedRoute,private housesService:HousesService) { }
  house:House=new House();
  cities;
  categories=["Apartment","House","Guest House","Villa"];
  updatePropertyForm=new FormGroup({
    "header_name": new FormControl(""),
    "address": new FormControl(""),
    "description": new FormControl(""),
    "surface": new FormControl(0),
    "rooms_number": new FormControl(0),
    "garage_number": new FormControl(0),
    "bathrooms_number": new FormControl(0),
    "typeOfPaiement": new FormControl("Week"),
    //"city": new FormControl(""),
    "type": new FormControl(""),
    "price": new FormControl(0),
    "age": new FormControl(0),
    "pathimage": new FormControl(),

    "photos":new FormArray([]),
  });
  ngOnInit() {

    this.route.params.subscribe(
      (params: Params) => {
        this.housesService.getHouseById(params['id']).subscribe(
          data=>{
            console.log(data);
            let p=data['place']['name'];
            this.house=<House>data;

            this.updatePropertyForm.patchValue(
              {
              "header_name": this.house.header_name,
              "address":this.house.address,
              "description":this.house.description,
              "surface": this.house.surface,
              "rooms_number": this.house.rooms_number,
              "garage_number": this.house.garage_number,
              "bathrooms_number": this.house.bathrooms_number,
              "typeOfPaiement": this.house.typeOfPaiement,
              //"city": new FormControl(p),
              "type":this.house.type,
              "price": this.house.price,
              "age": this.house.age,
              "pathimage": this.house.pathimage,

              //"pathimages":new FormArray(this.),
            });
          });


      });

    this.housesService.getPlaces().subscribe(
      data=>{
        this.cities=<Place[]>data;
      }
    );




  }

}

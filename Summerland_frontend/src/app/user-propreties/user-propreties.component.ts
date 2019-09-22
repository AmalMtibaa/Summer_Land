import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Params} from "@angular/router";
import {UserPropertiesService} from "./user-propreties.service";
import {HousesService} from "../houses/houses.service";
import {House} from "../houses/house-item/house";

@Component({
  selector: 'app-user-propreties',
  templateUrl: './user-propreties.component.html',
  styleUrls: ['./user-propreties.component.css']
})
export class UserPropretiesComponent implements OnInit {

  constructor(private route:ActivatedRoute,
              private housesService:HousesService) { }

  properties=[];
  ngOnInit() {
    this.route.params.subscribe(
      (params: Params) => {
        console.log(params['id']);
        this.housesService.getHousesByOwner(params['id']).subscribe(
          data=>{
            this.properties=<House[]>data;
          }
        )}
    );
    this.housesService.userProperties.subscribe(
      data=>{
        this.properties=<House[]>data;
      }
    )
  }


}

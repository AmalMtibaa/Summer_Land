import { Component, OnInit } from '@angular/core';
import {House} from "../../houses/house-item/house";
import {HousesService} from "../../houses/houses.service";

@Component({
  selector: 'app-famous-houses',
  templateUrl: './famous-houses.component.html',
  styleUrls: ['./famous-houses.component.css']
})
export class FamousHousesComponent implements OnInit {

  constructor(private housesService:HousesService) { }

  top_4_famous_Houses:House[]=[];
  ngOnInit() {
    this.housesService.getHouses().subscribe(
      data=>{
        let x=<House[]>data;
        for(let i=0;i<4;i++){
          this.top_4_famous_Houses.push(x[i]);
        }
        console.log(this.top_4_famous_Houses);
      })
  }

}

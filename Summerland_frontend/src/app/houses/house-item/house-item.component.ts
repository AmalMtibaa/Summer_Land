import {Component, OnInit, Input} from '@angular/core';
import {Router, ActivatedRoute} from "@angular/router";
import {FormGroup, FormControl} from "@angular/forms";
import {House} from "./house";
import {HousesService} from "../houses.service";

@Component({
  selector: 'app-house-item',
  templateUrl: 'house-item.component.html',
  styleUrls: ['house-item.component.css']
})
export class HouseItemComponent implements OnInit {

  constructor(private router:Router,private housesService:HousesService) { }


  @Input() house:House;
  ngOnInit() {}

  onClickHouse(id:number){
    this.router.navigate(['/house-detail',id]);
  }




}

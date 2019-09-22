import {Component, OnInit, Input} from '@angular/core';
import {HousesService} from "../../../houses/houses.service";
import {House} from "../../../houses/house-item/house";
import {Router} from "@angular/router";

@Component({
  selector: 'app-famous-house-item',
  templateUrl: './famous-house-item.component.html',
  styleUrls: ['./famous-house-item.component.css']
})
export class FamousHouseItemComponent implements OnInit {

  constructor(private router:Router) { }

  @Input()house:House;
  ngOnInit(){}

  onClickHouse(){
    this.router.navigate(['/house-detail',this.house.id])
  }
}

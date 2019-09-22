import {Component, OnInit, Input} from '@angular/core';
import {Router} from "@angular/router";
import {House} from "../../houses/house-item/house";

@Component({
  selector: 'app-user-properties-item',
  templateUrl: './user-properties-item.component.html',
  styleUrls: ['./user-properties-item.component.css']
})
export class UserPropertiesItemComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit() {
  }

  @Input() house:House;


  onReservation(){
    this.router.navigate(['/house-calendar',this.house.id])
  }

  onUpdate(){
    this.router.navigate(['/update-property',this.house.id])
  }
}

import {Component, OnInit, ViewChild, ElementRef, AfterViewInit} from '@angular/core';
import * as $ from 'jquery'
import {HousesService} from "../../houses.service";
import {House, Owner} from "../house";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {UserPropretiesComponent} from "../../../user-propreties/user-propreties.component";
import {UserPropertiesService} from "../../../user-propreties/user-propreties.service";
import {AuthentificationServcie} from "../../../shared-services/authentification.service";
@Component({
  selector: 'app-house-details',
  templateUrl: './house-details.component.html',
  styleUrls: ['./house-details.component.css']
})
export class HouseDetailsComponent implements OnInit , AfterViewInit{

  constructor(private housesService:HousesService,
              private route: ActivatedRoute,
              private router:Router,
              private authentificationService:AuthentificationServcie) { }

  house=new House();
  owner=new Owner();
  loged=false;
  ngOnInit() {
    this.authentificationService.isUserLoggedIn();
    this.authentificationService.logedEmitter.subscribe(
      data=>{
        this.loged=data;
        console.log("loged",this.loged);
      }
    );
    this.route.params.subscribe(
      (params: Params) => {
        this.housesService.getHouseById(params['id']).subscribe(
          data=>{
            console.log(data);
            this.house=<House>data;
          });
      });
  }

  ngAfterViewInit() {
    // loading templates js after dom render
    $.getScript("../../../../assets/js/main.js", function () {
    });

  }

  onClickCalandar(){
    this.router.navigate(['/house-calendar',this.house.id])
  }
}

import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {FormGroup, FormControl} from "@angular/forms";
import { SliderType } from "igniteui-angular";
import * as $ from 'jquery'
import {SharedService} from "../shared-services/shared.service";
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public sliderType = SliderType;
  public priceRange: PriceRange = new PriceRange(200, 800);
  public sizeRange: SizeRange=new SizeRange(50,500);

  constructor(private router:Router,private sharedService:SharedService) { }
  searchForm:FormGroup;


  ngOnInit() {
    this.searchForm=new FormGroup({
      //"keywords": new FormControl(),
      "city": new FormControl(this.cities[0]),
      "catagory": new FormControl(this.categories[0]),
     // "offer": new FormControl(this.offers[0]),
      "numb_bedrooms": new FormControl(this.bedrooms[0]),
      "numb_bathrooms": new FormControl(this.bathrooms[0]),
    });

  }


  onClickSearch(){
    let form=this.searchForm.value;
    form["price_min"]=this.priceRange.lower;
    form["price_max"]=this.priceRange.upper;
    form["size_min"]=this.sizeRange.lower;
    form["size_max"]=this.sizeRange.upper;
    console.log(form);


    this.sharedService.subject.next(form);
    this.sharedService.sendForm(form);
    this.router.navigate(['/houses']);

  }

  // -----Maybe Think to regroupe it in a General dataService------
    cities=["All Cities","Hammemet","Sousse","Tunis","Nabeul","Zaghouan","Binzerte","Mahdia","Monastrir","Sfax"];
    categories=["All Categories","Apartment","House","Guest House","Villa"];
    offers=["All Offers","100%","75%","50%","25%","10%"];
    bedrooms=["All bedrooms","1","2","3","4","5+"];
    bathrooms=["All bathrooms","1","2","3","4","5+"];
    team=[
      {"name":"Amal Mtibaa","email":"mtibaa.amall@gmail.com","image":"amal.jpg", "position":"Front end Developer and Designer","number":93750292},
      {"name":"Yasmine Mhiri","email":"yasmine.mhiri@gmail.com","image":"yassmine.jpg", "position":"Back end Developer and Designer","number":93750292},
      {"name":"Med Wassim Riahi","email":"wassim.riahi@gmail.com","image":"wassim.jpg","position":"CPC Expert","number":93750292}
    ];
  reviews=Array(3);



}

class PriceRange {
  constructor(
    public lower: number,
    public upper: number,
  ) {
  }
}

class SizeRange {
  constructor(
    public lower: number,
    public upper: number,
  ) {
  }
}

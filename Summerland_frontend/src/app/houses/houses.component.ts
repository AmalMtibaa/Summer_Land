import {Component, OnInit, Input, ViewChild, ElementRef} from '@angular/core';
import {FormGroup, FormControl} from "@angular/forms";
import {SliderType} from "igniteui-angular";
import {SharedService} from "../shared-services/shared.service";
import {isUndefined} from "util";
import {HousesService} from "./houses.service";
import {House} from "./house-item/house";

@Component({
  selector: 'app-houses',
  templateUrl: './houses.component.html',
  styleUrls: ['./sliderStyle.scss']
})
export class HousesComponent implements OnInit {

  public sliderType = SliderType;
  public priceRange: PriceRange = new PriceRange(200, 800);
  public sizeRange: SizeRange=new SizeRange(50,500);

  constructor(private sharedService:SharedService,
              private housesService:HousesService ) { }

  searchForm:FormGroup;


  cities=["All Cities","Hammemet","Sousse","Tunis","Nabeul","Zaghouan","Binzerte","Mahdia","Monastrir","Sfax"];
  categories=["All Categories","Apartment","House","Guest House","Villa"];
  offers=["All Offers","100%","75%","50%","25%","10%"];
  bedrooms=["All bedrooms","1","2","3","4","5+"];
  bathrooms=["All bathrooms","1","2","3","4","5+"];

  houses=[];

  @ViewChild('city') someInput: ElementRef;

  ngOnInit() {

    this.housesService.getHouses().subscribe(
      data=>{
        this.houses=<House[]>data;
        console.log(this.houses);
      }
    );

    this.sharedService.subject.subscribe(
      data=>{
        console.log("   ---- ",data);
        let form=data;

        // this.housesService.filterHouses(form).subscribe(
        //   data=>{
        //     console.log(data);
        //   }
        // );

        this.searchForm.setValue({
          keywords:this.someInput.toString(),
          citie:form["citie"] ,
          categorie:form["categorie"],
          offer:form["offer"],
          bedrooms:form["bedrooms"],
          bathrooms:form["bathrooms"],
        });
        this.priceRange.lower=form["minPrice"];
        this.priceRange.upper=form["maxPrice"];
        this.sizeRange.lower=form["minSize"];
        this.sizeRange.upper=form["maxSize"];

      }
    );

    //let form=this.sharedService.getForm();
    //console.log(form);
    this.searchForm=new FormGroup({
      "keywords": new FormControl(),
      "citie": new FormControl(this.cities[0]),
      "categorie": new FormControl(this.categories[0]),
      "offer": new FormControl(this.offers[0]),
      "bedrooms": new FormControl(this.bedrooms[0]),
      "bathrooms": new FormControl(this.bathrooms[0]),
    });


  }
  array=Array(8);



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
  ) {}
  }

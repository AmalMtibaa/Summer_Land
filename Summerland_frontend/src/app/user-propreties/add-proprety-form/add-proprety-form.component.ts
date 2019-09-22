import {Component, OnInit, ChangeDetectorRef, HostListener, ElementRef, ViewChild} from '@angular/core';
import {FormGroup, FormControl, FormArray, ControlValueAccessor} from "@angular/forms";
import {HousesService} from "../../houses/houses.service";
import {House, Place} from "../../houses/house-item/house";

@Component({
  selector: 'app-add-proprety-form',
  templateUrl: 'add-proprety-form.component.html',
  styleUrls: ['add-proprety-form.component.css']
})
export class AddPropretyFormComponent implements OnInit, ControlValueAccessor  {
  addPropertyForm:FormGroup;
  constructor(private houseService:HousesService,
              private host: ElementRef ,
  ) { }

  cities=[];
  categories=["Apartment","House","Guest House","Villa"];
  proprety_details=["Sea view", " Air conditioning", "Central Heating","Internet","Laundry Room"];


  private file:File;
  private files:File[]=[];

  ngOnInit() {
    this.houseService.getPlaces().subscribe(
      data=>{
        this.cities=<Place[]>data;
      }
    );

    this.addPropertyForm = new FormGroup({
      "header_name": new FormControl(),
      "address": new FormControl(),
      "description": new FormControl(),
      "surface": new FormControl(0),
      "rooms_number": new FormControl(0),
      "garage_number": new FormControl(0),
      "bathrooms_number": new FormControl(0),
      "typeOfPaiement": new FormControl("Week"),
      "city": new FormControl("Hammemet"),
      "type": new FormControl(this.categories[0]),
      "price": new FormControl(0),
      "age": new FormControl(0),
      "im": new FormControl(),

      "photos":new FormArray([]),
    });
  }

  onAddPhoto() {
    (<FormArray>this.addPropertyForm.get('photos')).push(
      new FormGroup(
        {
          'photo': new FormControl(),
        })
    );
  }

  checkedList=[];
  onCheckboxChange(option, event) {

    if (event.target.checked) {
      this.checkedList.push(option);
    } else {
      for (var i = 0; i < this.proprety_details.length; i++) {
        if (this.checkedList[i] == option) {
          this.checkedList.splice(i, 1);
        }
      }
    }
    console.log(this.checkedList);
  }

  onDeletePhoto(i:number){
    (<FormArray>this.addPropertyForm.get('photos')).removeAt(i);
    this.files.splice(i, 1);
    console.log(this.files);
  }

  onClickCreate(){
    let selectedCity=this.addPropertyForm.controls['city'].value;
    let selectedPlaceId;
    let notFound=true;
    let i=0;
    while (notFound){
      if (this.cities[i].name==selectedCity){
        selectedPlaceId=this.cities[i].id;
        notFound=false;
      }
      i++;
    }
    let pathImages=[];
    let tab=this.addPropertyForm.controls['photos'].value;
    for(let el of tab){
      let x = el["photo"].substring( el["photo"].lastIndexOf("\\") + 1,  el["photo"].length);
      pathImages.push(x);
    }

    let h=this.addPropertyForm.value;
    // if(this.file){ --------------------------------SAVING Photo
    //   h["image"]=this.file;
    // }
    h["pathimage"]=h["im"].substring( h["im"].lastIndexOf("\\") + 1,  h["im"].length);
    h["place"]=selectedPlaceId;
    h["owner"]=sessionStorage.getItem('user_id');
    h["details"]=this.checkedList;
    if(pathImages!=[]){
      h["pathimages"]=pathImages;
    }


    //----Couldn't send an array Of Files-----

    // if(this.files!=[]){
    //   h["images"]=this.files;
    //   console.log(h["images"]);
    // }
    console.log(h);

    let formdata: FormData = new FormData();
    for ( let  key in h ) {
      formdata.append(key, h[key]);
    }

    this.houseService.saveHouse(formdata).subscribe(
      data=>{
        console.log(data);
        this.houseService.userProperties.next(<House[]>data);
      }
    );

  }
  private x=true;

  @HostListener('change', ['$event.target.files']) emitFiles( event: FileList ) {
    let file = event && event.item(0);
    if(this.x){
      this.file = file;
      //this.files.push(file);
    }
    this.x=false;
  }


  writeValue( value: null ) {
    // clear file input
    this.host.nativeElement.value = '';
    this.file = null;
  }

  registerOnChange( fn: Function ) {
    this.onChange = fn;
  }
  onChange: Function;
  registerOnTouched( fn: Function ) {
  }


}

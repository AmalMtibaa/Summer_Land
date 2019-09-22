import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {HttpHeaders} from "@angular/common/http";
import {Subject} from "rxjs";
import {House} from "./house-item/house";

@Injectable()
export class HousesService{

  constructor(private httpClient:HttpClient){}
  private headers = new HttpHeaders({ 'Content-Type': 'application/json','Authorization': 'my-auth-token' });
  public subjectHouse: Subject<House>=new Subject<House>();

  public userProperties:Subject<House[]>=new Subject<House[]>();

  public filterHouses(filter){
    return this.httpClient.post(`http://localhost:8080/filter`,filter);
  }

  public getHouses(){
    return this.httpClient.get('http://localhost:8080/gethouses');
  }

  public saveHouse(formdata){
    return this.httpClient.post(`http://localhost:8080/savehouse`,formdata);
  }

 public getPlaces(){
    return this.httpClient.get('http://localhost:8080/getPlaces');
 }

 public getHouseById(id:number){
   return this.httpClient.get(`http://localhost:8080/getHouseById/${id}`);
 }

 public getHousesByOwner(id:number){
   return this.httpClient.get(`http://localhost:8080/getHousesByIdOwner/${id}`);
 }



}

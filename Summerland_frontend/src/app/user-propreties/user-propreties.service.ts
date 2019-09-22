import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
@Injectable()
export class UserPropertiesService{

  constructor(private httpClient:HttpClient){}

  public getOwnerById(id){
    return this.httpClient.get(`http://localhost:8080/getOwnerById/${id}`);
  }

}

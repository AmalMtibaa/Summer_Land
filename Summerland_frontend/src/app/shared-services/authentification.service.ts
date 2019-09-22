import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {HttpHeaders} from "@angular/common/http";
import {Response} from "selenium-webdriver/http";
import {Subject} from "rxjs";
/**
 * Created by asus on 28/04/2019.
 */

@Injectable({
  providedIn: 'root'
})
export class AuthentificationServcie{

  constructor(private httpClient:HttpClient){}


  public logedEmitter=new Subject<boolean>();

  authenticate(user) {
    const headers = new HttpHeaders()
      .set('Authorization', 'my-auth-token')
      .set('Content-Type', 'application/json');

    this.httpClient.post('http://localhost:8080/login',user,{headers: headers}).subscribe(
      data=>{
        console.log(data);
        if(data['auth']!='No'){
          sessionStorage.setItem('role',data['role']);
          sessionStorage.setItem('user_name',data['user_name']);
          sessionStorage.setItem('user_last_name',data['user_last_name']);
          sessionStorage.setItem('user_id',data['user_id']);
          this.logedEmitter.next(true);
        }
        this.logedEmitter.next(false);
      });
  }

   isUserLoggedIn() {
    console.log("session Storage",sessionStorage);
    let user = sessionStorage.getItem('user_name');
    return !(user === null);
  }

     logOut() {
    sessionStorage.removeItem('user_name');
    sessionStorage.removeItem('user_last_name');
    sessionStorage.removeItem('role');
    sessionStorage.removeItem('user_id');
  }
}

import {Component, OnInit, EventEmitter, Output} from '@angular/core';
import {FormGroup, FormControl} from "@angular/forms";
import {AuthentificationServcie} from "../shared-services/authentification.service";
import {Router} from "@angular/router";
declare var $: any;
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private authentificationService:AuthentificationServcie,
              private router:Router) { }

  loginForm:FormGroup;
  loged=false;

  user_name="";
  user_role="";
  user_id="";

  ngOnInit() {
    this.user_name=sessionStorage.getItem('user_name');
    this.user_role=sessionStorage.getItem('role');
    this.user_id=sessionStorage.getItem('user_id');

    this.loged=this.authentificationService.isUserLoggedIn();
    console.log(this.loged);
    this.loginForm=new FormGroup({
      'email':new FormControl(),
      'password':new FormControl()
    });

    this.authentificationService.logedEmitter.subscribe(
      data=>{
        this.loged=data;
        this.user_role=sessionStorage.getItem('user_role');
      }
    )
  }



  clicked=false;
  onLogin(){
    let r=this.loginForm.value;
    this.authentificationService.authenticate(r);
    this.authentificationService.isUserLoggedIn();
    this.authentificationService.logedEmitter.subscribe(
      data=>{
        this.loged=data;
        if(this.loged==true){
          this.clicked=false;
          location.reload();
        }
        else {
          this.clicked=true;
        }
      })
  }

  onLogout(){
    this.authentificationService.logOut();
  }

  onMyProperties(){
    let id=this.user_id;
    console.log(id);
    this.router.navigate(['/user-properties',id]);
  }
}

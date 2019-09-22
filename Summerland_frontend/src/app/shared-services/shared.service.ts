import {EventEmitter, Injectable} from "@angular/core";
import {Subject} from "rxjs";
@Injectable()
export class SharedService{
  private form;
 // public formEmiter=new EventEmitter();

  public subject: Subject<Object>=new Subject<Object>();

  public sendForm(form){
    this.form=form;
  }

  public getForm(){
    return this.form
  }


}

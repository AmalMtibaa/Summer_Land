export class Reservation{
  private _id:string;
  private _confirmation:string;
  private _date_debut:Date;
  private _date_fin:Date;
  private _customer;
  private _house;


  get customer() {
    return this._customer;
  }

  set customer(value) {
    this._customer = value;
  }

  get house() {
    return this._house;
  }

  set house(value) {
    this._house = value;
  }

  get id(): string {
    return this._id;
  }

  set id(value: string) {
    this._id = value;
  }

  get confirmation(): string {
    return this._confirmation;
  }

  set confirmation(value: string) {
    this._confirmation = value;
  }

  get date_debut(): Date {
    return this._date_debut;
  }

  set date_debut(value: Date) {
    this._date_debut = value;
  }

  get date_fin(): Date {
    return this._date_fin;
  }

  set date_fin(value: Date) {
    this._date_fin = value;
  }
}

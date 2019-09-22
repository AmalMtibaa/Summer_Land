export class House{

  private _id:number;
  private _address:string;
  private _description:string;
  private _surface:number;
  private _seaview:boolean;
  private _age:number;
  private _price:number;
  private _rooms_number:number;
  private _place:number;
  private _garage_number:number;
  private _bathrooms_number:number;
  private _type:string;
  private _typeOfPaiement:string;
  private _header_name:String;
  private _details:String[];
  private _image:File;
  private _pathimage:String;
  private _owner:number;
  private _pathimages;
  private _images:File[];


  get pathimages() {
    return this._pathimages;
  }

  set pathimages(value) {
    this._pathimages = value;
  }

  get images(): File[] {
    return this._images;
  }

  set images(value: File[]) {
    this._images = value;
  }

  get header_name(): String {
    return this._header_name;
  }


  get image(): File {
    return this._image;
  }

  set image(value: File) {
    this._image = value;
  }





  get pathimage(): String {
    return this._pathimage;
  }

  set pathimage(value: String) {
    this._pathimage = value;
  }

  get details(): String[] {
    return this._details;
  }

  set details(value: String[]) {
    this._details = value;
  }

  set header_name(value: String) {
    this._header_name = value;
  }

  get garage_number(): number {
    return this._garage_number;
  }

  set garage_number(value: number) {
    this._garage_number = value;
  }

  get bathrooms_number(): number {
    return this._bathrooms_number;
  }

  set bathrooms_number(value: number) {
    this._bathrooms_number = value;
  }

  get type(): string {
    return this._type;
  }

  set type(value: string) {
    this._type = value;
  }

  get typeOfPaiement(): string {
    return this._typeOfPaiement;
  }

  set typeOfPaiement(value: string) {
    this._typeOfPaiement = value;
  }

  set address(value: string) {
    this._address = value;
  }

  set description(value: string) {
    this._description = value;
  }

  set surface(value: number) {
    this._surface = value;
  }

  set seaview(value: boolean) {
    this._seaview = value;
  }

  set age(value: number) {
    this._age = value;
  }

  set price(value: number) {
    this._price = value;
  }

  set rooms_number(value: number) {
    this._rooms_number = value;
  }

  set place(value: number) {
    this._place = value;
  }


  get id(): number {
    return this._id;
  }

  get address(): string {
    return this._address;
  }

  get description(): string {
    return this._description;
  }

  get surface(): number {
    return this._surface;
  }

  get seaview(): boolean {
    return this._seaview;
  }

  get age(): number {
    return this._age;
  }

  get price(): number {
    return this._price;
  }

  get rooms_number(): number {
    return this._rooms_number;
  }

  get place(): number {
    return this._place;
  }


  get owner(): number {
    return this._owner;
  }

  set owner(value: number) {
    this._owner = value;
  }

  constructor( ) {
    this._id=0;
    this._header_name="";
    this._address = "";
    this._description = "";
    this._surface = 0;
    this._seaview = false;
    this._age = 0;
    this._price = 0;
    this._rooms_number = 0;
    this._place = 0;
    this._garage_number =0;
    this._bathrooms_number = 0;
    this._type = "";
    this._typeOfPaiement = "";
    this._header_name = "";
    this._details = [];
    this._image = null;
    this._owner = 0;
    this._images=[];
  }
}

export class Place{

  private _id:number;
  private _name:string;
  private _description:string;


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get description(): string {
    return this._description;
  }

  set description(value: string) {
    this._description = value;
  }

  constructor(name: string, description: string) {
    this._name = name;
    this._description = description;
  }
}
export class Owner{

  private _id:number;
  private _email:string;
  private _password:string;
  private _name:string;
  private _lastname:string;
  private _telephone:string;
  private _address:string;


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get email(): string {
    return this._email;
  }

  set email(value: string) {
    this._email = value;
  }

  get password(): string {
    return this._password;
  }

  set password(value: string) {
    this._password = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get lastname(): string {
    return this._lastname;
  }

  set lastname(value: string) {
    this._lastname = value;
  }

  get telephone(): string {
    return this._telephone;
  }

  set telephone(value: string) {
    this._telephone = value;
  }

  get address(): string {
    return this._address;
  }

  set address(value: string) {
    this._address = value;
  }
}

import {
  Component,
  ChangeDetectionStrategy,
  ViewChild,
  TemplateRef, OnInit, Input
} from '@angular/core';
import {
  startOfDay,
  endOfDay,
  subDays,
  addDays,
  endOfMonth,
  isSameDay,
  isSameMonth,
  addHours
} from 'date-fns';
import { Subject } from 'rxjs';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import {
  CalendarEvent,
  CalendarEventAction,
  CalendarEventTimesChangedEvent,
  CalendarView
} from 'angular-calendar';
import {FormGroup, FormControl} from "@angular/forms";
import {House} from "../../house";
import {ReservationService} from "./reservation.service";
import {Reservation} from "./reservation";
import {ActivatedRoute, Params} from "@angular/router";
import {HousesService} from "../../../houses.service";

const colors: any = {
  red: {
    primary: '#ad2121',
    secondary: '#FAE3E3'
  },
  blue: {
    primary: '#1e90ff',
    secondary: '#D1E8FF'
  },
  yellow: {
    primary: '#e3bc08',
    secondary: '#FDF1BA'
  }
};

@Component({
  selector: 'app-house-calendar',
  templateUrl: './house-calendar.component.html',
  styleUrls: ['./house-calendar.component.css']
})
export class HouseCalendarComponent implements OnInit {

  @Input() house:House;
  reservations:Reservation[]=[];
  reservationForm:FormGroup;
  events: CalendarEvent[]=[];

  constructor(private modal: NgbModal,
              private reservationService:ReservationService,
              private route:ActivatedRoute,
              private housesService:HousesService) {}

  role="";
  reservation_requests=[];
  number_of_requests=0;
  ngOnInit(){
    this.role=sessionStorage.getItem('role');
    this.route.params.subscribe(
      (params: Params) => {
        this.housesService.getHouseById(params['id']).subscribe(
          data=>{
            console.log(data);
            this.house=<House>data;

              this.reservationService.getHouseReservationsRequests(this.house.id).subscribe(
                data=>{
                  this.reservation_requests=<Reservation[]>data;
                  //this.number_of_requests=this.reservation_requests.length;
                }
              );
              this.reservationService.getHouseConfirmedReservations(this.house.id).subscribe(
                data => {
                  this.reservations = <Reservation[]>data;
                  for (let r of this.reservations) {
                    this.events.push({
                      id:r.id,
                      start: startOfDay(new Date(r.date_debut)),
                      end: endOfDay(new Date(r.date_fin)),
                      title: 'Reservation for customer : ' + r.customer['name'] + " " + r.customer['lastname'],
                      color: {
                        primary: this.get_random_color(),
                        secondary: this.get_random_color()
                      },
                      actions: this.actions,
                      allDay: true,
                      resizable: {
                        beforeStart: true,
                        afterEnd: true
                      },
                      draggable: true
                    });
                    this.refresh.next();
                  }
                });


          });

      }
    );

      this.reservationService.confirmed_Reservations.subscribe(
        data => {
          this.reservations = <Reservation[]>data;
          this.events=[];
          for (let r of this.reservations) {
            this.events.push({
              id:r.id,
              start: startOfDay(new Date(r.date_debut)),
              end: endOfDay(new Date(r.date_fin)),
              title: 'Reservation for customer : ' + r.customer['name'] + " " + r.customer['lastname'],
              color: {
                primary: this.get_random_color(),
                secondary: this.get_random_color()
              },
              //actions: this.actions,
              allDay: true,
              resizable: {
                beforeStart: true,
                afterEnd: true
              },
              draggable: true
            });
            this.refresh.next();
          }
        }
      );
      this.reservationService.reservations_Requests.subscribe(
        data => {
          this.reservation_requests = <Reservation[]>data;
          //this.number_of_requests=this.reservation_requests.length
        }
      );

    this.reservationForm=new FormGroup({
      'date_debut':new FormControl(),
      'date_fin':new FormControl(),
    })
  }

  @ViewChild('modalContent') modalContent: TemplateRef<any>;

  view: CalendarView = CalendarView.Month;

  CalendarView = CalendarView;

  viewDate: Date = new Date();

  modalData: {
    action: string;
    event: CalendarEvent;
  };

  actions: CalendarEventAction[] = [
    {
      label: '<i class="fa fa-fw fa-pencil"></i>',
      onClick: ({ event }: { event: CalendarEvent }): void => {
        this.handleEvent('Edited', event);
      }
    },
    {
      label: '<i class="fa fa-fw fa-times"></i>',
      onClick: ({ event }: { event: CalendarEvent }): void => {
        this.events = this.events.filter(iEvent => iEvent !== event);
        this.handleEvent('Deleted', event);
      }
    }
  ];

  refresh: Subject<any> = new Subject();


  // events: CalendarEvent[] = [
  //   {
  //     start: subDays(startOfDay(new Date()), 1),
  //     end: addDays(new Date(), 1),
  //     title: 'Reservation 1',
  //     color: colors.red,
  //     actions: this.actions,
  //     allDay: true,
  //     resizable: {
  //       beforeStart: true,
  //       afterEnd: true
  //     },
  //     draggable: true
  //   },
  //   {
  //     start: startOfDay(new Date()),
  //     title: 'An event with no end date',
  //     color: colors.yellow,
  //     actions: this.actions
  //   },
  //   {
  //     start: subDays(endOfMonth(new Date()), 3),
  //     end: addDays(endOfMonth(new Date()), 3),
  //     title: 'A long event that spans 2 months',
  //     color: colors.blue,
  //     allDay: true
  //   }
  // ];

  activeDayIsOpen: boolean = false;


  dayClicked({ date, events }: { date: Date; events: CalendarEvent[] }): void {
    if (isSameMonth(date, this.viewDate)) {
      this.viewDate = date;
      if (
        (isSameDay(this.viewDate, date) && this.activeDayIsOpen === true) ||
        events.length === 0
      ) {
        this.activeDayIsOpen = false;
      } else {
        this.activeDayIsOpen = true;
      }
    }
  }

  eventTimesChanged({
    event,
    newStart,
    newEnd
  }: CalendarEventTimesChangedEvent): void {
    this.events = this.events.map(iEvent => {
      if (iEvent === event) {
        return {
          ...event,
          start: newStart,
          end: newEnd
        };
      }
      return iEvent;
    });
    this.handleEvent('Dropped or resized', event);
  }

  handleEvent(action: string, event: CalendarEvent): void {
    this.modalData = { event, action };
    this.modal.open(this.modalContent, { size: 'lg' });
  }

  addEvent(): void {
    this.events = [
      ...this.events,
      {
        title: 'New event',
        start: startOfDay(new Date()),
        end: endOfDay(new Date()),
        color: colors.red,
        draggable: true,
        resizable: {
          beforeStart: true,
          afterEnd: true
        }
      }
    ];
  }

  deleteEvent(eventToDelete: CalendarEvent) {
    this.events = this.events.filter(event => event !== eventToDelete);
  }

  setView(view: CalendarView) {
    this.view = view;
  }

  closeOpenMonthViewDay() {
    this.activeDayIsOpen = false;
  }

  onSendRequest(){
      let r=this.reservationForm.value;
      r["confirmation"]="attendre";
      r["customer"]={id:1};
      r["house"]={id:this.house.id};
      this.reservationService.createReservation(r).subscribe(
        data=>{
          console.log(data);
        }
      );

  }

  get_random_color()
  {
    let color = "";
    for(let i = 0; i < 3; i++) {
      let sub = Math.floor(Math.random() * 256).toString(16);
      color += (sub.length == 1 ? "0" + sub : sub);
    }
    return "#" + color;
  }

  onAccept(id){
    this.reservationService.acceptReservation(id).subscribe(
      data=>{
        console.log("data",data);
        this.reservationService.confirmed_Reservations.next(data);
        this.reservationService.reservations_Requests.next();
      }
    )
  }

  onRefuse(id){
    this.reservationService.refuseReservation(id).subscribe(
      data=>{
        this.reservationService.reservations_Requests.next(data);
        //this.reservationService.confirmed_Reservations.next()
      }
    )
  }
}

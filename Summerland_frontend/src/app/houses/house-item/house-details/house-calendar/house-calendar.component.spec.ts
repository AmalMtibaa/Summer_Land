import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HouseCalendarComponent } from './house-calendar.component';

describe('HouseCalendarComponent', () => {
  let component: HouseCalendarComponent;
  let fixture: ComponentFixture<HouseCalendarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HouseCalendarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HouseCalendarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

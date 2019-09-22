import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FamousHousesComponent } from './famous-houses.component';

describe('FamousHousesComponent', () => {
  let component: FamousHousesComponent;
  let fixture: ComponentFixture<FamousHousesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FamousHousesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FamousHousesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

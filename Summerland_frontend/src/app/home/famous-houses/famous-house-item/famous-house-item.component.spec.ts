import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FamousHouseItemComponent } from './famous-house-item.component';

describe('FamousHouseItemComponent', () => {
  let component: FamousHouseItemComponent;
  let fixture: ComponentFixture<FamousHouseItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FamousHouseItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FamousHouseItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

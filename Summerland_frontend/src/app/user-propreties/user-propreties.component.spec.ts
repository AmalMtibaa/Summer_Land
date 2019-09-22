import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserPropretiesComponent } from './user-propreties.component';

describe('UserPropretiesComponent', () => {
  let component: UserPropretiesComponent;
  let fixture: ComponentFixture<UserPropretiesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserPropretiesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserPropretiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

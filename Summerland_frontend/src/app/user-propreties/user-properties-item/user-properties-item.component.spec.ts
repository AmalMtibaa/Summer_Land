import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserPropertiesItemComponent } from './user-properties-item.component';

describe('UserPropertiesItemComponent', () => {
  let component: UserPropertiesItemComponent;
  let fixture: ComponentFixture<UserPropertiesItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserPropertiesItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserPropertiesItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

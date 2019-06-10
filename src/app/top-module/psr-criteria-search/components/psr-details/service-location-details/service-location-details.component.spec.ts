import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceLocationDetailsComponent } from './service-location-details.component';

describe('ServiceLocationDetailsComponent', () => {
  let component: ServiceLocationDetailsComponent;
  let fixture: ComponentFixture<ServiceLocationDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServiceLocationDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceLocationDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConnectionSearchFormComponent } from './connection-search-form.component';

describe('ConnectionSearchFormComponent', () => {
  let component: ConnectionSearchFormComponent;
  let fixture: ComponentFixture<ConnectionSearchFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConnectionSearchFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConnectionSearchFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

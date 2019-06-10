import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConnectionDesignDetailComponent } from './connection-design-detail.component';

describe('ConnectionDesignDetailComponent', () => {
  let component: ConnectionDesignDetailComponent;
  let fixture: ComponentFixture<ConnectionDesignDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConnectionDesignDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConnectionDesignDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConnectionSearchResultsComponent } from './connection-search-results.component';

describe('ConnectionSearchResultsComponent', () => {
  let component: ConnectionSearchResultsComponent;
  let fixture: ComponentFixture<ConnectionSearchResultsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConnectionSearchResultsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConnectionSearchResultsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

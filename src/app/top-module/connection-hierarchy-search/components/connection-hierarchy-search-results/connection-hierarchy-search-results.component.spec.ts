import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConnectionHierarchySearchResultsComponent } from './connection-hierarchy-search-results.component';

describe('ConnectionHierarchySearchResultsComponent', () => {
  let component: ConnectionHierarchySearchResultsComponent;
  let fixture: ComponentFixture<ConnectionHierarchySearchResultsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConnectionHierarchySearchResultsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConnectionHierarchySearchResultsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

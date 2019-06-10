import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConnectionHierarchySearchComponent } from './connection-hierarchy-search.component';

describe('ConnectionHierarchySearchComponent', () => {
  let component: ConnectionHierarchySearchComponent;
  let fixture: ComponentFixture<ConnectionHierarchySearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConnectionHierarchySearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConnectionHierarchySearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConnectionHierarchyNodeComponent } from './connection-hierarchy-node.component';

describe('ConnectionHierarchyNodeComponent', () => {
  let component: ConnectionHierarchyNodeComponent;
  let fixture: ComponentFixture<ConnectionHierarchyNodeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConnectionHierarchyNodeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConnectionHierarchyNodeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

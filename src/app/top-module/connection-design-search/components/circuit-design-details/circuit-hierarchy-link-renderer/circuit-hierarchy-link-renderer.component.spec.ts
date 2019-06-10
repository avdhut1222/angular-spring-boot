import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CircuitHierarchyLinkRendererComponent } from './circuit-hierarchy-link-renderer.component';

describe('CircuitHierarchyLinkRendererComponent', () => {
  let component: CircuitHierarchyLinkRendererComponent;
  let fixture: ComponentFixture<CircuitHierarchyLinkRendererComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CircuitHierarchyLinkRendererComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CircuitHierarchyLinkRendererComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

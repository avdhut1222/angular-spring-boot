import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CircuitXrefSectionComponent } from './circuit-xref-section.component';

describe('CircuitXrefSectionComponent', () => {
  let component: CircuitXrefSectionComponent;
  let fixture: ComponentFixture<CircuitXrefSectionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CircuitXrefSectionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CircuitXrefSectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

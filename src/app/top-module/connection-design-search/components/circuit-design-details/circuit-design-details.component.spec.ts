import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CircuitDesignDetailsComponent } from './circuit-design-details.component';

describe('CircuitDesignDetailsComponent', () => {
  let component: CircuitDesignDetailsComponent;
  let fixture: ComponentFixture<CircuitDesignDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CircuitDesignDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CircuitDesignDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

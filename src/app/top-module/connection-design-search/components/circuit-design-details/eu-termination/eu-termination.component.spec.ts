import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EuTerminationComponent } from './eu-termination.component';

describe('EuTerminationComponent', () => {
  let component: EuTerminationComponent;
  let fixture: ComponentFixture<EuTerminationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EuTerminationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EuTerminationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

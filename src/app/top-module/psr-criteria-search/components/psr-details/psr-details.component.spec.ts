import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PsrDetailsComponent } from './psr-details.component';

describe('PsrDetailsComponent', () => {
  let component: PsrDetailsComponent;
  let fixture: ComponentFixture<PsrDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PsrDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PsrDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

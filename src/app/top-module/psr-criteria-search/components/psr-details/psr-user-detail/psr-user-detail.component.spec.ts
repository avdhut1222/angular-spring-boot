import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PsrUserDetailComponent } from './psr-user-detail.component';

describe('PsrUserDetailComponent', () => {
  let component: PsrUserDetailComponent;
  let fixture: ComponentFixture<PsrUserDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PsrUserDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PsrUserDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

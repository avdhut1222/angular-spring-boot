import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PsrSearchComponent } from './psr-search.component';

describe('PsrSearchComponent', () => {
  let component: PsrSearchComponent;
  let fixture: ComponentFixture<PsrSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PsrSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PsrSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

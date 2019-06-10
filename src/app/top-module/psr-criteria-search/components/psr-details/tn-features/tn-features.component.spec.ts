import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TnFeaturesComponent } from './tn-features.component';

describe('TnFeaturesComponent', () => {
  let component: TnFeaturesComponent;
  let fixture: ComponentFixture<TnFeaturesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TnFeaturesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TnFeaturesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

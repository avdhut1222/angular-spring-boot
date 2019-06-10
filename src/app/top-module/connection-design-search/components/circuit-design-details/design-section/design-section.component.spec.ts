import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DesignSectionComponent } from './design-section.component';

describe('DesignSectionComponent', () => {
  let component: DesignSectionComponent;
  let fixture: ComponentFixture<DesignSectionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DesignSectionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DesignSectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

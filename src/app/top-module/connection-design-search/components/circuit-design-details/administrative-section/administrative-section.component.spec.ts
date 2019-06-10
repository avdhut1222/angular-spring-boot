import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdministrativeSectionComponent } from './administrative-section.component';

describe('AdministrativeSectionComponent', () => {
  let component: AdministrativeSectionComponent;
  let fixture: ComponentFixture<AdministrativeSectionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdministrativeSectionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdministrativeSectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChildSrInformationComponent } from './child-sr-information.component';

describe('ChildSrInformationComponent', () => {
  let component: ChildSrInformationComponent;
  let fixture: ComponentFixture<ChildSrInformationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChildSrInformationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChildSrInformationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PicInformationComponent } from './pic-information.component';

describe('PicInformationComponent', () => {
  let component: PicInformationComponent;
  let fixture: ComponentFixture<PicInformationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PicInformationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PicInformationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

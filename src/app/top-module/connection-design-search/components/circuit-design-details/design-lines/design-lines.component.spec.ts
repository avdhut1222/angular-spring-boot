import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DesignLinesComponent } from './design-lines.component';

describe('DesignLinesComponent', () => {
  let component: DesignLinesComponent;
  let fixture: ComponentFixture<DesignLinesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DesignLinesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DesignLinesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

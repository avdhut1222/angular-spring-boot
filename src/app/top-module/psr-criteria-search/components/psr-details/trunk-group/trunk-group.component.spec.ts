import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrunkGroupComponent } from './trunk-group.component';

describe('TrunkGroupComponent', () => {
  let component: TrunkGroupComponent;
  let fixture: ComponentFixture<TrunkGroupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrunkGroupComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrunkGroupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

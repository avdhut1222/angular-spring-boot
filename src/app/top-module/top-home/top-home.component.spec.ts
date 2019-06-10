import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TopHomeComponent } from './top-home.component';

describe('TopHomeComponent', () => {
  let component: TopHomeComponent;
  let fixture: ComponentFixture<TopHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TopHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TopHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

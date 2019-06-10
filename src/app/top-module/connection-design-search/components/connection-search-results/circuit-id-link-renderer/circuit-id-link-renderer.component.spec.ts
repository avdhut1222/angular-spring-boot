import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CircuitIdLinkRendererComponent } from './circuit-id-link-renderer.component';

describe('CircuitIdLinkRendererComponent', () => {
  let component: CircuitIdLinkRendererComponent;
  let fixture: ComponentFixture<CircuitIdLinkRendererComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CircuitIdLinkRendererComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CircuitIdLinkRendererComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

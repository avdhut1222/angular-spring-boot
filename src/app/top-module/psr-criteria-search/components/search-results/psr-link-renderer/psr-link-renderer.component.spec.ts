import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PsrLinkRendererComponent } from './psr-link-renderer.component';

describe('PsrLinkRendererComponent', () => {
  let component: PsrLinkRendererComponent;
  let fixture: ComponentFixture<PsrLinkRendererComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PsrLinkRendererComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PsrLinkRendererComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

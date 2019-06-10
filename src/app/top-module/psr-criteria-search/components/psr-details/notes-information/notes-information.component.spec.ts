import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NotesInformationComponent } from './notes-information.component';

describe('NotesInformationComponent', () => {
  let component: NotesInformationComponent;
  let fixture: ComponentFixture<NotesInformationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NotesInformationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NotesInformationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { TestBed, inject } from '@angular/core/testing';
import {ConnectionDesignService} from "./connection-design.service.";


describe('ConnectionDesignService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ConnectionDesignService]
    });
  });

  it('should be created', inject([ConnectionDesignService], (service: ConnectionDesignService) => {
    expect(service).toBeTruthy();
  }));
});

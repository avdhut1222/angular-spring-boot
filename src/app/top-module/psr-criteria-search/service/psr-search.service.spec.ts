import { TestBed, inject } from '@angular/core/testing';

import { PsrSearchService } from './psr-search.service';

describe('PsrSearchService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PsrSearchService]
    });
  });

  it('should be created', inject([PsrSearchService], (service: PsrSearchService) => {
    expect(service).toBeTruthy();
  }));
});

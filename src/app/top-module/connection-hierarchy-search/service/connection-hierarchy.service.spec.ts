import { TestBed, inject } from '@angular/core/testing';

import { ConnectionHierarchyService } from './connection-hierarchy.service';

describe('ConnectionHierarchyService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ConnectionHierarchyService]
    });
  });

  it('should be created', inject([ConnectionHierarchyService], (service: ConnectionHierarchyService) => {
    expect(service).toBeTruthy();
  }));
});

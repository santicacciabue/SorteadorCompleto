import { TestBed } from '@angular/core/testing';

import { ReemplazosService } from './reemplazos.service';

describe('ReemplazosService', () => {
  let service: ReemplazosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReemplazosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

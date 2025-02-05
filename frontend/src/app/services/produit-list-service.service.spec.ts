import { TestBed } from '@angular/core/testing';

import { ProduitListServiceService } from './produit-list-service.service';

describe('ProduitListServiceService', () => {
  let service: ProduitListServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProduitListServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

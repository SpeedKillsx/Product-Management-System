import { TestBed } from '@angular/core/testing';

import { ProduitSearchService } from './produit-search.service';

describe('ProduitSearchService', () => {
  let service: ProduitSearchService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProduitSearchService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { ProduitFormComponentService } from './produit-form-component.service';

describe('ProduitFormComponentService', () => {
  let service: ProduitFormComponentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProduitFormComponentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

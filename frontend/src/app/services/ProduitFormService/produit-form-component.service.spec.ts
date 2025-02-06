import { TestBed } from '@angular/core/testing';

import { ProduitFormService } from './produit-form-component.service';

describe('ProduitFormComponentService', () => {
  let service: ProduitFormService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProduitFormService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

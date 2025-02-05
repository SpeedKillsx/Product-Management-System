import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProduitFormComponentComponent } from './produit-form-component.component';

describe('ProduitFormComponentComponent', () => {
  let component: ProduitFormComponentComponent;
  let fixture: ComponentFixture<ProduitFormComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProduitFormComponentComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProduitFormComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

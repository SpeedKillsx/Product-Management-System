import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProduitListComponentComponent } from './produit-list-component.component';

describe('ProduitListComponentComponent', () => {
  let component: ProduitListComponentComponent;
  let fixture: ComponentFixture<ProduitListComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProduitListComponentComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProduitListComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaReemplazoComponent } from './lista-reemplazo.component';

describe('ListaReemplazoComponent', () => {
  let component: ListaReemplazoComponent;
  let fixture: ComponentFixture<ListaReemplazoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListaReemplazoComponent]
    });
    fixture = TestBed.createComponent(ListaReemplazoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionReemplazosComponent } from './gestion-reemplazos.component';

describe('GestionReemplazosComponent', () => {
  let component: GestionReemplazosComponent;
  let fixture: ComponentFixture<GestionReemplazosComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GestionReemplazosComponent]
    });
    fixture = TestBed.createComponent(GestionReemplazosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

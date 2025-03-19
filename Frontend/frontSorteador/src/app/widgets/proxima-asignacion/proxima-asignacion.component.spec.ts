import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProximaAsignacionComponent } from './proxima-asignacion.component';

describe('ProximaAsignacionComponent', () => {
  let component: ProximaAsignacionComponent;
  let fixture: ComponentFixture<ProximaAsignacionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProximaAsignacionComponent]
    });
    fixture = TestBed.createComponent(ProximaAsignacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

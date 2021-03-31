import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormLojaComponent } from './form-loja.component';

describe('FormFuncionarioComponent', () => {
  let component: FormLojaComponent;
  let fixture: ComponentFixture<FormLojaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormLojaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormLojaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

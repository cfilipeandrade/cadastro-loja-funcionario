import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CriarLojaComponent } from './criar-loja.component';

describe('CriarFuncionarioComponent', () => {
  let component: CriarLojaComponent;
  let fixture: ComponentFixture<CriarLojaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CriarLojaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CriarLojaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

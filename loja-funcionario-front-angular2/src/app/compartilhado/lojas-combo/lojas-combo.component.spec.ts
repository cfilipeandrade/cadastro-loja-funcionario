import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LojasComboComponent } from './lojas-combo.component';

describe('LojasComboComponent', () => {
  let component: LojasComboComponent;
  let fixture: ComponentFixture<LojasComboComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LojasComboComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LojasComboComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

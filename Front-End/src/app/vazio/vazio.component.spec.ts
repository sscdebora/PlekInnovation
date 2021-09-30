import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VazioComponent } from './vazio.component';

describe('VazioComponent', () => {
  let component: VazioComponent;
  let fixture: ComponentFixture<VazioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VazioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VazioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

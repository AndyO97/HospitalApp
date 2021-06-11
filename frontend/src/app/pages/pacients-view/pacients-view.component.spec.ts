import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PacientsViewComponent } from './pacients-view.component';

describe('PacientsViewComponent', () => {
  let component: PacientsViewComponent;
  let fixture: ComponentFixture<PacientsViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PacientsViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PacientsViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

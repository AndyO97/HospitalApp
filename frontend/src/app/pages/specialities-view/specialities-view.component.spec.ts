import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpecialitiesViewComponent } from './specialities-view.component';

describe('SpecialitiesViewComponent', () => {
  let component: SpecialitiesViewComponent;
  let fixture: ComponentFixture<SpecialitiesViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpecialitiesViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SpecialitiesViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BracketNavComponent } from './bracket-nav.component';

describe('BracketNavComponent', () => {
  let component: BracketNavComponent;
  let fixture: ComponentFixture<BracketNavComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BracketNavComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BracketNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

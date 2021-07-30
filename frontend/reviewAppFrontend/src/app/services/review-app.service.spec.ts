import { TestBed } from '@angular/core/testing';

import { ReviewAppService } from './review-app.service';

describe('ReviewAppService', () => {
  let service: ReviewAppService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReviewAppService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

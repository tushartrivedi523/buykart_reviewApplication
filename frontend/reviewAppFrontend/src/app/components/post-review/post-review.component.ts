import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Subscription } from 'rxjs';
import { ReviewAppService } from 'src/app/services/review-app.service';

@Component({
  selector: 'app-post-review',
  templateUrl: './post-review.component.html',
  styleUrls: ['./post-review.component.css']
})
export class PostReviewComponent implements OnInit {

  userId:string;
  subscription: Subscription;

  reviewTitle:any;
  reviewContent:any;


  constructor(private reviewAppService : ReviewAppService,  private toastr: ToastrService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.subscription = this.reviewAppService.currentMessage.subscribe(message => this.userId = message)
  }

  createReviewOnClick()
  {
    const dataToInsert={
      userName:this.userId,
      reviewTitle:this.reviewTitle,
      reviewContent:this.reviewContent,
      productId:this.route.snapshot.paramMap.get('pId')
    }
    // console.log(dataToInsert)
    this.reviewAppService.createReview(dataToInsert)
      .subscribe(response=>{
        if(response == true)
        {
          this.successToaster();
        }
        else
        {
          this.errorToaster();
        }
        console.log(response)
      },error=>{
        this.errorToaster();
        console.log(error);
      })
  }
  successToaster()
  {
    this.toastr.success("Review Added Successfully");
    this.router.navigate([`productDesp/${this.route.snapshot.paramMap.get('pId')}`]);
  }

  errorToaster(){
    this.toastr.error("Error in adding review try again after some time.");

  }

}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router'; 
import { ProductList, ReviewList } from 'src/app/models/review-app.model';
import { ReviewAppService } from 'src/app/services/review-app.service';


@Component({
  selector: 'app-product-description',
  templateUrl: './product-description.component.html',
  styleUrls: ['./product-description.component.css']
})
export class ProductDescriptionComponent implements OnInit {

  productId:any;
  fetchedProduct:ProductList;
  fetchedReviews:ReviewList[];

  constructor(private route: ActivatedRoute, private reviewAppService: ReviewAppService) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params=>{
      this.productId = params;
    })
    this.getProductDetails(this.route.snapshot.paramMap.get('pId'));
    this.getReviews(this.route.snapshot.paramMap.get('pId'));
  }

  getProductDetails(id:any)
  {
    this.reviewAppService.get(id)
      .subscribe(data=>{
        this.fetchedProduct = data;
        console.log(data);
      },
      error=>{
        console.log(error);
      });
  }
  getReviews(id:any)
  {
    this.reviewAppService.getAllReviewById(id)
      .subscribe(data=>{
        this.fetchedReviews = data;
        console.log(data);
      },
      error=>{
        console.log(error);
      });
  }

}

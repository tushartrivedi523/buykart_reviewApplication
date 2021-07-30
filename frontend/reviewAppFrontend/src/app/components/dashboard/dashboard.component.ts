import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductList } from 'src/app/models/review-app.model';
import { ReviewAppService } from 'src/app/services/review-app.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})

export class DashboardComponent implements OnInit {

  userId:string=null;
  productList ?: ProductList[];
  userLoggedIn : boolean = false;

  reviewStats:any;
  productStats:any;
  userStats:any;

  constructor(private reviewAppService : ReviewAppService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.getAllProduct();
    this.getAllReviews();
    this.getAllMembers();
  }
  getAllProduct():void{
    this.reviewAppService.getAll().subscribe(data=>{this.productList = data;
                                                    this.productStats = data.length;
                                                    console.log(data);
                                                    console.log("Hiiiii")
                                                    console.log(data.length)
                                                  },
                                                  error=>{
                                                    
                                                    console.log(error);
                                                  });
  }

  getAllReviews(){
    this.reviewAppService.getAllReviews()
      .subscribe(data=>{
        this.reviewStats = data.length;
      },
      error=>{
        console.log(error);
      })
  }

  getAllMembers(){
    this.reviewAppService.getAllUsers()
      .subscribe(data=>{
        this.userStats = data.length;
      },
      error=>{
        console.log(error);
      })
  }

}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { ProductList } from 'src/app/models/review-app.model';
import { ReviewAppService } from 'src/app/services/review-app.service';

@Component({
  selector: 'app-auth-dashboard',
  templateUrl: './auth-dashboard.component.html',
  styleUrls: ['./auth-dashboard.component.css']
})
export class AuthDashboardComponent implements OnInit {

  byBrandName : any;
  byProductName : any;
  byProductId : any;

  fetchedProductListByBrand : ProductList[];
  fetchedProductListByName : ProductList;
  fetchedProductListById : ProductList;

  isSearchingByBrand : boolean=false;
  isSearchingByName : boolean=false;
  isSearchingById : boolean=false;

  isNull:boolean = true;

  productList ?: ProductList[];

  loggedInUserId:string;
  userFirstName:string;
  subscription: Subscription;
  constructor(private reviewAppService : ReviewAppService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.getAllProduct();
    this.subscription = this.reviewAppService.currentMessage.subscribe(message => {this.loggedInUserId = message})    
    this.getUserByUserName(this.loggedInUserId);
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

  
  getAllProduct():void{
    this.reviewAppService.getAll().subscribe(data=>{this.productList = data;
                                                    console.log(data);
                                                  },
                                                  error=>{
                                                    
                                                    console.log(error);
                                                  });
  }
  getUserByUserName(userName:any){
    this.reviewAppService.getUserByUserName(userName)
      .subscribe(data=>{
        this.userFirstName = data.userFirstName;
        console.log(data);
      })
  }

  searchByBrandOnClick(){
    this.reviewAppService.getAllProductByBrand(this.byBrandName)
      .subscribe(data=>{
        console.log(data);
        this.isSearchingByBrand = true;
        this.isSearchingByName = false;
        this.isSearchingById = false;
        if(data==null)
        {
          this.isNull = true;
        }
        else
        {
          this.fetchedProductListByBrand = data;
          
          this.isNull=false;
        }
      },
      error=>{
        console.log(error);
      })
  }

  searchByNameOnClick(){
    this.reviewAppService.getAllProductByName(this.byProductName)
      .subscribe(data=>{
        console.log(data);
        this.isSearchingByName = true;
        this.isSearchingByBrand = false;
        this.isSearchingById = false;
        if(data==null)
        {
          this.isNull=true;
        }
        else
        {
          this.fetchedProductListByName = data;
          
          this.isNull = false;
          console.log(data);
        }
      },
      error=>{
        console.log(error);
      })
  }

  searchByIdOnClick(){
    this.reviewAppService.getAllProductById(this.byProductId)
      .subscribe(data=>{
        console.log(data)
        this.isSearchingByName = false;
        this.isSearchingById = true;
        this.isSearchingByBrand = false;
        if(data==null)
        {
          this.isNull=true;
        }
        else
        {
          this.fetchedProductListById = data;
          
          this.isNull=false;
          console.log(data);
        }
          
      },
      error=>{
        console.log(error);
      })
  }
}

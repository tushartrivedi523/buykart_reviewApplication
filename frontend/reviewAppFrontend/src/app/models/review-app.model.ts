export class ProductList {

    productid ?: any;
    productname:any;
    productprice:any;
    brand:any;
    productdetail:any;

}

export class UserAuth{

    userid ?:any;
    userName:any;
    userPassword:any;
    userFirstName:any;
    userLastName:any;
    userEmail:any;
}

export class ReviewList{

    reviewId ?:any;
    productId : any;
    reviewTitle : any;
    reviewContent : any;
    userName : any;
    
}

export class isUserValid{
    isUserLoggedIn : boolean = false;
}

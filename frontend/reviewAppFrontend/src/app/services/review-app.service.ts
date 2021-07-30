import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { ProductList, ReviewList, UserAuth } from '../models/review-app.model';

const baseUrl = 'http://localhost:8081/api'

@Injectable({
  providedIn: 'root'
})

export class ReviewAppService {  

  private messageSource = new BehaviorSubject("");
  currentMessage = this.messageSource.asObservable();

  constructor(private http:HttpClient) { }

  changeMessage(message: string) {
    this.messageSource.next(message)
  }

  getAll():Observable<ProductList[]>{
    return this.http.get<ProductList[]>(`${baseUrl}/productList`);
  }

  get(id:any): Observable<ProductList> {
    return this.http.get<ProductList>(`${baseUrl}/productList/${id}`);
  }

  getAllReviews():Observable<ReviewList[]>{
    return this.http.get<ReviewList[]>(`${baseUrl}/reviewList`);
  }

  getAllReviewById(id:any): Observable<ReviewList[]> {
    return this.http.get<ReviewList[]>(`${baseUrl}/reviewList/${id}`);
  }

  createReview(data: any): Observable<any> {
    return this.http.post(`${baseUrl}/reviewList`, data);
  }

  getUserByUserName(userName:any):Observable<any>{
    return this.http.get(`${baseUrl}/userAuth/${userName}`)
  }
  getAllUsers():Observable<any>{
    return this.http.get(`${baseUrl}/userAuth`);
  }
  
  loginUser(userId:any, userPassword:any):Observable<boolean>{
    return this.http.get<boolean>(`${baseUrl}/userAuth/${userId}/${userPassword}`);
  }

  create(data: any): Observable<any> {
    return this.http.post(`${baseUrl}/userAuth`, data);
  }

  getAllProductByBrand(brand:any):Observable<ProductList[]>{
    return this.http.get<ProductList[]>(`${baseUrl}/productList/searchByBrand/${brand}`);
  }

  getAllProductByName(name:any):Observable<ProductList>{
    return this.http.get<ProductList>(`${baseUrl}/productList/searchByName/${name}`);
  }

  getAllProductById(id:any):Observable<ProductList>{
    return this.http.get<ProductList>(`${baseUrl}/productList/${id}`);
  }

}

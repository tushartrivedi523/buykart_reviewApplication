import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Subscription } from 'rxjs';
import { LoginComponent } from './components/login/login.component';
import { ReviewAppService } from './services/review-app.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {


  title = 'reviewAppFrontend';

  message:string;
  subscription: Subscription;

  constructor(private reviewAppService : ReviewAppService, private toastr: ToastrService ,private router: Router){}

  ngOnInit():void{
    this.subscription = this.reviewAppService.currentMessage.subscribe(message => this.message = message)
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }
  newMessage() {
    this.reviewAppService.changeMessage('')
  }
  
  logoutOnClick(){
    this.newMessage();
    this.toastr.success("Successfully Logged Out");
    // this.router.navigate([``]);
  }
}

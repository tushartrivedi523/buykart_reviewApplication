import { Component, OnInit } from '@angular/core';
import { UserAuth } from 'src/app/models/review-app.model';
import { ReviewAppService } from 'src/app/services/review-app.service';
import { ToastrService } from 'ngx-toastr';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Subscription } from 'rxjs';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  inputUserId : any;
  inputPassword : any;
  allUserAuth : UserAuth[];
  userVerification:boolean=false;

  message:string;
  subscription: Subscription;

  constructor(private reviewAppService : ReviewAppService, private toastr: ToastrService, private route: ActivatedRoute,
    private router: Router ) { }

  ngOnInit(): void {
    this.subscription = this.reviewAppService.currentMessage.subscribe(message => this.message = message)    
  }
  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

  newMessage() {
    this.reviewAppService.changeMessage(this.inputUserId)
  }
  
  loginOnClick(){
    console.log(this.inputUserId);
    this.reviewAppService.loginUser(this.inputUserId,this.inputPassword)
    .subscribe(data=>{
      console.log(data)
      this.userVerification = data;
      if(this.userVerification == true)
      {
        this.successToaster();
      }
      else
      {
        this.errorToaster();
      }
    },error=>{
      console.log(error);
    })
  }

  successToaster(){
    this.toastr.success("Login Successful");
    this.reviewAppService.loginUser= this.inputUserId;
    this.newMessage();
    this.router.navigate([`dashboardAuth`]);
  }

  errorToaster(){
    this.toastr.error("Wrong UserId or Password");
  }

}

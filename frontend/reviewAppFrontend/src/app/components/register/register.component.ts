import { Component, OnInit } from '@angular/core';
import { ReviewAppService } from 'src/app/services/review-app.service';
import { ToastrService } from 'ngx-toastr';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';



@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  userName:any;
  userPassword:any;
  userConfirmPassword:any;
  userFirstName:any;
  userLastName:any;

  constructor(private reviewAppService: ReviewAppService, private toastr: ToastrService, private router: Router) { }

  ngOnInit(): void {
  }
  createOnClick(){
    if(this.userPassword != this.userConfirmPassword)
    {
      this.passNotMatchToastr();
    }
    else if(this.userName == null || this.userPassword == null || this.userConfirmPassword == null || this.userFirstName == null || this.userLastName==null)
    {
      this.emptyFieldToastr();
    }
    else{

    const dataToInsert={
      userName:this.userName,
      userPassword:this.userPassword,
      userConfirmPassword:this.userConfirmPassword,
      userFirstName:this.userFirstName,
      userLastName:this.userLastName
    }

    this.reviewAppService.create(dataToInsert)
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
  }
  successToaster()
  {
    this.toastr.success("Registration Successful! Please Login Now");
    this.router.navigate([`login`]);
  }

  errorToaster(){
    this.toastr.error("Registration was unsuccessful!");

  }
  passNotMatchToastr(){
    this.toastr.error("Password not match with confirm password");
  }
  emptyFieldToastr()
  {
    this.toastr.error("Some fields are empty!")
  }
}

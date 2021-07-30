import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { AuthDashboardComponent } from './components/auth-dashboard/auth-dashboard.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { LoginComponent } from './components/login/login.component';
import { PostReviewComponent } from './components/post-review/post-review.component';
import { ProductDescriptionComponent } from './components/product-description/product-description.component';
import { RegisterComponent } from './components/register/register.component';

const routes: Routes = [
{path: '', redirectTo: 'dashboard', pathMatch:'full'},
{path:'login', component:LoginComponent},
{path:'register', component:RegisterComponent},
{path:'dashboard', component:DashboardComponent},
{path:'dashboardAuth', component:AuthDashboardComponent},
{path: 'productDesp/:pId', component:ProductDescriptionComponent},
{path:'postReview/:pId', component:PostReviewComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

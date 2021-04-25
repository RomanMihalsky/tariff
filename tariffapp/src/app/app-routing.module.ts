import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MainAboutComponent } from './main/main-about/main-about.component';
import { MainRouterComponent } from './main/main-router/main-router.component';
import { MainTariffComponent } from './main/main-tariff/main-tariff.component';
import { MainComponent } from './main/main.component';
import { UserComponent } from './user/user.component';

const routes: Routes = [
  {path:'',component: UserComponent},
  {path:'main',component: MainComponent,
  children:[
    {path:'tariff',component: MainTariffComponent},
    {path:'router',component: MainRouterComponent},
    {path:'about',component: MainAboutComponent}
  ]},
  {path:'login',component: UserComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

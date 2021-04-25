import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MainComponent } from './main/main.component';
import { UserComponent } from './user/user.component';
import { DigitalClockComponent } from './digital-clock/digital-clock.component';
import { MainTariffComponent } from './main/main-tariff/main-tariff.component';
import { MainAboutComponent } from './main/main-about/main-about.component';
import { MainRouterComponent } from './main/main-router/main-router.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    UserComponent,
    MainTariffComponent,
    DigitalClockComponent,
    MainAboutComponent,
    MainRouterComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

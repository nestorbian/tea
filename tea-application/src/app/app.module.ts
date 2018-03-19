import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { UploadComponent } from './upload/upload.component';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {HttpModule} from '@angular/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ButtonModule, InputTextModule} from 'primeng/primeng';
import { RegisterComponent } from './register/register.component';
import {MessagesModule} from 'primeng/messages';
import {MessageModule} from 'primeng/message';
import { IpService } from './service/ip.service';
import { UserService } from './service/user.service';
import { AdminService } from './service/admin.service';
import { LoginComponent } from './login/login.component';
import {CheckboxModule} from 'primeng/checkbox';


@NgModule({
  declarations: [
    AppComponent,
    UploadComponent,
    RegisterComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    HttpModule,
    BrowserAnimationsModule,
    InputTextModule,
    ButtonModule,
    MessagesModule,
    MessageModule,
    CheckboxModule
  ],
  providers: [IpService, UserService, AdminService],
  bootstrap: [AppComponent]
})
export class AppModule { }

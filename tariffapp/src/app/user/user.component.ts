import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Auth } from '../model/auth';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private route: ActivatedRoute,private router: Router,private userService:UserService) { }

  ngOnInit(): void {
  }

  public onLogin(auth: Auth): void {
      this.userService.login(auth).subscribe(
        (response: Auth) => {
          console.log(response);
            this.userService.setLoggedIn(true);
            this.router.navigateByUrl('main/tariff');
        },
        (errorResponse: HttpErrorResponse) => {
          this.router.navigateByUrl('login');
        }
      )
  }
}

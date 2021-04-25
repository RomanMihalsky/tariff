import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  constructor(private route: ActivatedRoute,private router: Router,private userService:UserService) { }

  ngOnInit(): void {
  }

  logOut(){
    this.router.navigateByUrl('login');
  }
}

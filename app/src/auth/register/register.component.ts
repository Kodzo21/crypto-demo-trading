import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../../model/user";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../../service/user.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  user: User;


  constructor(
    private route:ActivatedRoute,
    private router:Router,
    private userService:UserService,
  ) {
    this.user=new User();
  }

  onSubmit(){
    console.log(this.user);
    this.userService.save(this.user).subscribe(response=>console.log(response));
  }
}

import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {User} from "../model/user";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
@Injectable()
export class UserService {

  private readonly url:string;

  constructor(private http: HttpClient) {
    this.url = "http://localhost:8080/api/v1/auth"
  }

  public findAll():Observable<User[]>{
    return this.http.get<User[]>(this.url + "/users")
  }

  public save(user: User) {
    const headers = new HttpHeaders().set('Content-Type','application/json');
    return this.http.post<User>(this.url+"/register",user,{headers});
  }
}

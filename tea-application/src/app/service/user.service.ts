import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IpService } from './ip.service';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class UserService {

  constructor(private http: HttpClient, private ipService: IpService) {
  }

  register(userName: string, password: string, phoneNumber: string): Observable<any> {
    const param = {userName: userName, password: password, phone: phoneNumber};
    return this.http.post(this.ipService.ipAdress + '/tea/users', param);
  }

  getUserByUserName(userName: string): Observable<any> {
    return this.http.get(this.ipService.ipAdress + `/tea/users/${userName}`);
  }

  getUserByPhone(phone: string): Observable<any> {
    return this.http.get(this.ipService.ipAdress + `/tea/users?phone=${phone}`);
  }

}

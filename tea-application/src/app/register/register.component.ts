import { Component, OnInit } from '@angular/core';
import { Password } from 'primeng/primeng';
import { UserService } from '../service/user.service';
import { error } from 'util';
import { Result } from '../mdoel/result';
import { HttpErrorResponse } from '@angular/common/http/src/response';
import { Router } from '@angular/router';
import { Message } from '@angular/compiler/src/i18n/i18n_ast';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  // 表单字段
  userName: string;
  password: string;
  repeatPassword: string;
  phoneValidateNumber: string;
  generatedImgNumber = '';
  imgNumber: string;
  phoneNumber: string;

  // 生成图片验证码
  imgNumberArray: string[] = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O',
  'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i',
  'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm'];

  // 验证表单
  passwordIsIdentical = true;
  phoneIsCorrect = true;
  imgNumberIsCorrect = true;
  phoneValidateNumberIsCorrect = true;

  // 错误提示弹窗
  showErrorTip = false;
  errorMessage: string;

  constructor(private userService: UserService, private router: Router) {
   }

  ngOnInit() {
    this.generateImageNumber();
  }

  // 生成图片验证码
  generateImageNumber(): void {
    this.generatedImgNumber = '';
    for (let i = 0; i < 4; i++) {
      this.generatedImgNumber += this.imgNumberArray[Math.floor(Math.random() * 62)];
    }
  }

  // 倒计时
  countDown(event: any): void {
    const regex = /^1[3|4|5|8][0-9]\d{4,8}$/;
    if (!this.phoneNumber) {
    } else if (!regex.test(this.phoneNumber) || this.phoneNumber.length < 11) {
      this.phoneIsCorrect = false;
    } else {
      let index = 60;
      const timer = setInterval(() => {
        if (index > 1) {
          index -= 1;
          event.srcElement.innerText = index;
          event.target.className = 'btn btn-info disabled';
        } else {
          clearInterval(timer);
          event.srcElement.innerText = '获取验证码';
          event.target.className = 'btn btn-info';
        }
      }, 1000);
      console.log(event);
    }
  }

  // 只能输入数字
  removeChar(event: any): boolean {
    const code = event.keyCode;
    if (code < 48 || code > 57) {
      return false;
    } else {
      return true;
    }
  }

  // 错误处理
  handleError(err: HttpErrorResponse) {
    if (err.error instanceof Error) {
      this.errorMessage = '客户端网络错误';
    } else if (err.status >= 300 && err.status < 400) {
      this.errorMessage = '请求超时';
    } else if (err.status === 404) {
      this.errorMessage = '请求资源未找到';
    } else if (err.status >= 500 && err.status < 600) {
      this.errorMessage = '服务器内部错误';
    } else {
      this.errorMessage = '请求超时';
    }
    this.showTip();
  }

  // 弹出错误提示框
  showTip(): void {
    this.showErrorTip = true;
    setTimeout(() => {
      this.errorMessage = '';
      this.showErrorTip = false;
    }, 3000);
  }

  // 表单提交
  submit() {
    let flag = true;
    // 验证密码是否一致
    const regex = /^1[3|4|5|8][0-9]\d{4,8}$/;
    if (this.password !== this.repeatPassword) {
      this.passwordIsIdentical = false;
      flag = false;
    }
    // 验证手机号
    if (!regex.test(this.phoneNumber) || this.phoneNumber.length < 11) {
      this.phoneIsCorrect = false;
      flag = false;
    }
    // 验证图片验证码
    if (this.imgNumber.toLowerCase() !== this.generatedImgNumber.toLowerCase()) {
      this.imgNumberIsCorrect = false;
      flag = false;
    }
    // 保存用户信息
    if (flag) {
      this.userService.register(this.userName, this.password, this.phoneNumber).subscribe((data) => {
        if (data['status'] === 1) {
          this.router.navigate(['/login']);
        } else {
          this.errorMessage = data['message'];
          this.showTip();
        }
      }, (err: HttpErrorResponse) => {
        this.handleError(err);
      });
    }
  }

}

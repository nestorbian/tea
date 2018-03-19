import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpEventType, HttpHeaders } from '@angular/common/http';
import { error } from 'util';
import { HttpErrorResponse } from '@angular/common/http/src/response';
import { HttpParams } from '@angular/common/http/src/params';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.scss']
})
export class UploadComponent implements OnInit {

  public file: File;

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  onSubmit() {
    const fd = new FormData();
    fd.append('file', this.file);
    const req = new HttpRequest('POST', 'http://localhost:8888/upload/file', fd, {
      reportProgress: true,
    });
    this.http.request(req).subscribe(event => {
      if (event.type === HttpEventType.UploadProgress) {
        const percentDone = Math.round(100 * event.loaded / event.total);
        console.log(`File is ${percentDone}% uploaded.`);
      } else if (event instanceof HttpResponse) {
        console.log('File is completely uploaded!');
      }
    });
    // this.http.post('http://localhost:8888/upload/file',  this.file)
    // .subscribe((data) => {
    //   console.log(data);
    // });
  }

  changeFile(event: any) {
    this.file = event.target.files[0];
  }
}

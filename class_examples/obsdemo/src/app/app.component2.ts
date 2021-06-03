import { Component } from '@angular/core';
import { observable, Observable, of } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'obsdemo';

  //obs$ = new Observable();
  obs$ = of(1,2,3,4,5);

  ngOnInit(){
    const sumObserver = {
      sum: 0,
      next(value:any) {
        console.log('Adding: ' + value);
        this.sum = this.sum + value;
      },
      error() {      
      },
      complete() {
        console.log('Sum equals: ' + this.sum);
      }
    };

      this.obs$.subscribe(sumObserver);

  }
}

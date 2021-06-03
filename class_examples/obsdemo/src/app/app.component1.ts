import { Component } from '@angular/core';
import { observable, Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'obsdemo';

  obs$ = new Observable();

  ngOnInit(){
    this.obs$ = Observable.create(
      (observer: { next: (arg0: number) => void; }) =>{
      observer.next(1);
      observer.next(2);
      observer.next(3);     

      });

      this.obs$.subscribe(
        value => console.log("value is ", value),
        err => {},
        () => console.log('this is the end.')
      );


  }
}

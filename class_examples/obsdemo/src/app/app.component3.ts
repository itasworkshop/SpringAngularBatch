import { Component } from '@angular/core';
import { observable, Observable, of, Subject } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'obsdemo';

  subject$:any;

  ngOnInit(){

    this.subject$ = new Subject();
    this.subject$.subscribe((x: any) =>
      console.log(x)
      );

    this.subject$.next("Jan Times");
    this.subject$.next("Feb Times");
    this.subject$.next("March Times");
   
    this.subject$.subscribe((x: any) =>
      console.log(x)
      );

     // this.subject$.unsubscribe();

     this.subject$.complete();
    this.subject$.next("April Times");
    this.subject$.next("May Times");
    this.subject$.next("June Times");
  }
}

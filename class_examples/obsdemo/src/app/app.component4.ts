import { Component } from '@angular/core';
import { BehaviorSubject, observable, Observable, of, Subject } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'obsdemo';

  subject$:any;

  ngOnInit(){

    this.subject$ = new BehaviorSubject(100);
    
    this.subject$.next("Jan Times");
    this.subject$.next("Feb Times");
    this.subject$.next("March Times");

    this.subject$.subscribe((x: any) =>
      console.log(x)
      );

   
    this.subject$.next("April Times");
    this.subject$.next("May Times");
    this.subject$.next("June Times");
  }
}

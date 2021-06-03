import { Component } from '@angular/core';
import { BehaviorSubject, interval, observable, Observable, of, ReplaySubject, Subject } from 'rxjs';
import {filter, take} from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'obsdemo';

  subject$:any;

  ngOnInit(){

    const numbers$ = interval(1000).pipe(
        take(10),
        filter((x) => x>3)
    );
   
    numbers$.subscribe(x => console.log(x));
  }
}



import { Component } from '@angular/core';
import { BehaviorSubject, interval, observable, Observable, of, ReplaySubject, Subject } from 'rxjs';
import {filter, map, mergeMap, take} from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'obsdemo';

  subject$:any;

  ngOnInit(){

    const numbers$ = interval(1000).pipe(take(5));
    const letters$ = of('a','b','c','d');

    letters$.pipe(mergeMap(x =>
       numbers$.pipe(take(5),map(i => i+x))
      )).subscribe(x => console.log(x));
   
    
  }
}



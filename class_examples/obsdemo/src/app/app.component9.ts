import { Component } from '@angular/core';
import { BehaviorSubject, interval, observable, Observable, of, ReplaySubject, Subject } from 'rxjs';
import {debounceTime, filter, map, mergeMap, switchMap, take} from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'obsdemo';

  name = 'Rajesh';

  searchString = '';

  searchSubject$ = new Subject<string>();

  ngOnInit(){    
   
    this.searchSubject$.pipe(debounceTime(200)).subscribe(x=>
          console.log('debounce: ',x));
    }   
   

  inputChanged($event: any) {
    console.log('input changed', $event);
    this.searchSubject$.next($event);
  }
}



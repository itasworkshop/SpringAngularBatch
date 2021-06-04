import { Component } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { BehaviorSubject, interval, observable, Observable, of, ReplaySubject, Subject } from 'rxjs';
import {debounceTime, distinctUntilChanged, filter, map, mergeMap, switchMap, take, tap} from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'obsdemo';

  name = "";

  searchString = '';

  searchSubject$ = new Subject<string>();

  results$: Observable<any> | any;

  constructor(private http:HttpClient){}

  ngOnInit(){    
   
    this.results$ = this.searchSubject$.pipe(
      debounceTime(500),
      distinctUntilChanged(),
      tap(x => console.log('do',x)),
      switchMap(searchString => this.queryAPI(this.searchString))
      );
        //this.results$.subscribe((x: any) =>console.log('result: ',x));
      }   
    

  queryAPI(searchString: string): any {
    console.log('quer API',searchString);    
    return this.http.get(`https://www.reddit.com/r/aww/search.json?q=${searchString}`)
    .pipe(map(result => (<any>result).data.children));
  }
   

  inputChanged($event: string | undefined) {
    console.log('input changed', $event);
    this.searchSubject$.next($event);
  }
}



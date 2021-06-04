import { Component } from '@angular/core';
import {Student} from './student';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'student-forms';

  grades = ['Good','Bad','Excellent'];

  model: Student = new Student(101,'Rajesh',this.grades[0],'Music');

  constructor() { }

 ngOnInit() {
 }

get diagnostic() { return JSON.stringify(this.model); }

newStudent() {
 this.model = new Student(42, '', '');
}
}

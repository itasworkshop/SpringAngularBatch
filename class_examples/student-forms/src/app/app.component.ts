import { Component } from '@angular/core';
import { Student } from './student';
import { FormGroup, FormControl, FormBuilder, Form } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'student-forms';

  grades = ['Good', 'Bad', 'Excellent'];

  model: Student = new Student(101, 'Rajesh', this.grades[0], 'Music');

  studentForm!: FormGroup;

  constructor(private fb:FormBuilder) { 
    this.createForm();
  }

  ngOnInit() {
  }

  createForm(){
    this.studentForm = this.fb.group({
        name: '',
        subject:[],
        grade:'Good'
    });
  }

  get diagnostic() { return JSON.stringify(this.model); }

  newStudent() {
    this.model = new Student(42, '', '');
  }

  onSubmit(value: any) {
    console.log(value);
    console.log("hello from form submit.", value.name, value.grade, value.optional);
  }

}

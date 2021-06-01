import { Component, Input, OnInit } from '@angular/core';
import { User } from '../app.component';

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {

  @Input() user?: User;
  

  constructor() { }

  ngOnInit(): void {
  }

}

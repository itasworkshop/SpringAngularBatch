import { Component } from '@angular/core';

export class User{
  fname:string;
  lname:string;
  marks:number;



  constructor(fname:string,lname:string,marks:number){
    this.fname = fname;
    this.lname = lname;
    this.marks = marks;
  }
}

@Component({
  selector: 'app-myroot',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'student-info';

  name = "rajesh";

  selectedUser= new User("","",0);

  user1:User = {fname:"rajesh",lname:"sharma",marks:23};
  user2:User = {fname:"raj",lname:"singh",marks:22};

  user3:User = {fname:"tom",lname:"tom",marks:50};

  user4:User = new User("anand","singh",56);


 users = [this.user1,this.user2,this.user3,this.user4];

 //users = null;

 flag1 = true;
 flag2 = false;

 counter = 0;

 counting(){
   this.counter++;
   
 }

 onSelect(user:User){
  this.selectedUser = user;
 }
}

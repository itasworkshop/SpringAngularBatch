/* function myfirst(person){
    return "Hello" + person;

} 

let user = "Rajesh";


function myfirst(person:string){
    return "Hello " + person;

} 
*/

/* interface Person{
    fName:string;
    lName:string;
}

function myfirst(person:Person){
    return "Hello " + person.fName + person.lName;

} 

//let user = ["Raj","John","Rajesh"];
let user = {fName: "Rajesh",lName:"Sharma"}
 */


class Student{
    fullName: string;

    constructor(public fName:string,public lName: string){
        this.fullName = fName + lName;
    }

}

let user = new Student("rajesh","sharma");

function myfirst(person:Student){
    return "Hello " + person.fName + person.lName;

} 

document.body.innerHTML = myfirst(user);

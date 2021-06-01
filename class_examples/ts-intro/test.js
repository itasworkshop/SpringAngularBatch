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
var Student = /** @class */ (function () {
    function Student(fName, lName) {
        this.fName = fName;
        this.lName = lName;
        this.fullName = fName + lName;
    }
    return Student;
}());
var user = new Student("rajesh", "sharma");
function myfirst(person) {
    return "Hello " + person.fName + person.lName;
}
document.body.innerHTML = myfirst(user);


//introduce the idea of functions that it's something that does something
//function then name of function then curly brackets
function up(){
  //initially use a console.log('') to prove button pressingn actually works
  //ask students what the button needs to do

  //subtask breakdown with students
  //get the current temperature
  //ask students to just memeorize document.getElementById
  //what's an ID?
  //how to assign new temperature?
  var currentTemp = Number(document.getElementById('temp').innerHTML);
  newTemp = currentTemp+1;
  document.getElementById('temp').innerHTML = newTemp;

  //how to link with button?
  //demonstrate button
}

function down(){
  //ask students to code this one on their own so they can try it--exactly the same as top
  //ask students to think about what will happen if I copy the code over?
  //purposeful mistake
  //what needs to be changed?
  var currentTemp = Number(document.getElementById('temp').innerHTML);
  newTemp = currentTemp-1;
  document.getElementById('temp').innerHTML = newTemp;
}

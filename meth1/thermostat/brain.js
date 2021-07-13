function up(){
  var currentTemp = Number(document.getElementById('temp').innerHTML);
  newTemp = currentTemp+1;
  document.getElementById('temp').innerHTML = newTemp;
}

function down(){
  var currentTemp = Number(document.getElementById('temp').innerHTML);
  newTemp = currentTemp-1;
  document.getElementById('temp').innerHTML = newTemp;
}

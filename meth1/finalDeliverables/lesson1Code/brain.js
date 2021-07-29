function getTixPrice(){
  var day = document.getElementById('dayDropDown').value;
  var age = document.getElementById('age').value;
  var discount = document.getElementById('coupon').value;
  if (day == 'mon' || age <=5 || age >=65 || discount=='TIX5'){
    document.getElementById('result').innerHTML = 'Price is $5';
  }
  else {
    document.getElementById('result').innerHTML = 'Price is $10';
  }
}

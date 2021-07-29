function getTixPrice(){
  var day = document.getElementById('dayDropDown').value;
  //what does document.getElementById() mean?
  //what goes in the parentheses?
  //where is that ID stated?
  var age = document.getElementById('age').value;
  //what does value mean?
  var discount = document.getElementById('coupon').value;
  //what am i accessing
  if (day == 'mon' || age <=5 || age >=65 || discount=='TIX5'){ //how does this conditional work? how else could i implement this?
    document.getElementById('result').innerHTML = 'Price is $5';
    //why did the innerHTML change from value?
  }
  else {
    document.getElementById('result').innerHTML = 'Price is $10';
  }
}

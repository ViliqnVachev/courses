function solve() {
  let text = document.querySelector('#text').value;
  let connvention = document.querySelector('#naming-convention').value;
  let result = '';
  let arrText = text.toLowerCase().split(' ');
  if (connvention == 'Camel Case') {

    result += arrText.shift();
    while (arrText.length > 0) {
      let tmp = arrText.shift();
      tmp = tmp.replace(tmp[0], tmp.charAt(0).toUpperCase());
      result += tmp;
    }
  } else if (connvention == 'Pascal Case') {
    while (arrText.length > 0) {
      let tmp = arrText.shift();
      tmp = tmp.replace(tmp[0], tmp.charAt(0).toUpperCase());
      result += tmp;
    }
  } else {
    result = 'Error!';
  }

  document.querySelector('#result').textContent = result;
}
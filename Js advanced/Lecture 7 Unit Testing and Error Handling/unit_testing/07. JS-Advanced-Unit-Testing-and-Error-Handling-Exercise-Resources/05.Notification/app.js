function notify(message) {
  let divElement = document.querySelector('#notification');
  divElement.style.display = 'block';
  divElement.textContent = message;
  divElement.addEventListener('click', hideMessageHandler);

  function hideMessageHandler(e) {
    e.target.style.display = 'none';
  }
}
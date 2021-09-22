function solve() {
  let divElements = Array.from(document.querySelectorAll('section div.answer-wrap'));
  for (const div of divElements) {
    div.addEventListener('click', selectAnswer);
  }
  let answersPoints = 0;
  let sectionIndex = 0;

  function selectAnswer(e) {
    let textContent = e.target.textContent;
    sectionIndex++;
    if (textContent == 'onclick' || textContent == 'JSON.stringify()' || textContent == 'A programming API for HTML and XML documents') {
      answersPoints++;
    }
    let currentSection = e.currentTarget.parentElement.parentElement.parentElement;
    currentSection.setAttribute('class', 'hidden');
    currentSection.style.display = 'none';
    let nextElement = currentSection.nextElementSibling;

    if (nextElement.tagName == 'SECTION') {
      nextElement.setAttribute('class', '');
      nextElement.style.display = 'block';
    }
    if (nextElement.tagName == 'UL') {
      nextElement.style.display = 'block';
      let h1Element = nextElement.querySelector('h1');
      let result = answersPoints == 3 ? 'You are recognized as top JavaScript fan!' : `You have ${answersPoints} right answers`;
      h1Element.textContent = result;
    }
    //e.currentTarget
    console.log(e.currentTarget.parentElement);
  }
}

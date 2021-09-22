function editElement(h1Element, match, newString) {
    const elementText = h1Element.textContent;
    const matcher = new RegExp(match, 'g');
    const edited = elementText.replace(matcher, newString);
    h1Element.textContent = edited;
}
function createElement(tag, attributes, ...params) {
    let elemenet = document.createElement(tag);
    let firstValue = params[0];
    if (params.length === 1 && typeof (firstValue) !== 'object') {
        if (['input', 'textarea'].includes(tag)) {
            elemenet.value = firstValue;
        } else {
            elemenet.textContent = firstValue;
        }

    } else {
        elemenet.append(...params);
    }
    if (attributes !== undefined) {
        Object.keys(attributes).forEach(key => {
            elemenet.setAttribute(key, attributes[key])
        })
    }
    return elemenet;
}

let htmlHelper = {
    createElement
}

export default htmlHelper;
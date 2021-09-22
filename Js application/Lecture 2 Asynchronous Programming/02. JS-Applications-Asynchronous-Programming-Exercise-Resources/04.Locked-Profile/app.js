function lockedProfile() {
    (async () => {
        let profileRequest = await fetch('http://localhost:3030/jsonstore/advanced/profiles');
        let profiles = await profileRequest.json();
        let section = document.querySelector('main');
         document.querySelector('.profile').remove();

        Object.keys(profiles).forEach((key, i) => {
            let profile = profiles[key];
            let html = createHtmlProfile(i + 1, profile.email, profile.username, profile.age);
            section.appendChild(html);
        })
    })();

    function createHtmlProfile(userIndex, email, username, age) {
        let div = document.createElement('div');
        div.classList.add('profile');

        let img = document.createElement('img')
        img.src = './iconProfile2.png';
        img.classList.add('userIcon');

        let lockLabel = document.createElement('label');
        lockLabel.textContent = 'Lock';

        let lockRadio = document.createElement('input');
        lockRadio.type = 'radio';
        lockRadio.name = `user${userIndex}Locked`;
        lockRadio.value = 'lock';
        lockRadio.checked = true;

        let unlockLabel = document.createElement('label');
        unlockLabel.textContent = 'Unlock';

        let unlockRadio = document.createElement('input');
        unlockRadio.type = 'radio';
        unlockRadio.name = `user${userIndex}Locked`;
        unlockRadio.value = 'unlock';

        let br = document.createElement('br');
        let hr = document.createElement('hr');

        let userLabel = document.createElement('label');
        userLabel.textContent = 'Username';

        let userInput = document.createElement('input');
        userInput.name = `user${userIndex}Username`;
        userInput.value = username;
        userInput.readOnly = true;
        userInput.disabled = true;

        let hiddenDiv = document.createElement('div');
        hiddenDiv.id = `user${userIndex}HiddenFields`;

        let hiddenFHr = document.createElement('hr');

        let emailLabel = document.createElement('label');
        emailLabel.textContent = 'Email:';

        let emailInput = document.createElement('input');
        emailInput.type = 'email';
        emailInput.name = `user${userIndex}Email`;
        emailInput.value = email;
        emailInput.readOnly = true;
        emailInput.disabled = true;

        let ageLabel = document.createElement('label');
        ageLabel.textContent = 'Age:';

        let ageInput = document.createElement('input');
        ageInput.type = 'email';
        ageInput.name = `user${userIndex}Age`;
        ageInput.value = age;
        ageInput.readOnly = true;
        ageInput.disabled = true;

        hiddenDiv.appendChild(hiddenFHr);
        hiddenDiv.appendChild(emailLabel);
        hiddenDiv.appendChild(emailInput);
        hiddenDiv.appendChild(ageLabel);
        hiddenDiv.appendChild(ageInput);

        let btn = document.createElement('button');
        btn.textContent = 'Show More';
        btn.addEventListener('click', showMore);
        div.appendChild(img);
        div.appendChild(lockLabel);
        div.appendChild(lockRadio);
        div.appendChild(unlockLabel);
        div.appendChild(unlockRadio);
        div.appendChild(br);
        div.appendChild(hr);
        div.appendChild(userLabel);
        div.appendChild(userInput);
        div.appendChild(hiddenDiv);
        div.appendChild(btn);

        return div;
    }

    function showMore(e) {
        let profile = e.target.parentElement;
        let btn = e.target;
        let hiddenDiv = e.target.previousElementSibling;
        let radio = profile.querySelector('input[type="radio"]:checked');

        if (radio.value != 'unlock') {
            return;
        }

        btn.textContent = btn.textContent == 'Show More' ? 'Hide it' : 'Show More';
        hiddenDiv.style.display = hiddenDiv.style.display === 'block' ? 'none' : 'block';
    }

}
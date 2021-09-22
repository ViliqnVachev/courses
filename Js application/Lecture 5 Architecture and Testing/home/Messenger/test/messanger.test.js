const { assert } = require('chai');
const { chromium } = require('playwright-chromium');

let url = 'http://localhost:3000';
let browser;
let page;

function fakeResponse(data) {
    return {
        status: 200,
        headers: {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
        },
        body: JSON.stringify(data)
    }

}
let mockResponseData = {
    1: {
        author: 'Viliyan',
        content: 'Test content Viliyan'
    },
    2: {
        author: 'Pesho',
        content: 'Test content Pesho'
    }
}

let createMessage = {
    3: {
        author: 'Gosho',
        content: 'Test content Gosho',
        _id: 3
    }
}

describe('messanger tests', function () {
    this.timeout(10000);

    before(async () => {
        browser = await chromium.launch({ headless: false, slowMo: 1000 });
    });

    beforeEach(async () => {
        page = await browser.newPage();
    })

    afterEach(async () => {
        await page.close;
    })

    after(async () => {
        browser.close();
    })
    describe('messanger get tests', function () {
        it('Should send a request when "Refresh" is clicked', async () => {
            await page.route('**/jsonstore/messenger', route => route.fulfill(fakeResponse(mockResponseData)));
            await page.goto(url);
            let [response] = await Promise.all([
                page.waitForResponse('**/jsonstore/messenger'),
                page.click('#refresh')
            ])
            let result = await response.json();

            assert.deepEqual(result, mockResponseData);
        })

        it('Should fill textArea when "Refresh" is clicked', async () => {
            await page.route('**/jsonstore/messenger', route => route.fulfill(fakeResponse(mockResponseData)));
            await page.goto(url);
            let [response] = await Promise.all([
                page.waitForResponse('**/jsonstore/messenger'),
                page.click('#refresh')
            ])
            let result = await response.json();
            let textAreaValue = await page.$eval('#messages', (textArea) => textArea.value);
            result = Object.values(result).map(v => `${v.author}: ${v.content}`).join('\n');

            assert.equal(result, textAreaValue);
        })

    })

    describe('messanger post tests', function () {
        it('Should create a message when "Send" is clicked', async () => {
            let requestData = undefined;
            let expected = {
                author: 'Misho',
                content: 'Misoooo'
            }
            await page.route('**/jsonstore/messenger', (route, request) => {
                if (request.method().toLowerCase() === 'post') {
                    requestData = request.postData();
                    route.fulfill(fakeResponse(createMessage))
                }
            });
            await page.goto(url);

            await page.fill('#author', expected.author);
            await page.fill('#content', expected.content);


            let [response] = await Promise.all([
                page.waitForResponse('**/jsonstore/messenger'),
                page.click('#submit')
            ])
            let result = JSON.parse(requestData);

            assert.deepEqual(result, expected);
        })

        it('Should clear the form when "Send" is clicked', async () => {
            let requestData = undefined;
            let expected = {
                author: 'Misho',
                content: 'Misoooo'
            }
            await page.route('**/jsonstore/messenger', (route, request) => {
                if (request.method().toLowerCase() === 'post') {
                    requestData = request.postData();
                    route.fulfill(fakeResponse(createMessage))
                }
            });
            await page.goto(url);

            await page.fill('#author', expected.author);
            await page.fill('#content', expected.content);


            let [response] = await Promise.all([
                page.waitForResponse('**/jsonstore/messenger'),
                page.click('#submit')
            ])
            let authorInputValue = await page.$eval('#author', input => input.value);
            let contentInputValue = await page.$eval('#content', input => input.value);
            let result = JSON.parse(requestData);

            assert.deepEqual(result, expected);
            assert.equal(authorInputValue, '');
            assert.equal(contentInputValue, '');
        })

    })



})
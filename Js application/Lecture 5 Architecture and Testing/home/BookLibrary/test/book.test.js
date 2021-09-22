const { assert } = require('chai');
const { chromium } = require('playwright-chromium');

let browser;
let page;
//http://localhost:3030/jsonstore/collections/books
let url = 'http://localhost:3000/'

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

let createBook = {
    3: {
        author: 'Stoyan',
        title: 'test',
        _id: 3
    }
}

let mockeData = {
    1: {
        author: 'Viliyan',
        title: 'Java'
    },
    2: {
        author: 'Vachev',
        title: 'Jenkins'
    },
}



describe('book tests', function () {
    this.timeout(10000);

    before(async () => {
        browser = await chromium.launch();
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
    describe('Test get request', () => {
        it('Should return data when load is clicked', async () => {
            await page.route('**/jsonstore/collections/books', route => route.fulfill(fakeResponse(mockeData)));

            await page.goto(url);

            let [response] = await Promise.all([
                page.waitForResponse('**/jsonstore/collections/books'),
                page.click('#loadBooks')
            ])

            let result = await response.json();

            assert.deepEqual(result, mockeData);

        })

        it('Should view data when load is clicked', async () => {
            await page.route('**/jsonstore/collections/books', route => route.fulfill(fakeResponse(mockeData)));

            await page.goto(url);

            let [response] = await Promise.all([
                page.waitForResponse('**/jsonstore/collections/books'),
                page.click('#loadBooks')
            ])

            let tBody = await page.$eval('tbody', tbody => Array.from(tbody.children));

            assert.equal(tBody.length, 2);

        })
    })

    describe('Test post request', () => {
        it('Should create a book when Submit is clicked', async () => {
            let requestData = undefined;
            let expectedBook = {
                author: 'Vachev',
                title: 'Fuck you'
            }
            await page.route('**/jsonstore/collections/books', (route, request) => {
                if (request.method().toLowerCase() === 'post') {
                    requestData = request.postData()
                    route.fulfill(fakeResponse(createBook));
                }
            });

            await page.goto(url);

            await page.fill('input[name="title"]', expectedBook.title);
            await page.fill('input[name="author"]', expectedBook.author);


            let [response] = await Promise.all([
                page.waitForResponse('**/jsonstore/collections/books'),
                page.click('text=Submit')
            ])
            let result = JSON.parse(requestData);

            assert.deepEqual(result, expectedBook);
        })

        it('Should clear the form when Submit is clicked', async () => {
            let requestData = undefined;
            let expectedBook = {
                author: 'Vachev',
                title: 'Fuck you'
            }
            await page.route('**/jsonstore/collections/books', (route, request) => {
                if (request.method().toLowerCase() === 'post') {
                    requestData = request.postData()
                    route.fulfill(fakeResponse(createBook));
                }
            });

            await page.goto(url);

            await page.fill('input[name="title"]', expectedBook.title);
            await page.fill('input[name="author"]', expectedBook.author);

            let [response] = await Promise.all([
                page.waitForResponse('**/jsonstore/collections/books'),
                page.click('text=Submit')
            ])
            let titeValue = await page.$eval('input[name="title"]', input => input.value);
            let authorValue = await page.$eval('input[name="author"]', input => input.value);
            assert.equal(titeValue, '');
            assert.equal(authorValue, '');
        })
    })

    describe('Test delete request', () => {
        it('Should delete a book when Delete is clicked', async () => {
            await page.route('**/jsonstore/collections/books', route => route.fulfill(fakeResponse(mockeData)));

            await page.goto(url);

            let [response] = await Promise.all([
                page.waitForResponse('**/jsonstore/collections/books'),
                page.click('#loadBooks')
            ])
            let message = undefined;
            const [request] = await Promise.all([
                page.waitForRequest('**/jsonstore/collections/books/' + '1'),
                page.click('text=Delete'),
                page.on('dialog', dialog => {
                    let message = dialog.message();
                    dialog.accept();
                    assert.equal(message, 'Are you sure you want to delete this book?')
                })
            ]);
        })
    })

    describe('Test put request', () => {
        it('Should load a book when Edit is clicked', async () => {
            let expectedBook = {
                author: 'Viliyan',
                title: 'Java'
            }
            await page.route('**/jsonstore/collections/books', route => route.fulfill(fakeResponse(mockeData)));

            await page.goto(url);

            let [response] = await Promise.all([
                page.waitForResponse('**/jsonstore/collections/books'),
                page.click('#loadBooks')
            ])

            await page.route('**/jsonstore/collections/books/' + '1', (route, request) => {
                route.fulfill(fakeResponse(expectedBook))
            });

            const [request] = await Promise.all([
                page.waitForRequest('**/jsonstore/collections/books/' + '1'),
                page.click('text=Edit'),
            ]);

            let titeValue = await page.$eval('#editForm input[name="title"]', input => input.value);
            let authorValue = await page.$eval('#editForm input[name="author"]', input => input.value);
            assert.equal(titeValue, expectedBook.title);
            assert.equal(authorValue, expectedBook.author);
        })

        it('Should edit a book when Edit is clicked', async () => {
            let expectedBook = {
                author: 'Viliyan',
                title: 'Java'
            }
            let requestData = undefined;
            await page.route('**/jsonstore/collections/books', route => route.fulfill(fakeResponse(mockeData)));

            await page.goto(url);

            let [response] = await Promise.all([
                page.waitForResponse('**/jsonstore/collections/books'),
                page.click('#loadBooks')
            ])

            await page.route('**/jsonstore/collections/books/' + '1', (route, request) => {
                route.fulfill(fakeResponse(expectedBook))
            });

            const [request] = await Promise.all([
                page.waitForRequest('**/jsonstore/collections/books/' + '1'),
                page.click('text=Edit'),
            ]);

            await page.route('**/jsonstore/collections/books/' + '1', (route, request) => {
                if (request.method().toLowerCase() === 'put') {
                    requestData = request
                    route.fulfill(fakeResponse(expectedBook));
                }
            });

            const [request2] = await Promise.all([
                page.waitForRequest('**/jsonstore/collections/books/' + '1'),
                page.click('text=Save'),
            ]);
            
        })
    })

})
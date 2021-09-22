const { assert } = require('chai');
const { chromium } = require('playwright-chromium');

let browser;
let page;

describe('acordeion tests', function () {
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

    it('Shoul load forms', async () => {
        await page.goto('http://localhost:3000/');
        let curTitles = await page.evaluate(() => {
            let spanElements = document.querySelectorAll('div.head span');
            return Array.from(spanElements).map(e => e.textContent);
        })
        let expected = ['Scalable Vector Graphics', 'Open standard', 'Unix', 'ALGOL'];

        assert.deepEqual(curTitles, expected);
    })

    it('Should change button Name', async () => {
        await page.goto('http://localhost:3000/');
        await page.click('text="More"');
        let div = await page.evaluate(() => {
            return document.querySelector('div.extra').style.display;
        });
        let btnText = await page.evaluate(() => {
            return document.querySelector('button').textContent;
        });
       
        assert.equal(div, 'block');
        assert.equal(btnText, 'Less');
    })

    it('Should change button Name', async () => {
        await page.goto('http://localhost:3000/');
        await page.click('text="More"');

        let divBlock = await page.evaluate(() => {
            return document.querySelector('div.extra').style.display;
        });
        let btnLess = await page.evaluate(() => {
            return document.querySelector('button').textContent;
        });
       
        assert.equal(divBlock, 'block');
        assert.equal(btnLess, 'Less');

        await page.click('text="Less"');

        let div = await page.evaluate(() => {
            return document.querySelector('div.extra').style.display;
        });
        let btnText = await page.evaluate(() => {
            return document.querySelector('button').textContent;
        });
       
        assert.equal(div, 'none');
        assert.equal(btnText, 'More');

    })
})
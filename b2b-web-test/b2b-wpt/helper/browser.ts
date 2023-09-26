import puppeteer from 'puppeteer';

 export class InvokeBrowser {


 async launchBrowser(): Promise<puppeteer.Browser> {
  
  const browser = await puppeteer.launch({
    headless: false,
    args: ['--start-fullscreen']
  });

    return browser;

  }

  

  }
  


  


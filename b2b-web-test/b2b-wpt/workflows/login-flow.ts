import dataContent from "../resources/data.json";
import { startFlow } from 'lighthouse/lighthouse-core/fraggle-rock/api.js';
import puppeteer, { Browser, ElementHandle } from 'puppeteer'
export class LightHouseFlow {

  async auditSiteFlow(getbrowser: puppeteer.Browser): Promise<any> {

    let urls = await this.getUrls();

    const config = require('../config/custom_config.js');
    const testSource: {}[] =urls;
    const browser = getbrowser;
    const page = await browser.newPage();
    
    const flow = await startFlow(page,{name: 'Dukkan Sennin - Login Flow',config});
     await flow.navigate(testSource[0]["url"], {
      stepName: 'Welcome Page'
    });

    await flow.snapshot({stepName: 'Login Page'});
    await page.waitForSelector('#phoneNumber');
    
    await flow.startTimespan({stepName: 'Provide Credentials'});
    await page.type('#phoneNumber','5465520809');
    await page.type('#password','Test@123');
    await page.click('#btnSignIn');
    await flow.endTimespan();

    await page.waitForSelector('#navigation');
    await flow.snapshot({stepName: 'Home Page Transition'});
    
    await flow.navigate(testSource[1]["url"], {
      stepName: 'Home Page'
    });
    
    return {flow,page};
      
  }

  async getUrls(): Promise<{}[]> {
    return dataContent.APP_NAME;
  }
  
  
} 



import { Reports } from "./helper/reporting";
import { InvokeBrowser } from "./helper/browser";
import { LightHouseFlow } from "./workflows/login-flow";



let invokebrowser = new InvokeBrowser();
let lightflow = new LightHouseFlow();
let reports =  new Reports();


(async () => {

    await reports.setup();

    const browser = await invokebrowser.launchBrowser();
    const siteflow = await lightflow.auditSiteFlow(browser);
    await browser.close();
    await reports.generateLighthouseReport(await siteflow.flow.generateReport());

})();



import { join } from "path";

import { writeFileSync, mkdirSync, existsSync} from "fs";

export class Reports  {

  currentDateTime = new Date().toISOString().replace(':','-').replace(':','-').replace('.','-');

  reportFolder = join(process.cwd(), `reports/${this.currentDateTime}`);

  async setup(): Promise<void> {

    await this.makeReportDirectory();

  }

  async makeReportDirectory(): Promise<void> {

    try {

      if (!(await existsSync(`${this.reportFolder}`))) {

        await mkdirSync(`${this.reportFolder}`);

      }

    } catch (err) {

      console.error(err);

    }

  }

  async generateLighthouseReport( data1: string | NodeJS.ArrayBufferView): Promise<void> {

  await writeFileSync(`${this.reportFolder}/${"btbweb-audit"}.html`, data1);
  
  }

}
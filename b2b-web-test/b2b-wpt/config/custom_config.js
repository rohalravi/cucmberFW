module.exports = {
  extends: 'lighthouse:default',
  settings: {

    onlyCategories: ['performance'],

    onlyAudits: [
      'first-contentful-paint',
      'speed-index',
      'interactive',
      'largest-contentful-paint',
      'total-blocking-time'
    ],

    screenEmulation: {
      mobile: true,
      width: 1024,
      height: 768,
      deviceScaleFactor: 1,
      disabled: false,
    },
    formFactor: 'mobile',
    throttlingMethod: 'simulate',
    locale: 'en-US',
    channel: 'node_test',
    throttling: {
      rttms: 150,
      throughputKbps: 1.6 * 1024,
      downloadThroughputKbps: 768000,
      uploadThroughputKbps: 200000,
      cpuSlowdownMultiplier: 1,

    },

  },

};
/* global myData */

'use strict';

var vcardData = [
  'BEGIN:VCARD',
  'VERSION:3.0',
  'FN:' + [ myData.name, myData.surname].join(' '),
  'N:' + [ myData.surname, myData.name, '', '', ''].join(';'),
  'EMAIL;TYPE=INTERNET;TYPE=WORK:' + myData.email,
  'TEL;TYPE=WORK:' + myData.mobile,
  'ORG:Freelancer',
  'TITLE:Software Developer',
  'item1.URL:' + myData.webSiteUrl,
  'item1.X-ABLabel:_$!<HomePage>!$_',
  'item2.URL:' + 'https\\://www.linkedin.com/in/'+myData.linkedInNickName,
  'item2.X-ABLabel:LinkedIn',
  'item3.URL:' + 'https\\://github.com/'+myData.gitHubNickName,
  'item3.X-ABLabel:GitHub',
  'NOTE:VAT: ' + myData.vatCode,
  'END:VCARD'
].join('\n');

document.getElementById('vcard').onclick = function () {
    this.href = 'data:text/plain;charset=utf-8,' + encodeURIComponent(vcardData);
};

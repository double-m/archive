/* global before, describe, it, require, arraymultiplier, __dirname */

'use strict';

var fs = require('fs')
  , vm = require('vm')
  , chai = require('chai')
  , Browser = require('zombie')
  , expect = chai.expect;

var arraymultiplierBuf = fs.readFileSync(__dirname + '/../../app/scripts/arraymultiplier.js')
  , arraymultiplierScript = arraymultiplierBuf.toString()
    .replace(/\/*.*\//g, '')
    .replace(/\n/g, '')
  , evaluateArraymultiplierScript = new vm.Script(arraymultiplierScript);
evaluateArraymultiplierScript.runInThisContext();

describe('Scripts', function () {
  it('returns the product of three array items', function () {
    expect(arraymultiplier([1, 2, 3])).to.equal(6);
  });
});

describe('Headless A-B tests', function () {
  var browser = new Browser({site: 'http://localhost:9001'});

  before(function (done) {
    browser.visit('/', done);
  });

  it('should find h1 children', function () {
    expect(browser.text('h1 span[data-bind=name]')).to.equal('Name');
    expect(browser.text('h1 span[data-bind=surname]')).to.equal('Surname');
  });

  it('should find one of the fontawesome icons', function () {
    browser.assert.hasClass('a[data-bind=emailAddr] i', 'fa');
  });
});

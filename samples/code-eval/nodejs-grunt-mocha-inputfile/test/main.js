var expect = require('chai').expect
  , processLine = require('../lib/app.js').processLine;

describe('Challenge test suite', function() {

  describe('functional tests', function() {

    it('should produce the output samples reported in the challenge description', function() {
      expect(processLine('Hello World!')).to.equal('Hello World!');
      expect(processLine('Hello CodeEval!')).to.equal('Hello CodeEval!');
    });

  });

  describe('unit tests', function() {

  });

});


var expect = require('chai').expect
  , challenge = require('../lib/challenge').challenge;

describe('Challenge test suite', function() {

  describe('functional tests', function() {

    it('should produce the output samples reported in the challenge description', function() {
      expect(challenge("Hello World!")).to.equal("Hello World!");
    });

  });

  describe('unit tests', function() {

  });

});


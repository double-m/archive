/* exported arraymultiplier */

'use strict';

function arraymultiplier(factors) {
  var mul = 1;

  for (var i=0; i<factors.length; i++) {
    mul = mul * factors[i];
  }

  return mul;
}

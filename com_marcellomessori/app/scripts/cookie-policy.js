'use strict';

$( '#cookie-policy-button' ).click(function (e) {
  e.preventDefault();
  if ( $( '#cookie-policy-description' ).is( ':hidden' ) ) {
    $( '#cookie-policy-description' ).show( 'slow' );
  } else {
    $( '#cookie-policy-description' ).hide( 'slow' );
  }
});
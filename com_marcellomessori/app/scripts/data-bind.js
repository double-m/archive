/* global myData */
/* export myDisplayData */

'use strict';

var myDisplayData = {
  browserTitle: myData.browserTitle,
  name: myData.name,
  surname: myData.surname,
  emailAddr: { href: 'mailto:'+myData.email, html: myData.email },
  mobileNum: { href: 'tel:'+myData.mobile, html: myData.mobile },
  locationLink: { href: myData.locationLink, html: myData.locationText },
  vatCode: myData.vatCode,
  codeEvalUrl: { href: 'https://www.codeeval.com/profile/'+myData.codeEvalNickName, html: myData.codeEvalNickName },
  gitHubUrl: { href: 'https://github.com/'+myData.gitHubNickName, html: myData.gitHubNickName },
  linkedInUrl: { href: 'https://www.linkedin.com/in/'+myData.linkedInNickName, html: myData.linkedInNickName },
  webSiteUrl: { href: 'http://www.'+myData.webSiteUrl, html: myData.webSiteUrl }
};

function dataBind(data) {
  $('title').html(data.browserTitle);

  $('[data-bind]').each(function(){
    var itemToFill = $(this)
      , bindAttribute = itemToFill.attr('data-bind')
      , strToReplace = bindAttribute.toString();
    
    if(data[strToReplace].href !== undefined) {
      itemToFill
        .attr('href', data[strToReplace].href)
        .children('span').html(data[strToReplace].html);
    } else if (itemToFill.children('span').length === 1) {
      itemToFill.children('span').html(data[strToReplace]);
    } else {
      itemToFill.html(data[strToReplace]);
    }
  });
}

function populateLanguageSelector() {
  $('.lang-selector').html(
    $('<div class="left" id="it">').html(
      $('<a>')
        .text('ita')
        .attr('href', '')
      )
    ).append(
      $('<div class="right" id="en">').html(
        $('<a>')
        .text('eng')
        .attr('href', '')
    )
  );
  $('.lang-selector > div > a')
    .prepend('<i class="fa fa-angle-right">')
    .append('<i class="fa fa-angle-left">');

  function selectLanguage(id) {
    $('#'+id).children('a')
      .addClass('active')
      .removeClass('disabled')
      .removeAttr('href')
      .children('i.fa').show();
    $('#'+id).siblings().children('a')
      .addClass('disabled')
      .removeClass('active')
      .attr('href', '')
      .children('i.fa').hide();
  }
  
  var activeId = $.i18n.options.lng.substr(0,2).toLowerCase() === 'it' ? 'it' : 'en';
  selectLanguage(activeId);
  
  $('.lang-selector > div > a').click(function(e) {
    e.preventDefault();
    
    var lang = $(this).parent().attr('id')
      , locale = [lang, lang.toUpperCase()].join('-');

    selectLanguage(lang);
    $('[data-i18n]').i18n({ lng: locale });
  });
}

$('document').ready(function(){
  $.i18n.init({ fallbackLng: 'en-EN' }, function () {
    $('[data-i18n]').i18n();
  });

  dataBind(myDisplayData);
  populateLanguageSelector();
});

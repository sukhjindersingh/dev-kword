// (C) TEQneers GmbH & Co. KG
// Made by Stephan Ferraro, 2012 Stuttgart, Germany
// E-Mail: support {at} teqneers.de

var currentIPList	= {};

// Save all IP addresses by URLs in a temporary object
chrome.webRequest.onCompleted.addListener(
  function(info) {
	  currentIPList[ info.url ] = info.ip;
    return;
  },
  {
    urls: [],
    types: []
  },
  []
);

// Called by ip.js
chrome.extension.onRequest.addListener(
	function(request, sender, sendResponse)
	{
		var currentURL = sender.tab.url;
		if ( currentIPList[ currentURL ] !== undefined ) {
			sendResponse( {
				domainToIP: currentIPList[ currentURL ]
			} );
		} else {
			// IP not found in array (maybe an iframe has been loaded).
			sendResponse( {
				domainToIP: null
			} );
		}

		// Reset temporary object
		currentIPList	= {};
	}
);
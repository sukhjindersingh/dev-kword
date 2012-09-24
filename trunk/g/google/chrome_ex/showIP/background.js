//show ip and address by city type
// (C) kick.smiles@gmail.com @jeskick
// Made by stp freeen, 2012 sun 10.
// E-Mail: kick.smiles@gmail.com

var currentIPList	= {};

// Save all IP addresses by URLs in a object
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
			// IP not found in array
			sendResponse( {
				domainToIP: null
			} );
		}

		// Reset  object
		currentIPList	= {};
	}
);
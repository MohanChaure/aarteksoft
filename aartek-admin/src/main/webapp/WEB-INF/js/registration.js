function num(evt, e) {
	var keyCode = evt.keyCode;
	if (keyCode < 37 || keyCode > 40) {
		e.value = e.value.replace(/[^0-9+-]+/g, '');
	}
	return false;
}
function Alphabets(nkey) {
	var keyval
	if (navigator.appName == "Microsoft Internet Explorer") {
		keyval = window.event.keyCode;
	} else if (navigator.appName == 'Netscape') {
		nkeycode = nkey.which;
		keyval = nkeycode;
	}
	// For A-Z
	if (keyval >= 65 && keyval <= 90) {
		return true;
	}
	// For a-z
	else if (keyval >= 97 && keyval <= 122) {
		return true;
	}
	// For Backspace
	else if (keyval == 8) {
		return true;
	}
	// For General
	else if (keyval == 0) {
		return true;
	}
	// For Space
	else if (keyval == 32) {
		return true;
	} else {
		return false;
	}
}// End of the function
function onlyNos(e, t) {
	try {
		if (window.event) {
			var charCode = window.event.keyCode;
		} else if (e) {
			var charCode = e.which;
		} else {
			return true;
		}
		if (charCode > 31 && (charCode < 48 || charCode > 57)) {
			return false;
		}
		return true;
	} catch (err) {
		alert(err.Description);
	}
}
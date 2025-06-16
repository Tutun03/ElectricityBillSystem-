/**
 * 
 */
function resetfunction(formid){
	const form = document.getElementById("registerForm");
	const resetButton = form.querySelector("input[type='reset']");
	resetButton.addEventListener("click", () => {
		
		form.reset();
	})
	return true;
}

function validateForm(formId) {
const form = document.getElementById(formId);

const consumerId = document.getElementById("consumerId").value.trim();
const billNumber = document.getElementById("billNumber").value.trim();
const mobileNo = document.getElementById("mobileNo").value.trim();
const password = document.getElementById("password").value;
const confirmPassword = document.getElementById("confirmPassword").value;
if(consumerId.toString().length<13)
	{
	alert("Consumer Id is less than 13 digits");
	return false;
	}

if (!consumerId || !billNumber || !mobileNo || !password || !confirmPassword) {
    alert("Please fill all required fields.");
    return false;
}

if (billNumber !== consumerId.slice(-5)) {
    alert("Bill number must match the last 5 digits of the Consumer ID.");
    return false;
}

// if (mobileNo.length !== 10 || !/^[0-9]+$/.test(mobileNo)) {
// alert("Mobile number must be 10 digits.");
// return false;
// }
//validateMobile()

if (password !== confirmPassword) {
    alert("Passwords do not match.");
    return false;
}
const patternPassword = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\S+$).{8,20}$/
	console.log(patternPassword.test(password.toString()))
if (!patternPassword.test(password)) {
	alert("Password Must contain at least 1 uppercase, 1 lowercase, 1 digit, 1 special character, and be 8+ characters long");
    return false;
}
return true;


}

function validateMobile() {
	const code = document.getElementById("countryCode").value;
	const mobile = document.getElementById("mobileNo").value;
	const error = document.getElementById("mobileError");
	let isValid = false;

	switch (code) {
	    case "+91":
	        isValid = /^\\d{10}$/.test(mobile);
	        break;
	    case "+1":
	        isValid = /^\\d{7}$/.test(mobile);
	        break;
	    case "+44":
	        isValid = /^\\d{10}$/.test(mobile); // adjust based on UK rules
	        break;
	    // Add more cases as needed
	}

	if (!isValid) {
		alert("Invalid mobile number for "+ code)
		return false
	} 

	}


function printDiv() {
    let divContents = document.getElementById("payment-container").innerHTML;
    let printWindow = window.open('', '', 'height=800, width=1200');
    printWindow.document.open();
    printWindow.document.write(`
        <html>
        <head>
        </head>
        <body>
            ${divContents}
        </body>
        </html>
    `);
    printWindow.document.close();
    printWindow.print();
}
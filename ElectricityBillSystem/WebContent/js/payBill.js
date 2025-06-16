function showSection(id){
	document.getElementByID("addBill").style.display = "none";
	document.getElementByID("payBill").style.display = "none";
	document.getElementByID(id).style.display = "block";
}
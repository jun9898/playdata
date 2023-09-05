/**
 * 
 */
 let idInputVal = document.querySelector("#exampleInputEmail1");
 let loginmodal = document.querySelector("#exampleModal");
 
 loginmodal.addEventListener("shown.bs.modal", function(){
	alert("test")
	idInputVal.focus();
})
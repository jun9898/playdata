/**
 * 
 */
 
 let divobj1 = document.querySelector(".mybox");
 // dom객체에 이벤트 연결하기
 // 객체.addEventListener("이벤트명",이벤트가 발생할때 실행할 함수)
 divobj1.addEventListener("click",function() {
	divobj1.style.backgroundColor = "red"
	divobj1.style.color = "blue"
	alert("이벤트 발생됨~~~")
	divobj1.classList.add("active")
	console.log(divobj1.classList.contains("active"))
	divobj1.classList.remove("active")
	console.log(divobj1.classList.contains("active"))
	console.log(divobj1.textContent) // getter
	divobj1.textContent = "hello dom" // setter
});
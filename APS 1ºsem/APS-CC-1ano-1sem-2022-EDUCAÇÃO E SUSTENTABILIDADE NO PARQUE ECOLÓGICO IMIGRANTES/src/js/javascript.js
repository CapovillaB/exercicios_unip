window.addEventListener("load", function(){
	const outImage = document.getElementById("outImage"),
	btAnterior = document.getElementById("btAnterior"),
	btProximo = document.getElementById("btProximo");
	var image = 0;
		outImage.src = "../src/images/" + image + ".jpg";
	btAnterior.addEventListener("click", () => {
		if (image > 0) {
			image--;
			outImage.src = "../src/images/" + image + ".jpg";
		}
	});
	btProximo.addEventListener("click", () => {
		if (image < 41) {
			image++;
			outImage.src = "../src/images/" + image + ".jpg";
		}
	});
});
<?php
try {
	if (isset($_POST["mensagem"])) {
		$mensagem = htmlspecialchars($_POST["mensagem"], ENT_QUOTES, "UTF-8");
		if ($_POST["mensagem"] != NULL) {
			$mensagem = wordwrap($mensagem, 70, "\r\n");
			mail("contato@fkm.org.br","Contato sobre o parque",$mensagem);
		}
	}
} catch (PDOException $e) {
	echo "ERROR: " . $e->getMessage();
}
?>
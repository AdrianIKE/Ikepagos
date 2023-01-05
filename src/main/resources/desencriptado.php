<!DOCTYPE html>
<html>
<body>

<?php
  $ciphertext_b64 = "";
  $plaintext = "2570Pago123";
  $password = "Ik34slst3ncl4Pnt0cOm2712";
  $salt = "Ik34slst3ncl4Pnt0cOm0troLado9805";
  $iv = "ikeasistencia222";
  $iterations = 65536;
  $keyLength = 32;

  $prepared_key = openssl_pbkdf2($password, $salt, $keyLength, $iterations, "sha512");
	
  $ciphertext_b64 = base64_encode(openssl_encrypt($plaintext,"AES-256-CBC", $prepared_key,OPENSSL_RAW_DATA, $iv));
  echo $ciphertext_b64 . "<br/>";

  $plaintext = openssl_decrypt(base64_decode($ciphertext_b64),"AES-256-CBC", $prepared_key,OPENSSL_RAW_DATA, $iv);
  echo $plaintext . "<br/>";
?>

</body>
</html>

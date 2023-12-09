<?php
    $koneksi = mysqli_connect("localhost", "root", "", "dbImpal") or die("Gagal Koneksi Database");
    $idPesan = $_GET['idPesan'];
    $query = "delete from Pesan where idPesan='$idPesan'";
    $sql = mysqli_query($koneksi, $query) or die("Gagal query:" . $query);
    header("location:tampilPesan.php");
?>
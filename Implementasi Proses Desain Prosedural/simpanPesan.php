<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $idPesan = $_POST['idPesan'];
    $idPenerima = $_POST['idPenerima'];
    $idPengirim = $_POST['idPengirim'];
    $Judul = $_POST['Judul'];
    $TextPesan = $_POST['TextPesan'];
    $WaktuPesan = date('Y-m-d H:i:s');

    $conn = mysqli_connect("localhost", "root", "", "dbImpal");
    $sql = "INSERT INTO pesan VALUES ('$idPesan','$idPenerima','$idPengirim','$Judul','$TextPesan','$WaktuPesan')";
    
    if ($res = mysqli_query($conn, $sql)) {
        header("Location: tampilPesan.php");
    } else {
        echo "Pesan gagal ditambahkan: " . mysqli_error($conn);
    }

    mysqli_close($conn);
}


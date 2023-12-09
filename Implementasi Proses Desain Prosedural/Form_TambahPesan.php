<!DOCTYPE html>
<html>
<head>
    <title>Tambah Pesan</title>
</head>
<body>
    <h1>INPUT DATA</h1>
    <form action="SimpanPesan.php" method="post">
        <!-- diasumsikan idPengirim = id user login, didapatkan dari session dan idpesan auto_increment dan tanggal adalah tanggal saat ini sehingga tidak perlu input -->
        <table>
            <tr> 
                <td>idPesan</td>
                <td><input type="text" name="idPesan" ></td>
            </tr>
            <tr> 
                <td>idPenerima</td>
                <td><input type="text" name="idPenerima" ></td>
            </tr>
            <tr> 
                <td>idPengirim</td>
                <td><input type="text" name="idPengirim" ></td>
            </tr>
            <tr> 
                <td>Judul</td>
                <td><input type="text" name="Judul" ></td>
            </tr>
            <tr> 
                <td>Text Pesan</td>
                <td><textarea name="TextPesan" ></textarea></td>
            </tr>
            <tr> 
                <td>Waktu Pesan</td>
                <td><input type="Date" name="WktPesan" ></td>
            </tr>
            <tr> 
                <td></td>
                <td><input type="submit" name="submit" value="Simpan"></td>
            </tr>
        
        </table>

    </form>
</body>
</html>

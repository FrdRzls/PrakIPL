<?php
$koneksi = mysqli_connect("localhost", "root", "", "dbImpal") or die("Gagal koneksi database");
    ?>
<html>

<body>
    <h1>
        <center>Daftar Pesan</center>
    </h1>
    <table border="3" align="center">
        <tr>
            <th>Id Pesan</th>
            <th>Id Penerima</th>
            <th>Id Pengirim</th>
            <th>Judul</th>
            <th>Text Pesan</th>
            <th>Waktu Pesan</th>
            <th>Keterangan</th>
        </tr>
        <?php
        $query = "select * from Pesan";
        $data = mysqli_query($koneksi, $query) or die("Gagal query:" . $query);
        ?>
        <?php while ($v = mysqli_fetch_array($data)):
            ; ?>
            <tr>
                <td>
                    <?php echo $v['idPesan']; ?>
                </td>
                <td>
                    <?php echo $v['idPenerima']; ?>
                </td>
                <td>
                    <?php echo $v['idPengirim']; ?>
                </td>
                <td>
                    <?php echo $v['Judul']; ?>
                </td>
                <td>
                    <?php echo $v['TextPesan']; ?>
                </td>
                <td>
                    <?php echo $v['WaktuPesan']; ?>
                </td>
                <td><a href="Form_TambahPesan.php?idPesan=<?php echo $v['idPesan']; ?>">Tambah</a>
                    <a href="hapusPesan.php?idPesan=<?php echo $v['idPesan']; ?>">Hapus</a>

                </td>
            </tr>
        <?php endwhile; ?>
    </table>
</body>

</html>
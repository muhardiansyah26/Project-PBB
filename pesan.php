<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['teamname']) && isset($_POST['username']) && isset($_POST['lapangan']) && isset($_POST['tanggal']) && isset($_POST['jam'])) {
    if ($db->dbConnect()) {
        if ($db->pesan("pemesanan", $_POST['teamname'], $_POST['username'], $_POST['lapangan'], $_POST['tanggal'], $_POST['jam'])) {
            echo "Pemesanan Berhasil";
        } else echo "Pemesanan Gagal";
    } else echo "Error: Database connection";
} else echo "All fields are required";
?>

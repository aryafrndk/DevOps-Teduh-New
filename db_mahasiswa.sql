-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 03 Nov 2024 pada 05.53
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_mahasiswa`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_mahasiswa`
--

CREATE TABLE `tb_mahasiswa` (
  `nim` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `jenis_kelamin` varchar(50) NOT NULL,
  `kelas` varchar(50) NOT NULL,
  `prodi` varchar(100) NOT NULL,
  `fakultas` varchar(100) NOT NULL,
  `angkatan` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tb_mahasiswa`
--

INSERT INTO `tb_mahasiswa` (`nim`, `nama`, `jenis_kelamin`, `kelas`, `prodi`, `fakultas`, `angkatan`) VALUES
(1302210025, 'Tangguh Laksana', 'Laki-Laki', 'se4501', ' S1RPL', ' FIF', ' 2021'),
(1302210063, 'Fathur Rahman', 'Laki-Laki', 'se4501', ' S1 RPL', ' FIF', ' 2021'),
(1302210093, 'Ghaza Solihin', 'Laki-Laki', 'se4501', ' S1 RPL', ' FIF', ' 2021'),
(1302210096, 'Arzaq Ajradika', 'Laki-Laki', 'se4501', ' S1RPL', ' FIF', ' 2021'),
(1302213108, 'Yesa Sihombing', 'Laki-Laki', 'se4501', 'S1 RPL', 'FIF', '2021');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_registrasi`
--

CREATE TABLE `tb_registrasi` (
  `nama_depan` varchar(30) NOT NULL,
  `nama_belakang` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tb_registrasi`
--

INSERT INTO `tb_registrasi` (`nama_depan`, `nama_belakang`, `email`, `username`, `password`) VALUES
('mail', 'ismet', 'mail@gmail.com', 'mails', 'mails');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tb_mahasiswa`
--
ALTER TABLE `tb_mahasiswa`
  ADD PRIMARY KEY (`nim`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

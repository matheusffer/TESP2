-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 29-Abr-2015 às 00:10
-- Versão do servidor: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `escola`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `hibernate_sequence`
--

CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `member`
--

CREATE TABLE IF NOT EXISTS `member` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(25) NOT NULL,
  `phone_number` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `member`
--

INSERT INTO `member` (`id`, `email`, `name`, `phone_number`) VALUES
(0, 'john.smith@mailinator.com', 'John Smith', '2125551212');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_aluno`
--

CREATE TABLE IF NOT EXISTS `tb_aluno` (
  `dataAniversairo` date NOT NULL,
  `matricula` bigint(20) NOT NULL,
  `id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_pessoa`
--

CREATE TABLE IF NOT EXISTS `tb_pessoa` (
  `id` bigint(20) NOT NULL,
  `cpf` varchar(255) NOT NULL,
  `nome` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tb_pessoa`
--

INSERT INTO `tb_pessoa` (`id`, `cpf`, `nome`) VALUES
(1, '113113479', 'Matheus Fernandes');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_professor`
--

CREATE TABLE IF NOT EXISTS `tb_professor` (
  `salario` decimal(10,2) NOT NULL,
  `id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `member`
--
ALTER TABLE `member`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `UK_9qv6yhjqm8iafto8qk452gx8h` (`email`);

--
-- Indexes for table `tb_aluno`
--
ALTER TABLE `tb_aluno`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `UK_7qp4rbvequxsx7ke5cbt9m67y` (`matricula`), ADD KEY `FK_dukjmeukwfsm0mpbfrpgcykr` (`id`);

--
-- Indexes for table `tb_pessoa`
--
ALTER TABLE `tb_pessoa`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `UK_5yk299a77740w681hxx04j7b3` (`cpf`);

--
-- Indexes for table `tb_professor`
--
ALTER TABLE `tb_professor`
 ADD PRIMARY KEY (`id`), ADD KEY `FK_ol2cjgwcp0r1jfnwyscvu38sg` (`id`);

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `tb_aluno`
--
ALTER TABLE `tb_aluno`
ADD CONSTRAINT `FK_dukjmeukwfsm0mpbfrpgcykr` FOREIGN KEY (`id`) REFERENCES `tb_pessoa` (`id`);

--
-- Limitadores para a tabela `tb_professor`
--
ALTER TABLE `tb_professor`
ADD CONSTRAINT `FK_ol2cjgwcp0r1jfnwyscvu38sg` FOREIGN KEY (`id`) REFERENCES `tb_pessoa` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

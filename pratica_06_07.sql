-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 06/07/2026 às 20:51
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `pratica_06-07`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `clientes`
--

CREATE TABLE `clientes` (
  `nome_cliente` varchar(250) NOT NULL,
  `id_cpf_cliente` tinyint(11) NOT NULL,
  `nascimento_cliente` date NOT NULL,
  `endereco_cliente` varchar(200) NOT NULL,
  `telefone_cliente` tinyint(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `nome_funcionario` varchar(250) NOT NULL,
  `id_cpf_funcionario` tinyint(11) NOT NULL,
  `nascimento_funcionario` date NOT NULL,
  `endereco_funcionario` varchar(150) NOT NULL,
  `telefone_funcionario` tinyint(12) NOT NULL,
  `cargo_funcionario` varchar(50) NOT NULL,
  `agencia_banco_funcionario` int(10) NOT NULL,
  `fk_supervisor_id_cpf_funcionario` int(11) NOT NULL,
  `conta_banco_funcionario` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `lotes_comprados`
--

CREATE TABLE `lotes_comprados` (
  `tipo_produto_lote` set('geladeira','ar_condicionado','fogao','lampada','air_fryer','chuveiro','freezer','liquidificador','novo') NOT NULL,
  `quantidade_lote` int(4) NOT NULL,
  `preco_lote` decimal(10,0) NOT NULL,
  `data_lote` date NOT NULL,
  `produto_disponível_lote` tinyint(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `produtos_vendidos`
--

CREATE TABLE `produtos_vendidos` (
  `id_codigo_produto_vendido` tinyint(6) NOT NULL,
  `nome_produto_vendido` varchar(50) NOT NULL,
  `fabricante_produto_vendido` varchar(30) NOT NULL,
  `modelo_produto_vendido` varchar(30) NOT NULL,
  `descricao_produto_vendido` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `vendas`
--

CREATE TABLE `vendas` (
  `numero_nota_fiscal` tinyint(16) NOT NULL,
  `data_hora_venda` datetime NOT NULL,
  `tipo_pagamento` set('pix','a vista','credito','debito','cheque') NOT NULL,
  `endereco_entrega` varchar(250) NOT NULL,
  `id_fk_cpf_cliente_responsavel` tinyint(11) DEFAULT NULL,
  `fk_id_funcionario_responsavel` tinyint(11) DEFAULT NULL,
  `fk_tipo_produto_vendido` int(11) DEFAULT NULL,
  `fk_lote_compra` tinyint(4) DEFAULT NULL,
  `quantidade_vendida` tinyint(100) DEFAULT NULL,
  `fk_preco_unitario` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cpf_cliente`);

--
-- Índices de tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id_cpf_funcionario`);

--
-- Índices de tabela `produtos_vendidos`
--
ALTER TABLE `produtos_vendidos`
  ADD PRIMARY KEY (`id_codigo_produto_vendido`);

--
-- Índices de tabela `vendas`
--
ALTER TABLE `vendas`
  ADD PRIMARY KEY (`numero_nota_fiscal`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

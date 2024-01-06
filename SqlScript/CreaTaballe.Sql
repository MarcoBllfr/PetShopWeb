CREATE TABLE `utenti` (
  `IdUtente` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `cognome` varchar(50) NOT NULL,
  `username` varchar(12) NOT NULL,
  `email` varchar(100) NOT NULL,
  `dataNascita` date NOT NULL,
  `cellulare` varchar(10) DEFAULT NULL,
  `password` varchar(30) NOT NULL,
  `ruolo` varchar(1) DEFAULT 'G',
  `stato` varchar(1) DEFAULT 'A',
  `login_rimanenti` int DEFAULT '0',
  PRIMARY KEY (`IdUtente`),
  UNIQUE KEY `IdUtente_UNIQUE` (`IdUtente`)
)
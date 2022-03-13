-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 12 mars 2022 à 10:05
-- Version du serveur :  10.4.14-MariaDB
-- Version de PHP : 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `ethlete`
--

-- --------------------------------------------------------

--
-- Structure de la table `affectation_formateur`
--

CREATE TABLE `affectation_formateur` (
  `formateur_id` int(11) NOT NULL,
  `formation_id` int(11) NOT NULL,
  `reponse` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `affectation_formateur`
--

INSERT INTO `affectation_formateur` (`formateur_id`, `formation_id`, `reponse`) VALUES
(19, 18, 2);

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

CREATE TABLE `article` (
  `idArticle` bigint(20) NOT NULL,
  `titre` varchar(250) NOT NULL,
  `contenu` varchar(500) NOT NULL,
  `description` varchar(250) NOT NULL,
  `nbrLike` int(11) NOT NULL,
  `idUser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `article`
--

INSERT INTO `article` (`idArticle`, `titre`, `contenu`, `description`, `nbrLike`, `idUser`) VALUES
(11, 'hytgfd', 'juyhtgrfed', 'uytref', 3, 14),
(12, 'dahmoun', 'dahmoun', 'dahmoun', 0, 12),
(13, 'flutter', 'avec monsieur abelmonem', 'mobile', 0, 19);

-- --------------------------------------------------------

--
-- Structure de la table `avis`
--

CREATE TABLE `avis` (
  `id_avis` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `note` enum('1','2','3','4','5') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `billets`
--

CREATE TABLE `billets` (
  `id_billet` int(11) NOT NULL,
  `id_event` int(11) NOT NULL,
  `nbr_billet` int(11) NOT NULL,
  `prix` float NOT NULL,
  `date_achat` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `idcateg` int(11) NOT NULL,
  `nomcateg` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`idcateg`, `nomcateg`) VALUES
(15, 'accessoires'),
(18, 'cider');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `idcom` int(11) NOT NULL,
  `idp` int(11) NOT NULL,
  `quantite` int(11) NOT NULL,
  `datecom` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`idcom`, `idp`, `quantite`, `datecom`) VALUES
(3, 56, 1, '2022-03-07'),
(4, 55, 34, '2022-03-08');

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

CREATE TABLE `commentaire` (
  `id_commentaire` int(11) NOT NULL,
  `id_formation` int(11) NOT NULL,
  `id_participant` int(11) NOT NULL,
  `contenu` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `commentaire`
--

INSERT INTO `commentaire` (`id_commentaire`, `id_formation`, `id_participant`, `contenu`) VALUES
(4, 18, 11, 'tres bien');

-- --------------------------------------------------------

--
-- Structure de la table `competition`
--

CREATE TABLE `competition` (
  `id_competition` int(11) NOT NULL,
  `nb_equipe` int(11) NOT NULL,
  `date` varchar(50) NOT NULL,
  `adresse` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `competition`
--

INSERT INTO `competition` (`id_competition`, `nb_equipe`, `date`, `adresse`, `nom`) VALUES
(2, 10, 'draft', '2022-03-10', 'Esprit'),
(3, 4, '2022-03-02', 'ghazela', 'ethlete'),
(4, 15, '2022-03-11', 'Esprit', 'delux'),
(5, 15, '2022-03-15', 'tunis', 'deulist'),
(6, 20, '2022-03-22', 'cv', 'danger'),
(7, 13, 'ligue', '2022-03-08', 'rades');

-- --------------------------------------------------------

--
-- Structure de la table `equipe`
--

CREATE TABLE `equipe` (
  `id_equipe` int(11) NOT NULL,
  `nom_equipe` varchar(50) NOT NULL,
  `id_responsable` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `equipe`
--

INSERT INTO `equipe` (`id_equipe`, `nom_equipe`, `id_responsable`) VALUES
(3, 'llll', 13),
(4, 'mm', 13),
(5, 'huruhfdn', 13),
(10, 'qsd', 18),
(14, 'azergf', 18);

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

CREATE TABLE `evenement` (
  `id_event` int(11) NOT NULL,
  `nom_event` varchar(30) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  `typeE` enum('Formation','Compétition') NOT NULL,
  `lieu` varchar(100) NOT NULL,
  `id_formation` int(11) DEFAULT NULL,
  `id_inter` int(11) DEFAULT NULL,
  `id_compet` int(11) DEFAULT NULL,
  `prixU` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`id_event`, `nom_event`, `date_debut`, `date_fin`, `typeE`, `lieu`, `id_formation`, `id_inter`, `id_compet`, `prixU`) VALUES
(8, 'event5', '2022-03-08', '2022-03-17', 'Formation', 'esprit', 6, 2, NULL, 12),
(10, 'tgrv', '2022-03-09', '2022-03-18', 'Formation', 'fe', 6, 2, NULL, 2.6);

-- --------------------------------------------------------

--
-- Structure de la table `formation`
--

CREATE TABLE `formation` (
  `id_formation` int(11) NOT NULL,
  `nom_formation` varchar(30) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  `dispositif` enum('En_Ligne','Presentiel') NOT NULL,
  `programme` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `formation`
--

INSERT INTO `formation` (`id_formation`, `nom_formation`, `date_debut`, `date_fin`, `dispositif`, `programme`) VALUES
(6, 'formation33455', '2022-02-03', '2022-02-17', 'En_Ligne', 'qqqq'),
(10, 'form35666', '2012-02-02', '2012-02-02', 'En_Ligne', 'moatez111111111111111111111111111'),
(14, 'formation2', '2022-02-03', '2022-02-17', 'Presentiel', 'qqqq'),
(18, 'java', '2022-03-04', '2022-03-12', 'En_Ligne', 'mm');

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

CREATE TABLE `fournisseur` (
  `idf` int(11) NOT NULL,
  `nomf` varchar(50) NOT NULL,
  `prenomf` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telf` int(50) NOT NULL,
  `adresse` varchar(50) NOT NULL,
  `idp` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `intervenant`
--

CREATE TABLE `intervenant` (
  `id_inter` int(11) NOT NULL,
  `image_In` varchar(100) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telephone` varchar(8) NOT NULL,
  `id_typeint` enum('invité','sponsor','organisateur') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `intervenant`
--

INSERT INTO `intervenant` (`id_inter`, `image_In`, `nom`, `prenom`, `email`, `telephone`, `id_typeint`) VALUES
(2, '', 'moatez123', '0', '0', '123', 'sponsor'),
(5, 'aaaa', 'aaaa', 'aaa', 'aaa@gmail.com', '2403010', 'invité'),
(8, '123', 'oueslati ', 'moatez', 'mo@gmail.com', '24030100', 'invité'),
(9, 'trfz', 'rgf', 'rgf', 'yasmine@gmail.com', '7522', 'sponsor');

-- --------------------------------------------------------

--
-- Structure de la table `invitation`
--

CREATE TABLE `invitation` (
  `id_invitation` int(11) NOT NULL,
  `etat` enum('accepté','non_consulté','refusé') NOT NULL,
  `id_eq` int(11) DEFAULT NULL,
  `id_joueur` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `invitation`
--

INSERT INTO `invitation` (`id_invitation`, `etat`, `id_eq`, `id_joueur`) VALUES
(6, 'refusé', 5, 11),
(7, 'accepté', 10, 11);

-- --------------------------------------------------------

--
-- Structure de la table `journe`
--

CREATE TABLE `journe` (
  `id_journe` int(11) NOT NULL,
  `numJourne` int(11) NOT NULL,
  `date_journe` varchar(255) NOT NULL,
  `id_competition` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `journe`
--

INSERT INTO `journe` (`id_journe`, `numJourne`, `date_journe`, `id_competition`) VALUES
(1, 6, '2022-03-17', 2),
(2, 1, '2022-03-15', 5),
(3, 2, '2022-03-15', 6),
(5, 6, '2022-03-02', 7);

-- --------------------------------------------------------

--
-- Structure de la table `match`
--

CREATE TABLE `match` (
  `id_match` int(11) NOT NULL,
  `Equipe1` varchar(255) NOT NULL,
  `Equipe2` varchar(255) NOT NULL,
  `etat` enum('en cours','fini','non commencé') NOT NULL DEFAULT 'non commencé',
  `id_journe` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `match`
--

INSERT INTO `match` (`id_match`, `Equipe1`, `Equipe2`, `etat`, `id_journe`) VALUES
(15, 'hurt', 'heal', 'fini', 1),
(16, 'bunzai', 'ethelet', 'non commencé', 2),
(17, 'css', 'est', 'non commencé', 2);

-- --------------------------------------------------------

--
-- Structure de la table `participation`
--

CREATE TABLE `participation` (
  `id_participant` int(11) NOT NULL,
  `formation_id` int(11) NOT NULL,
  `date_participation` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `participation`
--

INSERT INTO `participation` (`id_participant`, `formation_id`, `date_participation`) VALUES
(11, 6, '2022-03-08');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `idp` int(11) NOT NULL,
  `nomp` varchar(40) NOT NULL,
  `prix` float NOT NULL,
  `idcateg` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`idp`, `nomp`, `prix`, `idcateg`) VALUES
(55, 'product', 345, 15),
(56, 'yasmine', 0.5, 15);

-- --------------------------------------------------------

--
-- Structure de la table `raison`
--

CREATE TABLE `raison` (
  `idRaison` int(11) NOT NULL,
  `raisontxt` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `raison`
--

INSERT INTO `raison` (`idRaison`, `raisontxt`) VALUES
(5, 'connexion'),
(8, 'prpoblem'),
(7, 'yasmine');

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

CREATE TABLE `reclamation` (
  `idr` int(11) NOT NULL,
  `contenu` text NOT NULL,
  `id` int(11) NOT NULL,
  `daterec` varchar(100) NOT NULL,
  `idRaison` int(11) NOT NULL,
  `etat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `reponse`
--

CREATE TABLE `reponse` (
  `id_reponse` int(11) NOT NULL,
  `reponse` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reponse`
--

INSERT INTO `reponse` (`id_reponse`, `reponse`) VALUES
(1, 'Pas encore consulté'),
(2, 'confirmé'),
(3, 'refusé');

-- --------------------------------------------------------

--
-- Structure de la table `review`
--

CREATE TABLE `review` (
  `id` int(11) NOT NULL,
  `review` int(1) NOT NULL,
  `id_match` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(20) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `date_naissance` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `num_tel` int(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `genre` varchar(30) DEFAULT NULL,
  `id_eq` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `adresse`, `date_naissance`, `email`, `nom`, `num_tel`, `password`, `prenom`, `role`, `username`, `genre`, `id_eq`) VALUES
(10, 'mjezelbeb', '2022-03-03', 'temanimohameddahmani@gmail.com', 'Admin', 55820931, '21232f297a57a5a743894ae4a801fc3', 'Admin', 'ADMIN', 'admin', 'homme', NULL),
(11, 'mjezelbeb', '2022-03-03', 'temanimohameddahmani@gmail.com', 'Joueur', 55820931, '2713f078ca8aa0d6c921d9921d636', 'joueur', 'JOUEUR', 'joueur', 'femme', NULL),
(12, 'mjezelbeb', '2022-03-02', 'temanimohameddahmani@gmail.com', 'formatrice', 55820931, '7dfc6d74628885f45b85e3d3ffbb947b', 'formateur', 'FORMATEUR', 'formateur', 'femme', NULL),
(13, 'mjezelbeb', '2022-03-03', 'temanimohameddahmani@gmail.com', 'resp', 55820931, '98eb56fa798d8631fcc349693ef26d9', 'resp', 'RESPONSABLE', 'responsable', 'femme', NULL),
(14, 'hjk', '2022-03-10', 'rihem@gmail.com', 'rihem', 345678, '81dc9bdb52d04dc2036dbd8313ed055', 'rihem', 'JOUEUR', 'trfed43', 'null', NULL),
(15, 'tgvrfd', '2022-03-04', 'rihem@gmail.com', 'tgrfd', 65432543, '1cd3baec9dddb5ee14bacd7cc4e6a2c', 'grfdes', 'JOUEUR', 'tgrfed', 'null', NULL),
(17, 'ubhfedjknsla', '2022-03-05', 'rihem@gmail.com', 'rihem', 456378920, 'fbbcab8f9a1ebb639f74763417b2572', 'matoussi', 'JOUEUR', 'rfiednjosm', 'null', NULL),
(18, 'fchgjbkln', '2022-03-02', 'rihemmatoussi2@gmail.com', 'anas', 78453, '76eb649c47cbecad7c36e71374bc9a5', 'anas', 'RESPONSABLE', 'anas', 'homme', NULL),
(19, 'esprit', '2022-03-02', 'anas.laamiri@esprit.tn', 'teman', 55820931, 'f3132bfe507ee6fd6125831e746850d2', 'moatez', 'FORMATEUR', 'formateur1', 'homme', NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `affectation_formateur`
--
ALTER TABLE `affectation_formateur`
  ADD KEY `fk_formateur` (`formateur_id`),
  ADD KEY `fk_formation1` (`formation_id`),
  ADD KEY `fk_reponse` (`reponse`);

--
-- Index pour la table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`idArticle`),
  ADD KEY `idUser` (`idUser`);

--
-- Index pour la table `avis`
--
ALTER TABLE `avis`
  ADD PRIMARY KEY (`id_avis`),
  ADD KEY `fk_user` (`id_user`);

--
-- Index pour la table `billets`
--
ALTER TABLE `billets`
  ADD PRIMARY KEY (`id_billet`),
  ADD KEY `fk_billet_evenement` (`id_event`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`idcateg`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`idcom`),
  ADD KEY `idp` (`idp`);

--
-- Index pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD PRIMARY KEY (`id_commentaire`),
  ADD KEY `fk_form` (`id_formation`),
  ADD KEY `fk_part` (`id_participant`);

--
-- Index pour la table `competition`
--
ALTER TABLE `competition`
  ADD PRIMARY KEY (`id_competition`);

--
-- Index pour la table `equipe`
--
ALTER TABLE `equipe`
  ADD PRIMARY KEY (`id_equipe`),
  ADD KEY `fk_Responsable_eq` (`id_responsable`);

--
-- Index pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD PRIMARY KEY (`id_event`),
  ADD KEY `fk_form_event` (`id_formation`),
  ADD KEY `fk_comp` (`id_compet`),
  ADD KEY `fk_intervenantss` (`id_inter`);

--
-- Index pour la table `formation`
--
ALTER TABLE `formation`
  ADD PRIMARY KEY (`id_formation`);

--
-- Index pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD PRIMARY KEY (`idf`),
  ADD UNIQUE KEY `telf` (`telf`,`adresse`),
  ADD KEY `idp` (`idp`);

--
-- Index pour la table `intervenant`
--
ALTER TABLE `intervenant`
  ADD PRIMARY KEY (`id_inter`);

--
-- Index pour la table `invitation`
--
ALTER TABLE `invitation`
  ADD PRIMARY KEY (`id_invitation`),
  ADD KEY `fk_equipe` (`id_eq`),
  ADD KEY `fk_joueur` (`id_joueur`);

--
-- Index pour la table `journe`
--
ALTER TABLE `journe`
  ADD PRIMARY KEY (`id_journe`),
  ADD KEY `fk_idcj` (`id_competition`);

--
-- Index pour la table `match`
--
ALTER TABLE `match`
  ADD PRIMARY KEY (`id_match`),
  ADD KEY `fk_eq1` (`Equipe1`),
  ADD KEY `fk_eq2` (`Equipe2`),
  ADD KEY `fk_journee` (`id_journe`);

--
-- Index pour la table `participation`
--
ALTER TABLE `participation`
  ADD KEY `fk_participant` (`id_participant`),
  ADD KEY `fk_formation` (`formation_id`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`idp`),
  ADD KEY `idcateg` (`idcateg`);

--
-- Index pour la table `raison`
--
ALTER TABLE `raison`
  ADD PRIMARY KEY (`idRaison`),
  ADD KEY `raisontxt` (`raisontxt`);

--
-- Index pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD PRIMARY KEY (`idr`),
  ADD KEY `id` (`id`),
  ADD KEY `idRaison` (`idRaison`);

--
-- Index pour la table `reponse`
--
ALTER TABLE `reponse`
  ADD PRIMARY KEY (`id_reponse`);

--
-- Index pour la table `review`
--
ALTER TABLE `review`
  ADD KEY `id_ur` (`id`),
  ADD KEY `fk_rm` (`id_match`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `article`
--
ALTER TABLE `article`
  MODIFY `idArticle` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pour la table `avis`
--
ALTER TABLE `avis`
  MODIFY `id_avis` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `billets`
--
ALTER TABLE `billets`
  MODIFY `id_billet` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `idcateg` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `idcom` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `commentaire`
--
ALTER TABLE `commentaire`
  MODIFY `id_commentaire` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `competition`
--
ALTER TABLE `competition`
  MODIFY `id_competition` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `equipe`
--
ALTER TABLE `equipe`
  MODIFY `id_equipe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `evenement`
--
ALTER TABLE `evenement`
  MODIFY `id_event` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `formation`
--
ALTER TABLE `formation`
  MODIFY `id_formation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  MODIFY `idf` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `intervenant`
--
ALTER TABLE `intervenant`
  MODIFY `id_inter` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `invitation`
--
ALTER TABLE `invitation`
  MODIFY `id_invitation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `journe`
--
ALTER TABLE `journe`
  MODIFY `id_journe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `match`
--
ALTER TABLE `match`
  MODIFY `id_match` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `idp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- AUTO_INCREMENT pour la table `raison`
--
ALTER TABLE `raison`
  MODIFY `idRaison` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `reclamation`
--
ALTER TABLE `reclamation`
  MODIFY `idr` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT pour la table `reponse`
--
ALTER TABLE `reponse`
  MODIFY `id_reponse` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `affectation_formateur`
--
ALTER TABLE `affectation_formateur`
  ADD CONSTRAINT `fk_formateur11` FOREIGN KEY (`formateur_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_formation` FOREIGN KEY (`formation_id`) REFERENCES `formation` (`id_formation`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_reponse` FOREIGN KEY (`reponse`) REFERENCES `reponse` (`id_reponse`) ON DELETE CASCADE;

--
-- Contraintes pour la table `article`
--
ALTER TABLE `article`
  ADD CONSTRAINT `fk_art_us` FOREIGN KEY (`idUser`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `avis`
--
ALTER TABLE `avis`
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `billets`
--
ALTER TABLE `billets`
  ADD CONSTRAINT `fk_billet_event` FOREIGN KEY (`id_event`) REFERENCES `evenement` (`id_event`) ON DELETE CASCADE;

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `fk_commande` FOREIGN KEY (`idp`) REFERENCES `produit` (`idp`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `fk_form` FOREIGN KEY (`id_formation`) REFERENCES `formation` (`id_formation`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_part` FOREIGN KEY (`id_participant`) REFERENCES `user` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `equipe`
--
ALTER TABLE `equipe`
  ADD CONSTRAINT `fk_Responsable_eq` FOREIGN KEY (`id_responsable`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD CONSTRAINT `fk_comp` FOREIGN KEY (`id_compet`) REFERENCES `competition` (`id_competition`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_formationn` FOREIGN KEY (`id_formation`) REFERENCES `formation` (`id_formation`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_intervenantss` FOREIGN KEY (`id_inter`) REFERENCES `intervenant` (`id_inter`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD CONSTRAINT `fk_fournisseur` FOREIGN KEY (`idp`) REFERENCES `produit` (`idp`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `invitation`
--
ALTER TABLE `invitation`
  ADD CONSTRAINT `fk_equipe` FOREIGN KEY (`id_eq`) REFERENCES `equipe` (`id_equipe`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_joueur` FOREIGN KEY (`id_joueur`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `journe`
--
ALTER TABLE `journe`
  ADD CONSTRAINT `fk_idcj` FOREIGN KEY (`id_competition`) REFERENCES `competition` (`id_competition`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Contraintes pour la table `match`
--
ALTER TABLE `match`
  ADD CONSTRAINT `fk_journee` FOREIGN KEY (`id_journe`) REFERENCES `journe` (`id_journe`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `participation`
--
ALTER TABLE `participation`
  ADD CONSTRAINT `fk_formation_part` FOREIGN KEY (`formation_id`) REFERENCES `formation` (`id_formation`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_participant` FOREIGN KEY (`id_participant`) REFERENCES `user` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `produit`
--
ALTER TABLE `produit`
  ADD CONSTRAINT `fk_produit` FOREIGN KEY (`idcateg`) REFERENCES `categorie` (`idcateg`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD CONSTRAINT `fk_rason1` FOREIGN KEY (`idRaison`) REFERENCES `raison` (`idRaison`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_user_rec` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `review`
--
ALTER TABLE `review`
  ADD CONSTRAINT `fk_rm` FOREIGN KEY (`id_match`) REFERENCES `match` (`id_match`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `id_ur` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

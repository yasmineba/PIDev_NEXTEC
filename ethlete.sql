-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : Dim 20 fév. 2022 à 18:17
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
(1, 2, 1),
(1, 2, 1),
(1, 2, 1);

-- --------------------------------------------------------

--
-- Structure de la table `affectation_intervenant`
--

CREATE TABLE `affectation_intervenant` (
  `id_inter` int(11) NOT NULL,
  `id_eve` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `billets`
--

CREATE TABLE `billets` (
  `id_billet` int(11) NOT NULL,
  `id_event` int(11) NOT NULL,
  `date_achat` date NOT NULL,
  `heure_achat` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `idc` int(50) NOT NULL,
  `quantitec` int(50) NOT NULL,
  `idf` int(11) NOT NULL,
  `idp` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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

-- --------------------------------------------------------

--
-- Structure de la table `competition`
--

CREATE TABLE `competition` (
  `nb_equipes` int(11) NOT NULL,
  `id_competition` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `equipe`
--

CREATE TABLE `equipe` (
  `id_equipe` int(11) NOT NULL,
  `nom_equipe` varchar(50) NOT NULL,
  `id_responsable` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

CREATE TABLE `evenement` (
  `id_event` int(11) NOT NULL,
  `nom_event` varchar(30) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  `type` varchar(50) NOT NULL,
  `id_formation` int(11) DEFAULT NULL,
  `id_compet` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `formation`
--

CREATE TABLE `formation` (
  `id_formation` int(11) NOT NULL,
  `nom_formation` varchar(30) NOT NULL,
  `date_debut` varchar(10) NOT NULL,
  `date_fin` varchar(10) NOT NULL,
  `dispositif` enum('En_Ligne','Presentiel') NOT NULL,
  `programme` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `formation`
--

INSERT INTO `formation` (`id_formation`, `nom_formation`, `date_debut`, `date_fin`, `dispositif`, `programme`) VALUES
(2, 'form1', '15/02/2022', '15/02/2022', 'En_Ligne', 'moatez111111111111111111111111111'),
(3, 'aorm2', '10/02/2022', '15/02/2022', 'Presentiel', 'moatez111111111111111111111111111');

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
  `adresse` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `intervenant`
--

CREATE TABLE `intervenant` (
  `id_inter` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `poste` enum('invité','sponsor','organisateur') NOT NULL,
  `email` varchar(50) NOT NULL,
  `telephone` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `invitation`
--

CREATE TABLE `invitation` (
  `id_invitation` int(11) NOT NULL,
  `etat` varchar(50) NOT NULL,
  `id_eq` int(11) DEFAULT NULL,
  `id_joueur` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `journée`
--

CREATE TABLE `journée` (
  `id_journée` int(11) NOT NULL,
  `numJournée` int(11) NOT NULL,
  `date_journée` date NOT NULL,
  `id_competition` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `match`
--

CREATE TABLE `match` (
  `Equipe1` int(11) NOT NULL,
  `Equipe2` int(11) NOT NULL,
  `etat` enum('en cours','fini','non commencé') NOT NULL DEFAULT 'non commencé',
  `id_journée` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `participation`
--

CREATE TABLE `participation` (
  `id_participant` int(11) NOT NULL,
  `formation_id` int(11) NOT NULL,
  `date_participation` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `participation`
--

INSERT INTO `participation` (`id_participant`, `formation_id`, `date_participation`) VALUES
(1, 3, ''),
(3, 2, '');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `idp` int(11) NOT NULL,
  `nomp` varchar(50) NOT NULL,
  `categorie` varchar(50) NOT NULL,
  `prix` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

CREATE TABLE `reclamation` (
  `idr` int(11) NOT NULL,
  `contenu` text NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `date_naissance` date NOT NULL,
  `email` varchar(50) NOT NULL,
  `telephone` varchar(8) NOT NULL,
  `adresse` varchar(50) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `genre` varchar(50) NOT NULL,
  `role` varchar(50) DEFAULT NULL,
  `id_equipe` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `date_naissance`, `email`, `telephone`, `adresse`, `username`, `password`, `genre`, `role`, `id_equipe`) VALUES
(1, 'moatez', 'moatez', '2022-02-02', 'moatez@gmail.com', '12345678', 'moatez', NULL, NULL, 'homme', NULL, NULL),
(3, 'moatez', 'moatez', '2022-02-09', 'moatez@gmail.com', '12345678', 'moatez', NULL, NULL, 'homme', NULL, NULL);

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
-- Index pour la table `affectation_intervenant`
--
ALTER TABLE `affectation_intervenant`
  ADD KEY `fk_inter` (`id_inter`),
  ADD KEY `fk_form` (`id_eve`);

--
-- Index pour la table `billets`
--
ALTER TABLE `billets`
  ADD PRIMARY KEY (`id_billet`),
  ADD KEY `fk_billet_evenement` (`id_event`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`idc`),
  ADD KEY `fk_fourn` (`idf`),
  ADD KEY `fk_prod` (`idp`);

--
-- Index pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD PRIMARY KEY (`id_commentaire`),
  ADD KEY `fk_part` (`id_participant`),
  ADD KEY `fk_form` (`id_formation`);

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
  ADD KEY `fk_comp` (`id_compet`);

--
-- Index pour la table `formation`
--
ALTER TABLE `formation`
  ADD PRIMARY KEY (`id_formation`);

--
-- Index pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD PRIMARY KEY (`idf`);

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
-- Index pour la table `journée`
--
ALTER TABLE `journée`
  ADD PRIMARY KEY (`id_journée`),
  ADD KEY `fk_jour_com` (`id_competition`);

--
-- Index pour la table `match`
--
ALTER TABLE `match`
  ADD KEY `fk_jour` (`id_journée`),
  ADD KEY `fk_eq1` (`Equipe1`),
  ADD KEY `fk_eq2` (`Equipe2`);

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
  ADD PRIMARY KEY (`idp`);

--
-- Index pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD PRIMARY KEY (`idr`),
  ADD KEY `id` (`id`);

--
-- Index pour la table `reponse`
--
ALTER TABLE `reponse`
  ADD PRIMARY KEY (`id_reponse`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_joueur_equipe` (`id_equipe`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `billets`
--
ALTER TABLE `billets`
  MODIFY `id_billet` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `idc` int(50) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `commentaire`
--
ALTER TABLE `commentaire`
  MODIFY `id_commentaire` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `competition`
--
ALTER TABLE `competition`
  MODIFY `id_competition` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `equipe`
--
ALTER TABLE `equipe`
  MODIFY `id_equipe` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `evenement`
--
ALTER TABLE `evenement`
  MODIFY `id_event` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `formation`
--
ALTER TABLE `formation`
  MODIFY `id_formation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  MODIFY `idf` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `idp` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `reponse`
--
ALTER TABLE `reponse`
  MODIFY `id_reponse` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `affectation_formateur`
--
ALTER TABLE `affectation_formateur`
  ADD CONSTRAINT `fk_formateur` FOREIGN KEY (`formateur_id`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `fk_formation` FOREIGN KEY (`formation_id`) REFERENCES `formation` (`id_formation`),
  ADD CONSTRAINT `fk_reponse` FOREIGN KEY (`reponse`) REFERENCES `reponse` (`id_reponse`);

--
-- Contraintes pour la table `affectation_intervenant`
--
ALTER TABLE `affectation_intervenant`
  ADD CONSTRAINT `fk_env` FOREIGN KEY (`id_eve`) REFERENCES `evenement` (`id_event`),
  ADD CONSTRAINT `fk_int` FOREIGN KEY (`id_inter`) REFERENCES `intervenant` (`id_inter`);

--
-- Contraintes pour la table `billets`
--
ALTER TABLE `billets`
  ADD CONSTRAINT `fk_billet_event` FOREIGN KEY (`id_event`) REFERENCES `evenement` (`id_event`);

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `fk_fourn` FOREIGN KEY (`idf`) REFERENCES `fournisseur` (`idf`),
  ADD CONSTRAINT `fk_prod` FOREIGN KEY (`idp`) REFERENCES `produit` (`idp`);

--
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `fk_form` FOREIGN KEY (`id_formation`) REFERENCES `formation` (`id_formation`),
  ADD CONSTRAINT `fk_part` FOREIGN KEY (`id_participant`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `equipe`
--
ALTER TABLE `equipe`
  ADD CONSTRAINT `fk_Responsable_eq` FOREIGN KEY (`id_responsable`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD CONSTRAINT `fk_comp` FOREIGN KEY (`id_compet`) REFERENCES `competition` (`id_competition`),
  ADD CONSTRAINT `fk_formationn` FOREIGN KEY (`id_formation`) REFERENCES `formation` (`id_formation`);

--
-- Contraintes pour la table `invitation`
--
ALTER TABLE `invitation`
  ADD CONSTRAINT `fk_equipe` FOREIGN KEY (`id_eq`) REFERENCES `equipe` (`id_equipe`),
  ADD CONSTRAINT `fk_joueur` FOREIGN KEY (`id_joueur`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `journée`
--
ALTER TABLE `journée`
  ADD CONSTRAINT `fk_jour_com` FOREIGN KEY (`id_competition`) REFERENCES `competition` (`id_competition`);

--
-- Contraintes pour la table `match`
--
ALTER TABLE `match`
  ADD CONSTRAINT `fk_eq1` FOREIGN KEY (`Equipe1`) REFERENCES `equipe` (`id_equipe`),
  ADD CONSTRAINT `fk_eq2` FOREIGN KEY (`Equipe2`) REFERENCES `equipe` (`id_equipe`);

--
-- Contraintes pour la table `participation`
--
ALTER TABLE `participation`
  ADD CONSTRAINT `fk_formation_part` FOREIGN KEY (`formation_id`) REFERENCES `formation` (`id_formation`),
  ADD CONSTRAINT `fk_participant` FOREIGN KEY (`id_participant`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `fk_joueur_equipe` FOREIGN KEY (`id_equipe`) REFERENCES `equipe` (`id_equipe`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

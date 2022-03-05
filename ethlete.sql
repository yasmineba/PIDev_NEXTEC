-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 05 mars 2022 à 19:14
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
(1, 6, 1);

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
(2, 'mm', 'hh', 'jj', 0, 2),
(3, 'derby', 'match', 'match', 0, 2),
(4, 'kkk', 'kkk', 'kkk', 0, 2),
(5, 'lll', 'lll', 'lll', 0, 2);

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
(16, 'accessoires');

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
(1, 6, 1, 'moatez');

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
(2, 'lefriki11', 1);

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

CREATE TABLE `evenement` (
  `id_event` int(11) NOT NULL,
  `nom_event` varchar(30) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  `id_typeE` varchar(50) NOT NULL,
  `id_formation` int(11) DEFAULT NULL,
  `id_inter` int(11) DEFAULT NULL,
  `id_compet` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
(10, 'form35', '2012-02-02', '2012-02-02', 'En_Ligne', 'moatez111111111111111111111111111'),
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
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telephone` varchar(8) NOT NULL,
  `id_typeint` enum('invité','sponsor','organisateur') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `intervenant`
--

INSERT INTO `intervenant` (`id_inter`, `nom`, `prenom`, `email`, `telephone`, `id_typeint`) VALUES
(2, 'Ben 55Abda', 'Yasmine', 'benabda@gmail.com', '27156643', 'sponsor'),
(3, 'Ben 55Abda', 'Yasmine', 'benabda@gmail.com', '27156643', 'sponsor');

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
(1, 'non_consulté', 2, 1),
(2, 'non_consulté', 2, 1),
(3, 'non_consulté', 2, 1),
(4, 'non_consulté', 2, 1),
(5, 'non_consulté', 2, 1);

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

-- --------------------------------------------------------

--
-- Structure de la table `match`
--

CREATE TABLE `match` (
  `id_match` int(11) NOT NULL,
  `Equipe1` int(255) NOT NULL,
  `Equipe2` int(255) NOT NULL,
  `etat` enum('en cours','fini','non commencé') NOT NULL DEFAULT 'non commencé'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
(1, 6, '2022-03-05'),
(1, 18, '2022-03-05');

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
(51, 'necklace', 78, 15);

-- --------------------------------------------------------

--
-- Structure de la table `raison`
--

CREATE TABLE `raison` (
  `idRaison` int(11) NOT NULL,
  `raisontxt` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

CREATE TABLE `reclamation` (
  `idr` int(11) NOT NULL,
  `contenu` text NOT NULL,
  `id` int(11) NOT NULL,
  `daterec` date NOT NULL,
  `idRaison` int(11) NOT NULL
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
(1, 'ariana', '2022-03-14', 'mmm', 'mm', 43434, 'ee11cbb19052e4b7aac0ca6c23ee', 'mm', 'FORMATEUR', 'mm', 'homme', NULL),
(2, 'ariana', '2022-03-13', 'temanimohameddahmi', 'temani', 5555, '7dc71596b177f323db34eacd63048f7', 'mohamed', 'ADMIN', 'dahh', 'femme', NULL),
(3, 'bardo', '2022-03-09', 'moatez.oueslati@esprit.tn', 'oueslati', 24030100, '1394f926812e7dbce50d279b6cfef5e', 'oueslati', 'JOUEUR', 'mooo', 'null', NULL);

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
(1, 'moatez', 'moatez', '2022-02-02', 'moatez.oueslati@esprit.tn', '12345678', 'moatez', 'a', NULL, 'homme', 'ROLE_FORMATEUR', NULL),
(3, 'moatez', 'moatez', '2022-02-09', 'moatez.oueslati@esprit.tn', '12345678', 'moatez', 'a', NULL, 'homme', 'ROLE_FORMATEUR', NULL),
(6, 'laamiri', 'anas', '2022-02-09', 'moatez@gmail.com', '12345678', 'moatez', 'a', NULL, 'homme', 'ROLE_FORMATEUR', NULL),
(7, 'yasmine.benabda@esprit.tn', 'yasmine.benabda@esprit.tn', '2022-02-02', 'yasmine.benabda@esprit.tn', '12345678', 'yasmine.benabda@esprit.tn', 'yasmine.benabda@esprit.tn', 'yasmine.benabda@esprit.tn', 'homme', 'ROLE_FORMATEUR', NULL),
(9, 'dahmoun', 'dahmoun', '1960-02-16', 'dahmoun', '45698721', 'dahmoun', 'a', NULL, 'femme', 'ROLE_FORMATEUR', NULL);

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
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

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
-- AUTO_INCREMENT pour la table `article`
--
ALTER TABLE `article`
  MODIFY `idArticle` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `avis`
--
ALTER TABLE `avis`
  MODIFY `id_avis` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `billets`
--
ALTER TABLE `billets`
  MODIFY `id_billet` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `idcateg` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `idcom` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `commentaire`
--
ALTER TABLE `commentaire`
  MODIFY `id_commentaire` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `competition`
--
ALTER TABLE `competition`
  MODIFY `id_competition` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `equipe`
--
ALTER TABLE `equipe`
  MODIFY `id_equipe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `evenement`
--
ALTER TABLE `evenement`
  MODIFY `id_event` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `formation`
--
ALTER TABLE `formation`
  MODIFY `id_formation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  MODIFY `idf` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `intervenant`
--
ALTER TABLE `intervenant`
  MODIFY `id_inter` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `invitation`
--
ALTER TABLE `invitation`
  MODIFY `id_invitation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `journe`
--
ALTER TABLE `journe`
  MODIFY `id_journe` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `match`
--
ALTER TABLE `match`
  MODIFY `id_match` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `idp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT pour la table `raison`
--
ALTER TABLE `raison`
  MODIFY `idRaison` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `reclamation`
--
ALTER TABLE `reclamation`
  MODIFY `idr` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `reponse`
--
ALTER TABLE `reponse`
  MODIFY `id_reponse` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

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
  ADD CONSTRAINT `fk_Responsable_eq` FOREIGN KEY (`id_responsable`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD CONSTRAINT `fk_comp` FOREIGN KEY (`id_compet`) REFERENCES `competition` (`id_competition`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_formationn` FOREIGN KEY (`id_formation`) REFERENCES `formation` (`id_formation`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD CONSTRAINT `fk_fournisseur` FOREIGN KEY (`idp`) REFERENCES `produit` (`idp`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `invitation`
--
ALTER TABLE `invitation`
  ADD CONSTRAINT `fk_equipe` FOREIGN KEY (`id_eq`) REFERENCES `equipe` (`id_equipe`),
  ADD CONSTRAINT `fk_joueur` FOREIGN KEY (`id_joueur`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `journe`
--
ALTER TABLE `journe`
  ADD CONSTRAINT `fk_idcj` FOREIGN KEY (`id_competition`) REFERENCES `competition` (`id_competition`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Contraintes pour la table `match`
--
ALTER TABLE `match`
  ADD CONSTRAINT `fk_eq1` FOREIGN KEY (`Equipe1`) REFERENCES `equipe` (`id_equipe`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_eq2` FOREIGN KEY (`Equipe2`) REFERENCES `equipe` (`id_equipe`) ON DELETE CASCADE ON UPDATE CASCADE;

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
  ADD CONSTRAINT `fk_raison` FOREIGN KEY (`idRaison`) REFERENCES `raison` (`idRaison`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_user_rec` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `fk_joueur_equipe` FOREIGN KEY (`id_equipe`) REFERENCES `equipe` (`id_equipe`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

# StockMaster-Pro
TP1 JAVA EE
\documentclass[11pt,a4paper]{article}

\usepackage[utf8]{inputenc}
\usepackage[T1]{fontenc}
\usepackage[french]{babel}
\usepackage{geometry}
\usepackage{listings}
\usepackage{graphicx}
\usepackage{xcolor}

\geometry{margin=2.5cm}

\title{StockMaster Pro \\ \large Configuration de la Base de Données MySQL}
\author{Projet JEE}
\date{\today}

\lstset{
    language=SQL,
    basicstyle=\ttfamily\small,
    keywordstyle=\color{blue},
    commentstyle=\color{gray},
    frame=single
}

\begin{document}

\maketitle

\section{Objectif}
Cette partie du projet vise à connecter l'application \textbf{StockMaster Pro} à une base de données MySQL réelle en utilisant l'API JDBC et une architecture en couches (DAO / Service).

---

\section{Création de la base de données}
La base de données est créée à l'aide d'un outil de gestion MySQL (phpMyAdmin, MySQL Workbench ou DataGrip).

\begin{lstlisting}
CREATE DATABASE stockdb;
USE stockdb;
\end{lstlisting}

\subsection*{Capture d'écran}
\begin{center}
\fbox{\includegraphics[width=0.8\textwidth]{screenshots/create_database.png}}
\end{center}

---

\section{Création de la table \texttt{produit}}
La table \texttt{produit} contient les informations nécessaires à l'affichage du catalogue.

\begin{lstlisting}
CREATE TABLE produit (
    id INT PRIMARY KEY,
    nom VARCHAR(100),
    prix DOUBLE
);
\end{lstlisting}

\subsection*{Capture d'écran}
\begin{center}
\fbox{\includegraphics[width=0.8\textwidth]{screenshots/create_table.png}}
\end{center}

---

\section{Insertion des données}
Des données de test sont insérées manuellement afin de valider le fonctionnement de la couche DAO.

\begin{lstlisting}
INSERT INTO produit VALUES (1, 'Clavier', 25);
INSERT INTO produit VALUES (2, 'Souris', 15.5);
INSERT INTO produit VALUES (3, 'Écran', 320);
\end{lstlisting}

\subsection*{Capture d'écran}
\begin{center}
\fbox{\includegraphics[width=0.8\textwidth]{screenshots/insert_data.png}}
\end{center}

---

\section{Connexion JDBC}
La connexion à la base de données est réalisée dans la couche DAO à l'aide de la classe \texttt{DriverManager}.

\begin{itemize}
    \item Chargement du driver MySQL
    \item Ouverture de la connexion
    \item Exécution des requêtes SQL
    \item Fermeture des ressources
\end{itemize}

Cette implémentation respecte le principe de séparation des responsabilités.

---

\section{Résultat}
Les produits sont récupérés depuis MySQL via la couche DAO, puis affichés dans la page JSP du catalogue sans aucune modification de la vue.

\subsection*{Capture d'écran}
\begin{center}
\fbox{\includegraphics[width=0.8\textwidth]{screenshots/catalogue_result.png}}
\end{center}

---

\section{Conclusion}
L'utilisation d'une base de données MySQL combinée à une architecture en couches permet une application évolutive, maintenable et conforme aux standards Java Entreprise.

\end{document}

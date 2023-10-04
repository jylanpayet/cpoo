#cpoo
<h3 align="center">Programme Fractales</h3>

<details open="open">
  <summary>Table des matières</summary>
  <ol>
    <li>
      <a href="projet">À propos du projet</a>
      <ul>
        <li><a href="#langages-et-outils">Langages et outils utilisés</a></li>
      </ul>
    </li>
    <li><a href="#commencer">Pour commencer</a></li>
    <li><a href="#issues">TODO</a></li>
    <li><a href="#auteurs">Auteurs</a></li>
    <li><a href="#remerciements">Remerciements</a></li>
  </ol>
</details>

## <div id="projet">À propos du projet</div>

Ce programme de fractales a été réalisé pour l'enseignement de CPOO.  

Julia et Mandlebrot, c'est quoi au juste ?

* Une figure fractale est une courbe ou une surface de forme irrégulière ou morcelée qui se crée en suivant des règles déterministes ou stochastiques impliquant une homothétie interne.
* Julia et Mandlebrot représente deux ensembles proches l'un à l'autre.

L'essentiel de ce programme :
* Générer des fractales de l'ensemble de Julia ainsi que celle de Mandelbrot.
* Le programme peut être lancé depuis le terminal mais également sous forme d'interface graphique.

### <div id="langages-et-outils"><ins>Langages et outils utilisés</ins></div>

* [Java](https://www.java.com/fr/) - Langage utilisé pour le programme
* [Gradle](https://gradle.org/) - L'outil de gestion des dépendances utilisé

## <div id="commencer">Pour commencer</div>

Nous allons vous faire part de toutes les informations afin de comprendre comment fonctionne le
programme.

### <div id="demarrage-global"><ins>Lancement du programme</ins></div>

Pour compiler le projet, pensez à exécuter la commande suivante :
```
./gradlew run
```
#### <ins>_Choix des interfaces possibles_</ins> :

* Appuyez sur la touche 1 afin de continuer avec le programme sur le terminal
* Appuyez sur la touche 2 afin d'ouvrir le programme avec son interface graphique.

#### <ins>_A savoir pour le programme côté terminal_</ins> :
Vous pouvez configurer les paramètres que vous souhaitez pour lancer le programme, 
en ouvrant et modifiant le contenu du fichier Paramètres.txt dans le path
```
src/main/java/FractalProject/resources/
```

## <div id="issues">TODO</div>
#### <ins>_Les différentes idées possibles à intégrer_</ins> :
- ajouter les threads pour déployer le calcul en simultané sur chaque pixel afin de générer 
  plus rapidement nos images.
- peaufiner l'interface graphique pour la rendre plus fonctionnel et penser d'avantage à l'UX.

## <div id="auteurs">Auteurs</div>

* **PAYET Jylan** - [@payetj](https://gaufre.informatique.univ-paris-diderot.fr/payetj)
* **ALEXANDRE Dylan** - [@alexandr](https://gaufre.informatique.univ-paris-diderot.fr/alexandr)

<!-- REMERCIEMENTS -->
## <div id="remerciements">Remerciements</div>

* [ASARIN Eugène](https://www.irif.fr/~asarin/)
* [JURSKI Yan](https://www.irif.fr/~jurski/)

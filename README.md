# BlackJack

*  [Overview](#overview)
*  [Requirements](#requirements)
    *  [Restrictions](#restrictions)
*  [Dependencies](#dependencies)
*  [Installation](#installation)
    *  [JDK](#jdk)
    *  [Maven](#maven)
*  [Build](#build)
    *  [Clean](#clean)
    *  [Install](#install)
    *  [Site](#site)
*  [Run](#run)
    *  [Startup](#startup)
    *  [Menu](#menu)
    *  [Current Player](current-player)
    *  [Hit](#hit)
    *  [Busted](#busted)
    *  [Stand](#stand)
    *  [Quit](#quit)
*  [Ending](#ending)

## Overview

A simple Blackjack game implemented in Java.  One of the design goals for this implementation is to limit 3rd party libraries and utilize only the JDK.

## Requirements

The game blackjack, has a few basic rules that are implemented in this release:

* A blackjack is a total score of 21
* A score above 21 results in a player being _busted_ and removed from the game
* Each card value is represented by it's _face_ value.  
    * The Jack, Queen and King are worth 10 points
    * The Ace is worth 11 points.
* The player with the highest point total, less than or equal to 21 points, wins the game.
* If a player ties with the Dealer for the highest score, the win is awarded to the dealer.
        
### Restrictions

* For this implementation, an Ace cannot be delared as low (1 point)
* Up to 5 players, plus the dealer can play   
* The game does not support betting.


## Dependencies

* JDK 1.8 or above (Tested with OpenJDK 11)
* Maven 3.x or above (Tested with 3.6)
* Console/Terminal environment supporting UTF-8 (Tested on Linux Mint 19.x, Windows should work as well)

## Installation

### JDK

Install Java JDK with Compiler and JavaDoc.

```
devadmin@mint-mate-193-x64:~ $ sudo apt install openjdk-11-jdk
devadmin@mint-mate-193-x64:~$ export $JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64/
devadmin@mint-mate-193-x64:~$ export $PATH=$PATH:$JAVA_HOME/bin
devadmin@mint-mate-193-x64:~$ java -version
openjdk version "11.0.7" 2020-04-14
OpenJDK Runtime Environment (build 11.0.7+10-post-Ubuntu-2ubuntu218.04)
OpenJDK 64-Bit Server VM (build 11.0.7+10-post-Ubuntu-2ubuntu218.04, mixed mode, sharing)
devadmin@mint-mate-193-x64:~$ javac -version
javac 11.0.7
devadmin@mint-mate-193-x64:~$ 
```

### Maven

First Download Maven **from https://maven.apache.org/download.cgi**.  Extract to a desired location. For this example Maven is copied to the user's **HOME** directory.

```
devadmin@mint-mate-193-x64:~$ cd Downloads
devadmin@mint-mate-193-x64:~/Downloads$ ls
apache-maven-3.6.3-bin.tar.gz
devadmin@mint-mate-193-x64:~/Downloads$ tar -xvf apache-maven-3.6.3-bin.tar.gz 
apache-maven-3.6.3/README.txt
apache-maven-3.6.3/LICENSE
apache-maven-3.6.3/NOTICE
apache-maven-3.6.3/lib/
...
apache-maven-3.6.3/lib/maven-resolver-transport-wagon-1.4.1.jar
apache-maven-3.6.3/lib/maven-slf4j-provider-3.6.3.jar
apache-maven-3.6.3/lib/jansi-1.17.1.jar
devadmin@mint-mate-193-x64:~/Downloads$ 
devadmin@mint-mate-193-x64:~/Downloads$ mv apache-maven-3.6.3 ~
devadmin@mint-mate-193-x64:~/Downloads$ 
```

Update the environment and add Maven's binaries to the system **PATH**.

```
devadmin@mint-mate-193-x64:~$ cat .bash_profile 

#.bash_profile

JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
MVN_HOME=/home/devadmin/apache-maven-3.6.3
PATH=$PATH:$JAVA_HOME/bin:$MVN_HOME/bin

export JAVA_HOME MVN_HOME PATH
```

## Build

The blackjack software is built, tested, and packaged with the Maven system.  Maven is executed from the command line in the root directory of the blackjack repository.

### Clean

This command will clean the build (output) directories, which is configured to be the **target** directory.

```
devadmin@mint-mate-193-x64:~$ cd git/blackjack/
devadmin@mint-mate-193-x64:~/git/blackjack$ ls pom.xml
pom.xml
devadmin@mint-mate-193-x64:~/git/blackjack$ mvn clean
[INFO] Scanning for projects...
[WARNING] 
[WARNING] Some problems were encountered while building the effective model for geminicode:blackjack:jar:0.0.1-SNAPSHOT
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-surefire-report-plugin is missing. @ line 79, column 12
[WARNING] 
[WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
[WARNING] 
[WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
[WARNING] 
[INFO] 
[INFO] ------------------------< geminicode:blackjack >------------------------
[INFO] Building BlackJack 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ blackjack ---
[INFO] Deleting /home/devadmin/git/blackjack/target
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.687 s
[INFO] Finished at: 2020-05-11T11:18:00-05:00
[INFO] ------------------------------------------------------------------------
devadmin@mint-mate-193-x64:~/git/blackjack$ 
```


### Install

**BlackJack** can be built from the command line by typing the ```mvn install``` command.  The **install** command will also execute the unit tests.  If any unittest fails, the build will fail.

```
devadmin@mint-mate-193-x64:~/git/blackjack$ mvn install
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------< geminicode:blackjack >------------------------
[INFO] Building BlackJack 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- jacoco-maven-plugin:0.8.5:prepare-agent (coverage-initialize) @ blackjack ---
[INFO] argLine set to -javaagent:/home/devadmin/m2_repository/org/jacoco/org.jacoco.agent/0.8.5/org.jacoco.agent-0.8.5-runtime.jar=destfile=/home/devadmin/git/blackjack/target/jacoco.exec
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ blackjack ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ blackjack ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ blackjack ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /home/devadmin/git/blackjack/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ blackjack ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ blackjack ---
[INFO] Surefire report directory: /home/devadmin/git/blackjack/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running geminicode.CardTest
Tests run: 13, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.245 sec
Running geminicode.DeckTest
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.018 sec
Running geminicode.BlackJackTest
Unexpected Error: null

Game is over!
Test MessageTests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.196 sec
Running geminicode.PlayerTest
Tests run: 7, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.017 sec

Results :

Tests run: 30, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ blackjack ---
[INFO] Building jar: /home/devadmin/git/blackjack/target/blackjack-0.0.1-SNAPSHOT.jar
[INFO] META-INF/maven/geminicode/blackjack/pom.xml already added, skipping
[INFO] META-INF/maven/geminicode/blackjack/pom.properties already added, skipping
[INFO] 
[INFO] --- jacoco-maven-plugin:0.8.5:report (coverage-report) @ blackjack ---
[INFO] Loading execution data file /home/devadmin/git/blackjack/target/jacoco.exec
[INFO] Analyzed bundle 'BlackJack' with 7 classes
[INFO] 
[INFO] --- maven-install-plugin:2.4:install (default-install) @ blackjack ---
[INFO] Installing /home/devadmin/git/blackjack/target/blackjack-0.0.1-SNAPSHOT.jar to /home/devadmin/m2_repository/geminicode/blackjack/0.0.1-SNAPSHOT/blackjack-0.0.1-SNAPSHOT.jar
[INFO] Installing /home/devadmin/git/blackjack/pom.xml to /home/devadmin/m2_repository/geminicode/blackjack/0.0.1-SNAPSHOT/blackjack-0.0.1-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.481 s
[INFO] Finished at: 2020-05-11T11:22:35-05:00
[INFO] ------------------------------------------------------------------------
devadmin@mint-mate-193-x64:~/git/blackjack$ 
```

### Site

The **site** command is optional, however it will build a small set of web pages summarizing the Maven software used to build the system.  This command will also create any reports that have been configured.   The **blackjack** system contains reports for JavaDocs, Test Summary and Code Coverage Reports.

```
devadmin@mint-mate-193-x64:~/git/blackjack$ mvn site
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------< geminicode:blackjack >------------------------
[INFO] Building BlackJack 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-site-plugin:3.7.1:site (default-site) @ blackjack ---
[WARNING] Input file encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] configuring report plugin org.apache.maven.plugins:maven-javadoc-plugin:3.2.0
[INFO] preparing maven-javadoc-plugin:javadoc report requires 'generate-sources' forked phase execution
[INFO] 
...
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ blackjack ---
[INFO] Surefire report directory: /home/devadmin/git/blackjack/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running geminicode.CardTest
Tests run: 13, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.173 sec
Running geminicode.DeckTest
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.004 sec
Running geminicode.BlackJackTest
Unexpected Error: null

Game is over!
Test MessageTests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.091 sec
Running geminicode.PlayerTest
Tests run: 7, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.007 sec

Results :

Tests run: 30, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] <<< maven-surefire-report-plugin:2.12.4:report < [surefire]test @ blackjack <<<
...
[INFO] 
Loading source files for package geminicode...
Constructing Javadoc information...
Standard Doclet version 11.0.7
Building tree for all the packages and classes...
Generating /home/devadmin/git/blackjack/target/site/apidocs/geminicode/BlackJack.html...
Generating /home/devadmin/git/blackjack/target/site/apidocs/geminicode/Card.html...
...
Generating /home/devadmin/git/blackjack/target/site/testapidocs/help-doc.html...
[INFO] Generating "Surefire Report" report --- maven-surefire-report-plugin:2.12.4:report-only
[WARNING] Unable to locate Test Source XRef to link to - DISABLED
[INFO] Generating "JaCoCo" report        --- jacoco-maven-plugin:0.8.5:report
[INFO] Loading execution data file /home/devadmin/git/blackjack/target/jacoco.exec
[INFO] Analyzed bundle 'BlackJack' with 7 classes
[INFO] Generating "Dependencies" report  --- maven-project-info-reports-plugin:3.0.0:dependencies
[INFO] Generating "Dependency Information" report --- maven-project-info-reports-plugin:3.0.0:dependency-info
[INFO] Generating "About" report         --- maven-project-info-reports-plugin:3.0.0:index
[INFO] Generating "Plugin Management" report --- maven-project-info-reports-plugin:3.0.0:plugin-management
[INFO] Generating "Plugins" report       --- maven-project-info-reports-plugin:3.0.0:plugins
[INFO] Generating "Summary" report       --- maven-project-info-reports-plugin:3.0.0:summary
[INFO] Generating "Team" report          --- maven-project-info-reports-plugin:3.0.0:team
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  15.641 s
[INFO] Finished at: 2020-05-11T11:37:49-05:00
[INFO] ------------------------------------------------------------------------
devadmin@mint-mate-193-x64:~/git/blackjack$ 

```

The reports are created on the file system and can be found here:

* JavaDocs                [target/site/apidocs/index.html](target/site/apidocs/index.html)
* Test JavaDocs           [target/site/testapidocs/index.html](target/site/testapidocs/index.html)
* Surefire Report         [target/site/surefire-report.html](target/site/surefire-report.html)
* JaCoCo Coverage Report  [target/site/jacoco/index.html](target/site/jacoco/index.html)


## Run

The following examples assume the user is in the blackjack's root repository directory.

### Startup

The BlackJack software is started from the command line in a terminal window.  The Blackjack software is packaged as a **JAR** file and can be executed using the **java** command.

After starting the software, the user is prompted for the number of **players**.  Up to five players can play, not including the Dealer.  After the number players is specified, the game begins and displays each user's hand of two (2) cards.

```
devadmin@mint-mate-193-x64:~/git/blackjack$ java -jar target/blackjack-0.0.1-SNAPSHOT.jar 
Welcome to BlackJack!.  Let's Play a Game.
  Five or less Players, NOT includeing the Dealer.
How many players? 3
Starting Game with 3 Players
-> (Playing) Player#1:[4]  1♠: 3♢: 
.. (Playing) Player#2:[13]  2♥: 11♣: 
.. (Playing) Player#3:[15]  11♠: 4♠: 
.. (Playing) Dealer:[13]  3♠: 10♥: 




Player Player#1 Turn: [H]it [S]tand [Q]uit : 
```

### Menu

At the bottom of the display is the game menu.  There are three possible actions.

* Hit - 'H', Deal the current player a single card.
* Stand - 'S', the current player will stand (stop) and play with his point total.
* Quit - 'Q', will quit the game.

To execute a command, type in the associated character followed by the &lt;ENTER&gt; key.

```
Player Player#1 Turn: [H]it [S]tand [Q]uit : 
```

### Current Player

To the far left, the current player is identified with the **-&gt;** symbol.  Other players are identified with two periods **..**

```
-> (Playing) Player#1:[4]  1♠: 3♢: 
.. (Playing) Player#2:[13]  2♥: 11♣: 
.. (Playing) Player#3:[15]  11♠: 4♠: 
.. (Playing) Dealer:[13]  3♠: 10♥: 
```

### Hit

The **Hit** command will deal the current player a single card.  In the example below, **Player#1** get a third card, a **10 of hearts**, the total value of his hand is now **14**.

```
Player Player#1 Turn: [H]it [S]tand [Q]uit : h
-> (Playing) Player#1:[14]  1♠: 3♢: 10♥: 
.. (Playing) Player#2:[13]  2♥: 11♣: 
.. (Playing) Player#3:[15]  11♠: 4♠: 
.. (Playing) Dealer:[13]  3♠: 10♥: 




Player Player#1 Turn: [H]it [S]tand [Q]uit : 
```

### Busted

When a **Hit** command is issued, if the player's hand total exceeds 21, then the user is **Busted** and loses the game.  In the example below, **Player#1** gets a forth and fifth card and now the total value of his hand is **30** and the player is busted.  Turn is now passed to **Player#2**.

```

Player Player#1 Turn: [H]it [S]tand [Q]uit : h
-> (Playing) Player#1:[20]  1♠: 3♢: 10♥: 6♠: 
.. (Playing) Player#2:[13]  2♥: 11♣: 
.. (Playing) Player#3:[15]  11♠: 4♠: 
.. (Playing) Dealer:[13]  3♠: 10♥: 




Player Player#1 Turn: [H]it [S]tand [Q]uit : h
.. (Busted) Player#1:[30]  1♠: 3♢: 10♥: 6♠: 10♣: 
-> (Playing) Player#2:[13]  2♥: 11♣: 
.. (Playing) Player#3:[15]  11♠: 4♠: 
.. (Playing) Dealer:[13]  3♠: 10♥: 




Player Player#2 Turn: [H]it [S]tand [Q]uit : 
```

### Stand

If a player is satisfied with their hand they can choose to **Stand**.  This action will end the player's turn and the player's hand value will be used to attempt to win the game.  In the example below, **Player#2** has taken a third card and is **Standing** on hand total of **18**.

```
Player Player#2 Turn: [H]it [S]tand [Q]uit : h
.. (Busted) Player#1:[30]  1♠: 3♢: 10♥: 6♠: 10♣: 
-> (Playing) Player#2:[18]  2♥: 11♣: 5♣: 
.. (Playing) Player#3:[15]  11♠: 4♠: 
.. (Playing) Dealer:[13]  3♠: 10♥: 




Player Player#2 Turn: [H]it [S]tand [Q]uit : S
.. (Busted) Player#1:[30]  1♠: 3♢: 10♥: 6♠: 10♣: 
.. (Standing) Player#2:[18]  2♥: 11♣: 5♣: 
-> (Playing) Player#3:[15]  11♠: 4♠: 
.. (Playing) Dealer:[13]  3♠: 10♥: 




Player Player#3 Turn: [H]it [S]tand [Q]uit : 
```

### Quit

At any point, a player can select to **Quit** the game.  The software will immediately stop and return control to the terminal program.

```
Player Player#2 Turn: [H]it [S]tand [Q]uit : S
.. (Busted) Player#1:[30]  1♠: 3♢: 10♥: 6♠: 10♣: 
.. (Standing) Player#2:[18]  2♥: 11♣: 5♣: 
-> (Playing) Player#3:[15]  11♠: 4♠: 
.. (Playing) Dealer:[13]  3♠: 10♥: 




Player Player#3 Turn: [H]it [S]tand [Q]uit : q
Thank you for playing!

devadmin@mint-mate-193-x64:~/git/blackjack$ 
```

## Ending

The game ends when the Dealer's turn is over.  In the event of a tie, even with blackjack, the Dealer will always be declared a winner.  Once the game is over, the software will exit back to the terminal program. t

```
Player Dealer Turn: [H]it [S]tand [Q]uit : h
.. (Busted) Player#1:[28]  8♠: 10♢: 10♣: 
.. (Standing) Player#2:[20]  5♣: 6♥: 9♢: 
.. (Standing) Player#3:[21]  10♣: 11♢: 
-> (Winner) Dealer:[21]  11♠: 6♠: 4♠: 


Game is over!
devadmin@mint-mate-193-x64:~/git/blackjack$ 

```


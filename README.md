# blackjack

## Requirements

* JDK 1.8 or above
* Maven 3.x or above (Tested with 3.6)

## Build

**BlackJack** can be built from the command line by typing the ```mvn clean install``` command.

```
devadmin@mint-mate-193-x64:~/git/blackjack$ mvn clean install
[INFO] Scanning for projects...
[WARNING] 
[WARNING] Some problems were encountered while building the effective model for geminicode:blackjack:jar:0.0.1-SNAPSHOT
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-jar-plugin is missing. @ line 27, column 12
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-surefire-report-plugin is missing. @ line 69, column 12
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
[INFO] 
[INFO] --- jacoco-maven-plugin:0.8.5:prepare-agent (coverage-initialize) @ blackjack ---
[INFO] argLine set to -javaagent:/home/devadmin/m2_repository/org/jacoco/org.jacoco.agent/0.8.5/org.jacoco.agent-0.8.5-runtime.jar=destfile=/home/devadmin/git/blackjack/target/jacoco.exec
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ blackjack ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ blackjack ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 3 source files to /home/devadmin/git/blackjack/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ blackjack ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /home/devadmin/git/blackjack/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ blackjack ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 3 source files to /home/devadmin/git/blackjack/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ blackjack ---
[INFO] Surefire report directory: /home/devadmin/git/blackjack/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running geminicode.CardTest
Tests run: 12, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.12 sec
Running geminicode.DeckTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.005 sec
Running geminicode.BlackJackTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.01 sec

Results :

Tests run: 14, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ blackjack ---
[INFO] Building jar: /home/devadmin/git/blackjack/target/blackjack-0.0.1-SNAPSHOT.jar
[INFO] 
[INFO] --- jacoco-maven-plugin:0.8.5:report (coverage-report) @ blackjack ---
[INFO] Loading execution data file /home/devadmin/git/blackjack/target/jacoco.exec
[INFO] Analyzed bundle 'BlackJack' with 5 classes
[INFO] 
[INFO] --- maven-install-plugin:2.4:install (default-install) @ blackjack ---
[INFO] Installing /home/devadmin/git/blackjack/target/blackjack-0.0.1-SNAPSHOT.jar to /home/devadmin/m2_repository/geminicode/blackjack/0.0.1-SNAPSHOT/blackjack-0.0.1-SNAPSHOT.jar
[INFO] Installing /home/devadmin/git/blackjack/pom.xml to /home/devadmin/m2_repository/geminicode/blackjack/0.0.1-SNAPSHOT/blackjack-0.0.1-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.536 s
[INFO] Finished at: 2020-05-07T13:37:41-05:00
[INFO] ------------------------------------------------------------------------
devadmin@mint-mate-193-x64:~/git/blackjack$ 
```

## Run
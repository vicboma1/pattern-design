[Observer pattern](http://en.wikipedia.org/wiki/Observer_pattern)
=================

* The example of this pattern show how 2 players and 2 enemies are registered to receive status notifications opposites. These reports show the total number of attacks received and current life. It is a broadcast notification.

```
Notify [Joe] -> New status for Joe | Total Attacks: 15 | Actual Health: 40 | is Dead ? false
Notify [Mac] -> New status for Joe | Total Attacks: 15 | Actual Health: 40 | is Dead ? false
Notify [Cannibal] -> New status for Joe | Total Attacks: 15 | Actual Health: 40 | is Dead ? false
Notify [Depredator] -> New status for Joe | Total Attacks: 15 | Actual Health: 40 | is Dead ? false

Notify [Joe] -> New status for Mac | Total Attacks: 5 | Actual Health: 100 | is Dead ? false
Notify [Mac] -> New status for Mac | Total Attacks: 5 | Actual Health: 100 | is Dead ? false
Notify [Cannibal] -> New status for Mac | Total Attacks: 5 | Actual Health: 100 | is Dead ? false
Notify [Depredator] -> New status for Mac | Total Attacks: 5 | Actual Health: 100 | is Dead ? false

Notify [Joe] -> New status for Cannibal | Total Attacks: 20 | Actual Health: 35 | is Dead ? false
Notify [Mac] -> New status for Cannibal | Total Attacks: 20 | Actual Health: 35 | is Dead ? false
Notify [Depredator] -> New status for Cannibal | Total Attacks: 20 | Actual Health: 35 | is Dead ? false

Notify [Joe] -> New status for Joe | Total Attacks: 25 | Actual Health: 35 | is Dead ? false
Notify [Mac] -> New status for Joe | Total Attacks: 25 | Actual Health: 35 | is Dead ? false
Notify [Cannibal] -> New status for Joe | Total Attacks: 25 | Actual Health: 35 | is Dead ? false
Notify [Depredator] -> New status for Joe | Total Attacks: 25 | Actual Health: 35 | is Dead ? false

Notify [Joe] -> New status for Depredator | Total Attacks: 35 | Actual Health: 20 | is Dead ? false
Notify [Mac] -> New status for Depredator | Total Attacks: 35 | Actual Health: 20 | is Dead ? false
Notify [Cannibal] -> New status for Depredator | Total Attacks: 35 | Actual Health: 20 | is Dead ? false

Notify [Joe] -> New status for Cannibal | Total Attacks: 35 | Actual Health: 20 | is Dead ? false
Notify [Mac] -> New status for Cannibal | Total Attacks: 35 | Actual Health: 20 | is Dead ? false
Notify [Depredator] -> New status for Cannibal | Total Attacks: 35 | Actual Health: 20 | is Dead ? false

Notify [Joe] -> New status for Mac | Total Attacks: 25 | Actual Health: 80 | is Dead ? false
Notify [Mac] -> New status for Mac | Total Attacks: 25 | Actual Health: 80 | is Dead ? false
Notify [Cannibal] -> New status for Mac | Total Attacks: 25 | Actual Health: 80 | is Dead ? false
Notify [Depredator] -> New status for Mac | Total Attacks: 25 | Actual Health: 80 | is Dead ? false

Notify [Joe] -> New status for Depredator | Total Attacks: 40 | Actual Health: 15 | is Dead ? false
Notify [Mac] -> New status for Depredator | Total Attacks: 40 | Actual Health: 15 | is Dead ? false
Notify [Cannibal] -> New status for Depredator | Total Attacks: 40 | Actual Health: 15 | is Dead ? false

Notify [Joe] -> New status for Cannibal | Total Attacks: 50 | Actual Health: 5 | is Dead ? false
Notify [Mac] -> New status for Cannibal | Total Attacks: 50 | Actual Health: 5 | is Dead ? false
Notify [Depredator] -> New status for Cannibal | Total Attacks: 50 | Actual Health: 5 | is Dead ? false

Notify [Joe] -> New status for Mac | Total Attacks: 45 | Actual Health: 70 | is Dead ? false
Notify [Mac] -> New status for Mac | Total Attacks: 45 | Actual Health: 70 | is Dead ? false
Notify [Cannibal] -> New status for Mac | Total Attacks: 45 | Actual Health: 70 | is Dead ? false
Notify [Depredator] -> New status for Mac | Total Attacks: 45 | Actual Health: 70 | is Dead ? false

Notify [Joe] -> New status for Cannibal | Total Attacks: 55 | Actual Health: 0 | is Dead ? true
Notify [Mac] -> New status for Cannibal | Total Attacks: 55 | Actual Health: 0 | is Dead ? true
Notify [Depredator] -> New status for Cannibal | Total Attacks: 55 | Actual Health: 0 | is Dead ? true

Notify [Joe] -> New status for Joe | Total Attacks: 50 | Actual Health: 10 | is Dead ? false
Notify [Mac] -> New status for Joe | Total Attacks: 50 | Actual Health: 10 | is Dead ? false
Notify [Cannibal] -> New status for Joe | Total Attacks: 50 | Actual Health: 10 | is Dead ? false
Notify [Depredator] -> New status for Joe | Total Attacks: 50 | Actual Health: 10 | is Dead ? false

Notify [Joe] -> New status for Depredator | Total Attacks: 45 | Actual Health: 10 | is Dead ? false
Notify [Mac] -> New status for Depredator | Total Attacks: 45 | Actual Health: 10 | is Dead ? false
Notify [Cannibal] -> New status for Depredator | Total Attacks: 45 | Actual Health: 10 | is Dead ? false

Notify [Joe] -> New status for Cannibal | Total Attacks: 60 | Actual Health: -5 | is Dead ? true
Notify [Mac] -> New status for Cannibal | Total Attacks: 60 | Actual Health: -5 | is Dead ? true
Notify [Depredator] -> New status for Cannibal | Total Attacks: 60 | Actual Health: -5 | is Dead ? true

Notify [Joe] -> New status for Mac | Total Attacks: 65 | Actual Health: 50 | is Dead ? false
Notify [Mac] -> New status for Mac | Total Attacks: 65 | Actual Health: 50 | is Dead ? false
Notify [Cannibal] -> New status for Mac | Total Attacks: 65 | Actual Health: 50 | is Dead ? false
Notify [Depredator] -> New status for Mac | Total Attacks: 65 | Actual Health: 50 | is Dead ? false

Notify [Joe] -> New status for Depredator | Total Attacks: 50 | Actual Health: 5 | is Dead ? false
Notify [Mac] -> New status for Depredator | Total Attacks: 50 | Actual Health: 5 | is Dead ? false
Notify [Cannibal] -> New status for Depredator | Total Attacks: 50 | Actual Health: 5 | is Dead ? false

Notify [Joe] -> New status for Joe | Total Attacks: 60 | Actual Health: 20 | is Dead ? false
Notify [Mac] -> New status for Joe | Total Attacks: 60 | Actual Health: 20 | is Dead ? false
Notify [Cannibal] -> New status for Joe | Total Attacks: 60 | Actual Health: 20 | is Dead ? false
Notify [Depredator] -> New status for Joe | Total Attacks: 60 | Actual Health: 20 | is Dead ? false


```

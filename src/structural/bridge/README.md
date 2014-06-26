[Bridge pattern](http://en.wikipedia.org/wiki/Bridge_pattern)
=================

"Decouple an abstraction from its implementation so that the two can vary independently".
The bridge uses encapsulation, aggregation, and can use inheritance to separate responsibilities into different classes.

```
Inject combustion Gasoline 99.2125
Porsche{isStart=true, Gasoline{isRun=true, stroke=FOUR}}
Inject combustion Gasoline 97.75
Lamborghini{isStart=true, Gasoline{isRun=true, stroke=TWO}}
Inject combustion Disel 97.75
Lamborghini{isStart=true, Diesel{isRun=true, stroke=TWO}}
Inject combustion Gasoline 85.0
Motoreta{isStart=true, Gasoline{isRun=true, stroke=NULL}}

Inject combustion Gasoline 98.42500000000001
Porsche{isStart=true, Gasoline{isRun=true, stroke=FOUR}}
Inject combustion Gasoline 95.5
Lamborghini{isStart=true, Gasoline{isRun=true, stroke=TWO}}
Inject combustion Disel 95.5
Lamborghini{isStart=true, Diesel{isRun=true, stroke=TWO}}
Inject combustion Gasoline 70.0
Motoreta{isStart=true, Gasoline{isRun=true, stroke=NULL}}

Inject combustion Gasoline 97.63750000000002
Porsche{isStart=true, Gasoline{isRun=true, stroke=FOUR}}
Inject combustion Gasoline 93.25
Lamborghini{isStart=true, Gasoline{isRun=true, stroke=TO}}
Inject combustion Disel 93.25
Lamborghini{isStart=true, Diesel{isRun=true, stroke=TWO}}
Inject combustion Gasoline 55.0
Motoreta{isStart=true, Gasoline{isRun=true, stroke=NULL}}

Inject combustion Gasoline 96.85000000000002
Porsche{isStart=true, Gasoline{isRun=true, stroke=FOUR}}
Inject combustion Gasoline 91.0
Lamborghini{isStart=true, Gasoline{isRun=true, stroke=TWO}}
Inject combustion Disel 91.0
Lamborghini{isStart=true, Diesel{isRun=true, stroke=TWO}}
Inject combustion Gasoline 40.0
Motoreta{isStart=true, Gasoline{isRun=true, stroke=NULL}}

Inject combustion Gasoline 96.06250000000003
Porsche{isStart=true, Gasoline{isRun=true, stroke=FOUR}}
Inject combustion Gasoline 88.75
Lamborghini{isStart=true, Gasoline{isRun=true, stroke=TWO}}
Inject combustion Disel 88.75
Lamborghini{isStart=true, Diesel{isRun=true, stroke=TWO}}
Inject combustion Gasoline 25.0
Motoreta{isStart=true, Gasoline{isRun=true, stroke=NULL}}

Inject combustion Gasoline 95.27500000000003
Porsche{isStart=true, Gasoline{isRun=true, stroke=FOUR}}
Inject combustion Gasoline 86.5
Lamborghini{isStart=true, Gasoline{isRun=true, stroke=TWO}}
Inject combustion Disel 86.5
Lamborghini{isStart=true, Diesel{isRun=true, stroke=TWO}}
Inject combustion Gasoline 10.0
Motoreta{isStart=true, Gasoline{isRun=true, stroke=NULL}}

Inject combustion Gasoline 94.48750000000004
Porsche{isStart=true, Gasoline{isRun=true, stroke=FOUR}}
Inject combustion Gasoline 84.25
Lamborghini{isStart=true, Gasoline{isRun=true, stroke=TWO}}
Inject combustion Disel 84.25
Lamborghini{isStart=true, Diesel{isRun=true, stroke=TWO}}
Inject combustion Gasoline -5.0
Motoreta{isStart=false, Gasoline{isRun=true, stroke=NULL}}

```
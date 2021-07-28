<h1 style="display: block; width: 100%; text-align: center;">Object-oriented program design - Assignment 01</h1>

<span style="display: block; width: 100%; text-align: center;">Yuxuan Zhang, 2160909016, School of Physics, XJTU</span>

## Problem 1 - Number to English

There is a very useful statement in the problem body, requiring the scale of the units to be as large as possible. e.g. 1500 translates into `one thousand five hundred` instead of `fifteen hundred`. This inspired me to make a sequential procedure to solve solve this problem.

In practice, I created a recursion logic, and the recursion body looks like this:

```java
public static void parse(long val, boolean self_explain) {
    int lv = levels.length - 1;
    // Find the nearest suitable level
    while (levels[lv].val > val) {
        lv--;
    }
    if (val > levels[lv].val) {
        parse(val / levels[lv].val, levels[lv].self_explain);
        print(levels[lv].unit);
        if (val % levels[lv].val > 0) {
            parse(val % levels[lv].val, self_explain);
        }
    } else if (val != 1 || !self_explain) {
        print(levels[lv].unit);
    }
}
```

When the `main()` method finished parsing the input value into integer, it calls `parse()` method, passing the initial value. We can ignore the second boolean argument for now.

In the recursion procedure, the `parse()` method goes through an array of units (`levels[]`) in descending order, and tries to find the "largest unit smaller than the input value". And then it splits the input value into two parts, the first part is input value divided by the unit, and the second part is the remainder of the division.

Finally, when the recursion reaches its termination condition ( `value == 0 || value == 1` ), it returns the final result level by level. The final assembly looks like `parse(division) + current_level_unit + parse(remainder)`.

To proof such algorithm actually works, and further explain it's mechanism, let's take an example for test.

> ### Recursion Level **0**
>
> ```java
> parse(12123){
>     level       == 1000; // thousand
>     value/level == 12;
>     value%level == 123;
>     return parse(12) + "thousand" +  parse(123);
> }
> ```
>
> > ### Recursion Level **1**
> > 
> > ```java
> > parse(12){
> >     level       == 12; // twelve
> >     value/level == 1;
> >     value%level == 0;
> >     return parse(1) + "twelve" +  parse(0);
> > }
> > ```
> >
> > > ### Recursion Level **2**
> > > 
> > > ```java
> > > parse(1){
> > >     return ""; // Returns **nothing**.
> > > }
> > > ```
> > > 
> > > ```java
> > > parse(0){
> > >     return ""; // Returns nothing.
> > > }
> > > ```
> > 
> > ```java
> > parse(123){
> >     level       == 100; // hundred
> >     value/level == 1;
> >     value%level == 23;
> >     return parse(1) + "hundred" +  parse(23);
> > }
> > ```
> >
> > > ### Recursion Level **2**
> > > 
> > > ```java
> > > parse(1){
> > >     return "one"; // The tricky point.
> > > }
> > > ```
> > > 
> > > ```java
> > > parse(12){
> > >     level       == 12; // twelve | Exact match
> > >     value/level == 1;
> > >     value%level == 0;
> > >     return "twelve";
> > > }
> > > ```
> > > > ### Recursion Level **3**
> > > > 
> > > > ```java
> > > > parse(1){
> > > >     return ""; // Returns **nothing**.
> > > > }
> > > > ```
> > > > 
> > > > ```java
> > > > parse(0){
> > > >     return ""; // Returns nothing.
> > > > }
> > > > ```

The above procedure produces "twelve thousand one hundred twelve", which matches the correct answer.

As you might have already noticed, the same recursive call `parse(1)` produces TWO DIFFERENT RESULTS! This is because we have to treat two different types of units differently. One of them are units like "million", "thousand" and "hundred". These units, when having a prefix of 1, should be explicitly stated. e.g. "one hundred". Another type of unit is self-explanatory, including "ten", "twenty", "eleven" and more. These units do not need a prefix of "one". If `parse(1)` for their prefix returns string "one", the result will look weird (`parse(10) == "one ten"`).

### Test cases
```sh
$> java Num2Eng 12123
twelve thousand one hundred twenty three

$> java Num2Eng 123419
one hundred twenty three thousand four hundred nineteen
```

## Problem 2 - Monte Carlo

A class was created to represent a single throw:

```java

```

## Problem 3 - Max Product of Subsequences

## Problem 4 - Date Utilities

## Problem 5 - Morse Code

## Problem 6 - Java Graphics
# 2.4 Exercises
[Creative Scala Tutorial](http://www.scalabridge.org/creative-scala-v2.html)

###2.4.0.1 Arithmetic
```10 + 42 - 10```

###2.4.0.2 Appending Strings
```
"Hello" ++ " world!"
"Hello".++(" world!")
```

###2.4.0.3 Precedence
Operators like * / take precedence over + -

###2.4.0.4 Types and Values
*Compiles*
1 + 2 :Int
3.toInt :Int
"Electric blue".take(1) :String
1 + ("Moonage daydream".indexOf("N")) :Int
1 / 1 + ("Moonage daydream".indexOf("N")) :Int

*Do not compile*
"Electric blue".toInt
"Electric blue".take("blue")
1 / (1 + ("Moonage daydream".indexOf("N")))

*Fails at run-time*
"Electric blue".take(1)
1 / (1 + ("Moonage daydream".indexOf("N")))

###2.4.0.5 Floating Point Failings
A Double takes up precisely 64-bits, and are stored in binary. 

##Doodle exercises

###Create circles that are 1, 10, and 100 units wide
```
circle(1).draw
circle(10).draw
circle(100).draw
```

###What is the type of a circle?
Image

###What’s the type of drawing an image?
Unit, where no value is returned. 

###Create the picture fig. 5 
```
((circle(10) beside circle(10) beside circle(10)) on circle(30)).draw
```

###Evil Eye fig. 6
```
(
    circle(10) fillColor Color.black on 
    circle(20) fillColor Color.cornflowerBlue on circle(27) fillColor Color.white on 
    circle(45) fillColor Color.darkBlue).draw
```

## Create RGB colors

RGB takes three parameters: red, green, blue (between 0 - 255 UnsignedByte)

Convert Int to UnsignedByte using .uByte

```
Color.rgb(255.uByte, 255.uByte, 255.uByte) // White
Color.rgb(0.uByte, 0.uByte, 0.uByte) // Black
Color.rgb(255.uByte, 0.uByte, 0.uByte) // Red
```

## Create HSL colors
Hue: angle between 0 & 360 degrees
Saturation: 0 - 1, intensity of color
Lightness: 0 - 1, brightness of color

- Convert a Double to an Angle using .degrees or .radians

``` 
0.degrees  // Angle(0.0)
3.14.radians // Angle(3.14)
```

- Convert a Double to saturation or lightness using ```.normalized``` method

```
1.0.normalized  // Normalized(1.0)
-1.0.normalized // Too small, clipped to Normalized(0.0)
```

-  Construct color using ```Color.hsl``` method:

```Color.hsl(0.degrees, 0.8.normalized, 0.6.normalized) // A pastel red
```

## Manipulating colors
* ```spin```, which rotates the hue by an Angle;
* ```saturate``` and ```desaturate```, which respectively add and subtract a Normalised value from the color; and
* ```lighten``` and ```darken```, which respectively add and subtract a Normalised value from the lightness.

For example, create 3 circles with  diff. color, fig.10

```
(
    (circle(100) fillColor Color.red) beside 
    (circle(100) fillColor Color.red.spin(15.degrees)) beside
    (circle(100) fillColor Color.red.spin(30.degrees))
    ).lineWidth(5.0).draw
```

### 3.4.4 Transparency
Add transparency with a ```alpha``` value between 0.0 - 1.0 (0 = transparent, 1 = completely opaque). 

To manipulate color, use the ```.alpha()``` method:

```Color.blue.alpha(0.5.normalized)```

```
((circle(40) fillColor (Color.red.alpha(0.5.normalized))) beside
 (circle(40) fillColor (Color.blue.alpha(0.5.normalized))) on
 (circle(40) fillColor (Color.green.alpha(0.5.normalized)))).draw
```

###Create fig. 13 Complementary Triangles
(
    (triangle(20,20) fillColor (Color.darkSlateBlue lighten 0.3.normalized)) above
    (
        (triangle(20,20) fillColor (Color.darkSlateBlue saturate 0.2.normalized)) beside

        (triangle(20,20) fillColor (Color.darkSlateBlue darken 0.2.normalized))
    )  
).draw

###3.5.1 Compilation Target fig. 14 & fig. 15
Plain target:
```
(
    circle(10) on
    circle(20) on
    circle(30)
).draw
```

Add a stand with color:
```
(
    (circle(10) fillColor Color.red) on
    (circle(20) fillColor Color.white) on
    (circle(30) fillColor Color.red) above
    (rectangle(5,20) fillColor Color.white) above
    (rectangle(20,5) fillColor Color.brown)
).draw
```

Add green ground area:
```
(
    (circle(10) fillColor Color.red) on
    (circle(20) fillColor Color.white) on
    (circle(30) fillColor Color.red) above
    (rectangle(5,20) fillColor Color.white) above
    (rectangle(20,5) fillColor Color.brown) above
    (rectangle(90,30) fillColor Color.green)
).draw
```

## 4.3.5 Scope Exercises

### Exercise 1
```
val a = 1
val b = 2
val answer = a + b
```
answer = 3

### Exercise 2
```
object One {
  val a = 1

  object Two {
    val a = 3
    val b = 2
  }

  object Answer {
    val answer = a + Two.b
  }
}
```
answer = 3

### Exercise 3
```
object One {
  val a = 5
  val b = 2
  
  object Answer {
    val a = 1
    val answer = a + b
  }
}
```
answer = 3

### Exercise 4
```
object One {
  val a = 1
  val b = a + 1
  val answer = a + b
}
```
answer = 3

### Exercise 5
```
object One {
  val a = 1
  
  object Two {
    val b = 2
  }
  
  val answer = a + b
}
```
answer = error! Doesn't compile since ```b``` is not in scope

### Exercise 6
```
object One {
  val a = b - 1
  val b = a + 1
  
  val answer = a + b
}
```
answer = error! circular loop.

## Exercise 4.4 Abstraction

### Exercise: Archery Again
```
val target = (
    (circle(10) fillColor Color.red) on
    (circle(20) fillColor Color.white) on
    (circle(30) fillColor Color.red)
)

val stand = (
    (rectangle(5,20) fillColor Color.white) above
    (rectangle(20,5) fillColor Color.brown) 
)

val grass = (
    (rectangle(90,30) fillColor Color.green)
)

val image = (target above stand above grass).draw
```

### Exercise: Streets Ahead

val roof = (
    triangle(30,30) fillColor Color.brown
)

val door = (
    (square(10) fillColor Color.red lineColor(Color.red.alpha(0.0.normalized))) above
    (rectangle(5,20) fillColor Color.black) on
    square(30) fillColor Color.red
)

val house = roof above door

val tree = (
    (circle(22) fillColor Color.green) above
    (rectangle(5,18) fillColor Color.brown)
)

val bricks = (
    (
        (rectangle(25,2) fillColor Color.yellow) beside
        rectangle(5,2) fillColor Color.black
    ) above
    rectangle(30,2) fillColor Color.black
)

val street = (
    bricks beside bricks beside bricks
)

val singleHome = (
    (house beside tree) above street 
)

val streetView = singleHome beside singleHome beside singleHome

streetView.draw


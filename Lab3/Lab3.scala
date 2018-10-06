def sqrt(x: Double, y:Double = 1.0) :Double = if(isGoodEnough(x,y)) y else sqrt(x,improve(x,y))
def square(x: Double) :Double = x*x
def isGoodEnough(x: Double, y: Double) :Boolean = Math.abs(square(y)-x)<0.001
def improve(x: Double, y: Double) :Double = (y + x/y)/2

def test(sqrt: Double, expected: Double) :Boolean = if(sqrt.toInt==expected.toInt) true else false

test(sqrt(4), 2)
test(sqrt(4), 3)
test(sqrt(16), 4)
test(sqrt(2000000), 1414)
test(sqrt(2000000), 1415)

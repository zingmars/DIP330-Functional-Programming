package com.scala

object RTUSet {
  /**
    * We define a set by its characteristic function
    */
  type Set = Int => Boolean

  /**
    * If  a set contains an element.
    */
  def contains(s: Set, elem: Int): Boolean = s(elem)

  /**
    * Singleton set from one element
    */
  def singletonSet(elem: Int): Set = (x: Int) => x == elem

  /**
    * Union of the two sets
    */
  def union(s: Set, t: Set): Set = (x : Int) => s(x) || t(x)

  /**
    * Intersection of the two sets
    */
  def intersect(s: Set, t: Set): Set = (x : Int) => s(x) && t(x)

  /**
    * Difference of two given sets
    */
  def diff(s: Set, t: Set): Set = (x : Int) => s(x) ^ t(x)

  /**
    * Filter
    */
  def filter(s: Set, p: Int => Boolean): Set = (x : Int) => s(x) & p(x)

  /**
    * Test whether there's any function in the set that returns the same value
    * Since there's no way to compare two anonymous functions directly
  */
  val bound = 1000
  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a > bound) true
      else if (s(a) && !p(a)) false
      else iter(a + 1)
    }
    iter(-bound)
  }
  def exists(s: Set, p: Int => Boolean): Boolean = !forall(s, x => !p(x))

  /**
    * Map function's output to a different function
    */
  def map(s: Set, f: Int => Int): Set = (x: Int) => s.apply(f(x))

  /**
    * Displays the contents of a set
    */
  def toString(s: Set): String = {
    def iter(a: Int): String = {
      if (a > bound) ""
      else if (contains(s,a)) "," + a.toString + iter(a+1)
      else iter(a+1)
    }
    val builder = StringBuilder.newBuilder
    builder.append("{")
    builder.append(iter(-bound).substring(1)) // You can't really have an empty set with this approach, so this should remove the leading comma without fail
    builder.append("}")
    builder.toString()
  }
}



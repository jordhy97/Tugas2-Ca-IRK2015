package com.endec.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test class for BigInteger class
 *
 * @author Jordhy Fernando
 * @version 1.0
 */
public class BigIntegerTest {

  private static BigInteger zero;
  private static BigInteger pos1;
  private static BigInteger pos2;
  private static BigInteger neg1;
  private static BigInteger neg2;

  @BeforeClass
  public static void setUp() {
    zero = new BigInteger();
    pos1 = new BigInteger("87654321");
    pos2 = new BigInteger("12345678");
    neg1 = new BigInteger("-12345678");
    neg2 = new BigInteger("-87654321");
  }

  /**
   * Tests negate method.
   */
  @Test
  public void testNegate() {
    assertEquals("Test failed at negate zero", "0", zero.negate().toString());
    assertEquals("Test failed at negate positive value",
        "-87654321", pos1.negate().toString());
    assertEquals("Test failed at negate negative value",
        "12345678", neg1.negate().toString());
  }

  /**
   * Tests compareTo method.
   */
  @Test
  public void testCompareTo() {
    assertEquals("Test failed when comparing smaller positive value to bigger one",
        -1, pos2.compareTo(pos1));
    assertEquals("Test failed when comparing bigger positive value to smaller one",
        1, pos1.compareTo(pos2));
    assertEquals("Test failed when comparing positive value to negative value",
        1, pos2.compareTo(neg1));
    assertEquals("Test failed when comparing positive value to zero",
        1, pos2.compareTo(zero));

    assertEquals("Test failed when comparing smaller negative value to bigger one",
        -1, neg2.compareTo(neg1));
    assertEquals("Test failed when comparing bigger negative value to smaller one",
        1, neg1.compareTo(neg2));
    assertEquals("Test failed when comparing negative value to positive value",
        -1, neg1.compareTo(pos1));
    assertEquals("Test failed when comparing negative value to zero",
        -1, neg1.compareTo(zero));

    assertEquals("Test failed when comparing zero to positive value",
        -1, zero.compareTo(pos1));
    assertEquals("Test failed when comparing zero to negative value",
        1, zero.compareTo(neg2));

    assertEquals("Test failed when comparing zero to zero",
        0, zero.compareTo(zero));
    assertEquals("Test failed when comparing the same positive values",
        0, pos2.compareTo(pos2));
    assertEquals("Test failed when comparing the same negative values",
        0, neg1.compareTo(neg1));
  }

  /**
   * Tests isLessThan method.
   */
  @Test
  public void testIsLessThan() {
    assertTrue("Test failed when comparing smaller positive value to bigger one",
        pos2.isLessThan(pos1));
    assertFalse("Test failed when comparing positive value to negative value",
        pos2.isLessThan(neg1));
    assertFalse("Test failed when comparing positive value to zero",
        pos2.isLessThan(zero));

    assertTrue("Test failed when comparing smaller negative value to bigger one",
        neg2.isLessThan(neg1));
    assertTrue("Test failed when comparing negative value to zero",
        neg1.isLessThan(zero));

    assertFalse("Test failed when comparing zero to zero",
        zero.isLessThan(zero));
    assertFalse("Test failed when comparing the same positive values",
        pos2.isLessThan(pos2));
    assertFalse("Test failed when comparing the same negative values",
        neg1.isLessThan(neg1));
  }

  /**
   * Tests isGreaterThan method.
   */
  @Test
  public void isGreaterThan() {
    assertFalse("Test failed when comparing smaller positive value to bigger one",
        pos2.isGreaterThan(pos1));
    assertTrue("Test failed when comparing positive value to negative value",
        pos2.isGreaterThan(neg1));
    assertTrue("Test failed when comparing positive value to zero",
        pos2.isGreaterThan(zero));

    assertFalse("Test failed when comparing smaller negative value to bigger one",
        neg2.isGreaterThan(neg1));
    assertFalse("Test failed when comparing negative value to zero",
        neg1.isGreaterThan(zero));

    assertFalse("Test failed when comparing zero to zero",
        zero.isGreaterThan(zero));
    assertFalse("Test failed when comparing the same positive values",
        pos2.isGreaterThan(pos2));
    assertFalse("Test failed when comparing the same negative values",
        neg1.isGreaterThan(neg1));
  }

  /**
   * Tests equals method.
   */
  @Test
  public void equals() {
    assertFalse("Test failed when comparing smaller positive value to bigger one",
        pos2.equals(pos1));
    assertFalse("Test failed when comparing positive value to negative value",
        pos2.equals(neg1));
    assertFalse("Test failed when comparing positive value to zero",
        pos2.equals(zero));

    assertFalse("Test failed when comparing smaller negative value to bigger one",
        neg2.equals(neg1));
    assertFalse("Test failed when comparing negative value to zero",
        neg1.equals(zero));

    assertTrue("Test failed when comparing zero to zero",
        zero.equals(zero));
    assertTrue("Test failed when comparing the same positive values",
        pos2.equals(pos2));
    assertTrue("Test failed when comparing the same negative values",
        neg1.equals(neg1));
  }

  @Test
  public void isLessThanOrEquals() {
    assertTrue("Test failed when comparing smaller positive value to bigger one",
        pos2.isLessThanOrEquals(pos1));
    assertFalse("Test failed when comparing positive value to negative value",
        pos2.isLessThanOrEquals(neg1));
    assertFalse("Test failed when comparing positive value to zero",
        pos2.isLessThanOrEquals(zero));

    assertTrue("Test failed when comparing smaller negative value to bigger one",
        neg2.isLessThanOrEquals(neg1));
    assertTrue("Test failed when comparing negative value to zero",
        neg1.isLessThanOrEquals(zero));

    assertTrue("Test failed when comparing zero to zero",
        zero.isLessThanOrEquals(zero));
    assertTrue("Test failed when comparing the same positive values",
        pos2.isLessThanOrEquals(pos2));
    assertTrue("Test failed when comparing the same negative values",
        neg1.isLessThanOrEquals(neg1));
  }

  @Test
  public void isGreaterThanOrEquals() {
    assertFalse("Test failed when comparing smaller positive value to bigger one",
        pos2.isGreaterThanOrEquals(pos1));
    assertTrue("Test failed when comparing positive value to negative value",
        pos2.isGreaterThanOrEquals(neg1));
    assertTrue("Test failed when comparing positive value to zero",
        pos2.isGreaterThanOrEquals(zero));

    assertFalse("Test failed when comparing smaller negative value to bigger one",
        neg2.isGreaterThanOrEquals(neg1));
    assertFalse("Test failed when comparing negative value to zero",
        neg1.isGreaterThanOrEquals(zero));

    assertTrue("Test failed when comparing zero to zero",
        zero.isGreaterThanOrEquals(zero));
    assertTrue("Test failed when comparing the same positive values",
        pos2.isGreaterThanOrEquals(pos2));
    assertTrue("Test failed when comparing the same negative values",
        neg1.isGreaterThanOrEquals(neg1));
  }

  /**
   * Tests add method.
   */
  @Test
  public void testAdd() {
    assertEquals("Test failed at addition of zero with zero",
        "0", zero.add(zero).toString());
    assertEquals("Test failed at addition of zero with positive value",
        "87654321", zero.add(pos1).toString());
    assertEquals("Test failed at addition of zero with negative value",
        "-12345678", zero.add(neg1).toString());
    assertEquals("Test failed at addition of positive value with zero",
        "87654321", pos1.add(zero).toString());
    assertEquals("Test failed at addition of negative value with zero",
        "-12345678", neg1.add(zero).toString());
    assertEquals("Test failed at addition of 2 positive values (1)",
        "99999999", pos1.add(pos2).toString());
    assertEquals("Test failed at addition of 2 positive values (2)",
        "175308642", pos1.add(pos1).toString());
    assertEquals("Test failed at addition of 2 negative values",
        "-99999999", neg1.add(neg2).toString());
    assertEquals("Test failed at addition of positive value with negative value",
        "0", pos1.add(neg2).toString());
    assertEquals("Test failed at addition of negative value with positive value",
        "0", neg2.add(pos1).toString());
  }

  /**
   * Tests subtract method.
   */
  @Test
  public void testSubtract() {
    assertEquals("Test failed at subtraction of zero with zero",
        "0", zero.subtract(zero).toString());
    assertEquals("Test failed at subtraction of zero with positive value",
        "-87654321", zero.subtract(pos1).toString());
    assertEquals("Test failed at subtraction of zero with negative value",
        "12345678", zero.subtract(neg1).toString());
    assertEquals("Test failed at subtraction of positive value with zero",
        "87654321", pos1.subtract(zero).toString());
    assertEquals("Test failed at subtraction of negative value with zero",
        "-12345678", neg1.subtract(zero).toString());
    assertEquals("Test failed at subtraction of 2 positive values (positive result)",
        "75308643", pos1.subtract(pos2).toString());
    assertEquals("Test failed at subtraction of 2 positive values (negative result)",
        "-75308643", pos2.subtract(pos1).toString());
    assertEquals("Test failed at subtraction of 2 negative values (positive result)",
        "75308643", neg1.subtract(neg2).toString());
    assertEquals("Test failed at subtraction of 2 negative values (negative result)",
        "-75308643", neg2.subtract(neg1).toString());
    assertEquals("Test failed at subtraction of 2 same values",
        "0", neg2.subtract(neg2).toString());
    assertEquals("Test failed at subtraction of positive value with negative value",
        "99999999", pos1.subtract(neg1).toString());
    assertEquals("Test failed at subtraction of negative value with positive value",
        "-99999999", neg2.subtract(pos2).toString());
  }

  /**
   * Tests multiply method.
   */
  @Test
  public void testMultiply() {
    assertEquals("Test failed at multiplication of zero with zero",
        "0", zero.multiply(zero).toString());
    assertEquals("Test failed at multiplication of zero with positive value",
        "0", zero.multiply(pos1).toString());
    assertEquals("Test failed at multiplication of zero with negative value",
        "0", zero.multiply(neg1).toString());
    assertEquals("Test failed at multiplication of positive value with zero",
        "0", pos1.multiply(zero).toString());
    assertEquals("Test failed at multiplication of negative value with zero",
        "0", neg1.multiply(zero).toString());
    assertEquals("Test failed at multiplication of 2 positive values",
        "1082152022374638", pos1.multiply(pos2).toString());
    assertEquals("Test failed at multiplication of 2 negative values",
        "1082152022374638", neg1.multiply(neg2).toString());
    assertEquals("Test failed at multiplication of positive value with negative value",
        "-1082152022374638", pos1.multiply(neg1).toString());
    assertEquals("Test failed at multiplication of negative value with positive value",
        "-1082152022374638", neg2.multiply(pos2).toString());
  }

  /**
   * Tests divide method.
   */
  @Test
  public void testDivide() {
    assertEquals("Test failed at division of zero with positive value",
        "0", zero.divide(pos1).toString());
    assertEquals("Test failed at division of zero with negative value",
        "0", zero.divide(neg1).toString());
    assertEquals("Test failed at division of 2 positive values",
        "7", pos1.divide(pos2).toString());
    assertEquals("Test failed at division of 2 negative values",
        "7", neg2.divide(neg1).toString());
    assertEquals("Test failed at division of positive value with negative value",
        "-7", pos1.divide(neg1).toString());
    assertEquals("Test failed at division of negative value with positive value",
        "-7", neg2.divide(pos2).toString());
  }

  /**
   * Tests mod method.
   */
  @Test
  public void testMod() {
    assertEquals("Test failed at modulo of zero with positive value",
        "0", zero.mod(pos1).toString());
    assertEquals("Test failed at modulo of zero with negative value",
        "0", zero.mod(neg1).toString());
    assertEquals("Test failed at modulo of 2 positive values",
        "1234575", pos1.mod(pos2).toString());
    assertEquals("Test failed at modulo of 2 negative values",
        "-1234575", neg2.mod(neg1).toString());
    assertEquals("Test failed at modulo of positive value with negative value",
        "1234575", pos1.mod(neg1).toString());
    assertEquals("Test failed at modulo of negative value with positive value",
        "-1234575", neg2.mod(pos2).toString());
  }

  /**
   * Tests isOdd method.
   */
  @Test
  public void testIsOdd() {
    assertTrue("Test failed at checking odd value", pos1.isOdd());
    assertFalse("Test failed at checking even value", pos2.isOdd());
    assertFalse("Test failed at checking 0", zero.isOdd());
  }

  /**
   * Tests isEven method.
   */
  @Test
  public void testIsEven() {
    assertFalse("Test failed at checking odd value", neg2.isEven());
    assertTrue("Test failed at checking even value", neg1.isEven());
    assertTrue("Test failed at checking 0", zero.isEven());
  }

  /**
   * Tests pow method.
   */
  @Test
  public void testPow() {
    assertEquals("Test failed at power of positive with zero exponent",
        "1", pos1.pow(zero).toString());
    assertEquals("Test failed at power of negative with zero exponent",
        "1", neg1.pow(zero).toString());
    assertEquals("Test failed at power of negative with odd exponent",
        "-1881675960266558605752", neg1.pow(new BigInteger(3)).toString());
    assertEquals("Test failed at power of negative with even exponent",
        "152415765279684", neg1.pow(new BigInteger(2)).toString());
    assertEquals("Test failed at power of positive",
        "1881675960266558605752", pos2.pow(new BigInteger(3)).toString());
  }

  /**
   * Tests modPow method.
   */
  @Test
  public void testModPow() {
    assertEquals("Test failed at modPow of positive with zero exponent",
        "0", pos1.modPow(zero, new BigInteger(1)).toString());
    assertEquals("Test failed at modPow of negative with zero exponent",
        "1", neg1.modPow(zero, new BigInteger(11)).toString());
    assertEquals("Test failed at modPow of negative with odd exponent",
        "0", neg1.modPow(new BigInteger(3), new BigInteger(3)).toString());
    assertEquals("Test failed at modPow of negative with even exponent",
        "0", neg1.modPow(new BigInteger(3), new BigInteger(2)).toString());
    assertEquals("Test failed at modPow of positive",
        "2", pos2.modPow(new BigInteger(3), new BigInteger(5)).toString());
  }

  /**
   * Tests gcd method.
   */
  @Test
  public void testGcd() {
    assertEquals("Test failed at gcd of zero with zero",
        "0", zero.gcd(zero).toString());
    assertEquals("Test failed at gcd of positive value with zero",
        "87654321", pos1.gcd(zero).toString());
    assertEquals("Test failed at gcd of negative value with zero",
        "12345678", neg1.gcd(zero).toString());
    assertEquals("Test failed at gcd of positive value with positive value",
        "9", pos2.gcd(pos1).toString());
    assertEquals("Test failed at gcd of positive value with negative value",
        "9", pos1.gcd(neg1).toString());
    assertEquals("Test failed at gcd of negative value with negative value",
        "9", neg2.gcd(neg1).toString());
    assertEquals("Test failed at gcd of negative value with positive value",
        "12345678", neg1.gcd(pos2).toString());
  }

  /**
   * Tests gcdExtended method.
   */
  @Test
  public void testGcdExtended() {
    BigInteger[] temp;
    temp = zero.gcdExtended(zero);
    assertEquals("Test failed at gcdExtended of zero with zero",
        "0", temp[0].toString());
    assertTrue("Test failed at gcdExtended of zero with zero",
        zero.multiply(temp[1]).add(zero.multiply(temp[2])).equals(temp[0]));

    temp = pos1.gcdExtended(zero);
    assertEquals("Test failed at gcdExtended of positive value with zero",
        "87654321", temp[0].toString());
    assertTrue("Test failed at gcdExtended of positive value with zero",
        pos1.multiply(temp[1]).add(zero.multiply(temp[2])).equals(temp[0]));

    temp = neg1.gcdExtended(zero);
    assertEquals("Test failed at gcdExtended of negative value with zero",
        "12345678", temp[0].toString());
    assertTrue("Test failed at gcdExtended of negative value with zero",
        neg1.multiply(temp[1]).add(zero.multiply(temp[2])).equals(temp[0]));

    temp = pos2.gcdExtended(pos1);
    assertEquals("Test failed at gcdExtended of positive value with positive value",
        "9", temp[0].toString());
    assertTrue("Test failed at gcdExtended of positive value value with positive value",
        pos2.multiply(temp[1]).add(pos1.multiply(temp[2])).equals(temp[0]));

    temp = pos1.gcdExtended(neg1);
    assertEquals("Test failed at gcdExtended of positive value with negative value",
        "9", temp[0].toString());
    assertTrue("Test failed at gcdExtended of positive value value with negative value",
        pos1.multiply(temp[1]).add(neg1.multiply(temp[2])).equals(temp[0]));

    temp = neg2.gcdExtended(neg1);
    assertEquals("Test failed at gcdExtended of negative value with negative value",
        "9", temp[0].toString());
    assertTrue("Test failed at gcdExtended of negative value value with negative value",
        neg2.multiply(temp[1]).add(neg1.multiply(temp[2])).equals(temp[0]));

    temp = neg1.gcdExtended(pos2);
    assertEquals("Test failed at gcdExtended of negative value with positive value",
        "12345678", temp[0].toString());
    assertTrue("Test failed at gcdExtended of negative value value with positive value",
        neg1.multiply(temp[1]).add(pos2.multiply(temp[2])).equals(temp[0]));
  }

  /**
   * Tests modInverse method.
   */
  @Test
  public void testModInverse() {
   assertEquals("Test failed at modInverse",
       "5", new BigInteger(3).modInverse(new BigInteger(7)).toString());
    assertEquals("Test failed at modInverse",
        "6", new BigInteger(6).modInverse(new BigInteger(7)).toString());
  }

  /**
   * Tests random method.
   */
  @Test
  public void testRandom() {
    BigInteger temp = BigInteger.random(neg2, neg1);
    assertTrue("Test failed at random with range negative to negative",
        temp.isGreaterThanOrEquals(neg2) && temp.isLessThanOrEquals(neg1));
    temp = BigInteger.random(neg2, zero);
    assertTrue("Test failed at random with range negative to zero",
        temp.isGreaterThanOrEquals(neg2) && temp.isLessThanOrEquals(zero));
    temp = BigInteger.random(neg2, pos1);
    assertTrue("Test failed at random with range negative to positive",
        temp.isGreaterThanOrEquals(neg2) && temp.isLessThanOrEquals(pos1));
    temp = BigInteger.random(zero, pos1);
    assertTrue("Test failed at random with range zero to positive",
        temp.isGreaterThanOrEquals(zero) && temp.isLessThanOrEquals(pos1));
    temp = BigInteger.random(pos2, pos1);
    assertTrue("Test failed at random with range positive to positive",
        temp.isGreaterThanOrEquals(pos2) && temp.isLessThanOrEquals(pos1));
  }

  /**
   * Tests isProbable method.
   *
   * <p>Notes: Test may failed with probability (2<sup>-100</sup>).
   */
  @Test
  public void testIsProbablePrime() {
    assertTrue("Test failed at isProbablePrime",
        new BigInteger(3).isProbablePrime(50));
    assertTrue("Test failed at isProbablePrime",
        new BigInteger(2147483647).isProbablePrime(50));
    assertFalse("Test failed at isProbablePrime",
        pos1.isProbablePrime(50));
    assertFalse("Test failed at isProbablePrime",
        pos2.isProbablePrime(50));
  }

  /**
   * Tests probablePrime method.
   *
   * <p>Notes: Test may failed with probability (2<sup>-100</sup>).
   */
  @Test
  public void testProbablePrime() {
    BigInteger temp = BigInteger.probablePrime(1, 50);
    assertTrue("Test failed at probablePrime",
        temp.isProbablePrime(50));
    assertTrue("Test failed at probablePrime",
        temp.isGreaterThan(zero) && temp.isLessThan(new BigInteger(10)));

    temp = BigInteger.probablePrime(2, 50);
    assertTrue("Test failed at probablePrime",
        temp.isProbablePrime(50));
    assertTrue("Test failed at probablePrime",
        temp.isGreaterThan(new BigInteger(9)) &&
            temp.isLessThan(new BigInteger(100)));

    temp = BigInteger.probablePrime(3, 50);
    assertTrue("Test failed at probablePrime",
        temp.isProbablePrime(50));
    assertTrue("Test failed at probablePrime",
        temp.isGreaterThan(new BigInteger(99)) &&
            temp.isLessThan(new BigInteger(1000)));

    temp = BigInteger.probablePrime(4, 50);
    assertTrue("Test failed at probablePrime",
        temp.isProbablePrime(50));
    assertTrue("Test failed at probablePrime",
        temp.isGreaterThan(new BigInteger(999)) &&
            temp.isLessThan(new BigInteger(10000)));

  }
}
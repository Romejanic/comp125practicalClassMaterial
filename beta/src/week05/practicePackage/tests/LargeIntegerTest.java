package week05.practicePackage.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import week05.practicePackage.attempts.*;
import week05.practicePackage.attempts.advanced.LargeInteger;

public class LargeIntegerTest {
	private LargeInteger large1, large2;

	@BeforeEach
	public void setup() {
		large1 = new LargeInteger();
		large2 = new LargeInteger();
	}

	@Test
	public void testSetValue() {
		large1.setValue("12345");
		assertEquals("12345", large1.value);

		large1.setValue("123457453897200000000000000000000000000000000923845392563759462976459725973659345952863495623947692376547926");
		assertEquals("123457453897200000000000000000000000000000000923845392563759462976459725973659345952863495623947692376547926", large1.value);

		large2.setValue("123a");
		assertEquals("0", large2.value);
	}

	@Test
	public void testNDigits() {
		large1.setValue("1729");
		assertEquals(4, large1.nDigits());

		large2.setValue("-37");
		assertEquals(2, large2.nDigits());
	}

	@Test
	public void testGetLastDigit() {
		large1.setValue("1729");
		assertEquals(9, large1.getLastDigit());

		large2.setValue("-37");
		assertEquals(7, large2.getLastDigit());
	}

	@Test
	public void testGetFirstDigit() {
		large1.setValue("1729");
		assertEquals(1, large1.getFirstDigit());

		large2.setValue("-37");
		assertEquals(3, large2.getFirstDigit());
	}

	@Test
	public void testAdd() {
		large1.setValue("1729");
		large2.setValue("37");
		assertNotNull(large1.add(large2));
		assertEquals("1766", large1.add(large2).value);

		large1.setValue("-4436933645896356356345030546035064079435397193472924925434");
		large2.setValue("945379723853759365972659347623753");
		assertEquals("-4436933645896356356345029600655340225676031220813577301681", large1.add(large2).value);
	}

}

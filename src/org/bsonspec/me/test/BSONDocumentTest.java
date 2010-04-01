package org.bsonspec.me.test;

/***
Copyright (c) 2010 Ufuk Kayserilioglu (ufuk@paralaus.com)

Licensed under the Apache License, Version 2.0 (the "License"); you may
not use this file except in compliance with the License. You may obtain
a copy of the License at
	http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

import org.bsonspec.me.BSONArray;
import org.bsonspec.me.BSONDocument;
import org.bsonspec.me.BSONException;

import jmunit.framework.cldc11.AssertionFailedException;
import jmunit.framework.cldc11.TestCase;


public class BSONDocumentTest extends TestCase {

	/**
	 * The default constructor. It just transmits the necessary informations to
	 * the superclass.
	 * 
	 * @param totalOfTests the total of test methods present in the class.
	 * @param name this testcase's name.
	 */
	public BSONDocumentTest() {
		super(2, "BSONDocumentTest");
	}

	private static final byte[] testData1 = 
		{0x16, 0x00, 0x00, 0x00, 0x02, 0x68, 0x65, 0x6C, 
		 0x6C, 0x6F, 0x00, 0x06, 0x00, 0x00, 0x00, 0x77, 
		 0x6F, 0x72, 0x6C, 0x64, 0x00, 0x00};
	
	private static final byte[] testData2 = 
		{0x30, 0x00, 0x00, 0x00, 
		0x04, 0x42, 0x53, 0x4F, 0x4E, 0x00,
		0x25, 0x00, 0x00, 0x00, 
		0x02, 0x30, 0x00, 0x08, 0x00, 0x00, 0x00, 0x61, 0x77, 0x65, 0x73, 0x6F, 0x6D, 0x65, 0x00, 
		0x10, 0x31, 0x00, 0x05, 0x00, 0x00, 0x00, 
		0x12, 0x32, 0x00, (byte)0xc2, 0x07, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
		0x00};
	
	public void BSONDocument1Test() throws AssertionFailedException, BSONException {
		BSONDocument doc = new BSONDocument(testData1);
		
		assertEquals("world", doc.get("hello"));
	}

	public void BSONDocument2Test() throws AssertionFailedException, BSONException {
		BSONDocument doc = new BSONDocument(testData2);
		BSONArray values = doc.getArray("BSON");
		
		assertEquals(3, values.length());
		assertEquals("awesome", values.getString(0));
		assertEquals(5, values.getInt(1));
		assertEquals(1986, values.getLong(2));
	}

	/**
	 * This method stores all the test methods invocation. The developer must
	 * implement this method with a switch-case. The cases must start from 0 and
	 * increase in steps of one until the number declared as the total of tests
	 * in the constructor, exclusive. For example, if the total is 3, the cases
	 * must be 0, 1 and 2. In each case, there must be a test method invocation.
	 * 
	 * @param testNumber the test to be executed.
	 * @throws Throwable anything that the executed test can throw.
	 */
	public void test(int testNumber) throws Throwable {
		switch (testNumber) {
		case 0:
			BSONDocument1Test();
			break;
		case 1:
			BSONDocument2Test();
			break;
		}
	}

}

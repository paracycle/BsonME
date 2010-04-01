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

import jmunit.framework.cldc11.TestSuite;

public class AllTestSuite extends TestSuite {

	/**
	 * TestSuite Class constructor initializes the test suite.
	 */
	public AllTestSuite() {
		super("AllTestSuite");
		this.setupSuite();
	}

	/**
	 * This method adds all suite test cases to be run.
	 */
	private void setupSuite() {
		//JMUnit-BEGIN
		add(new BSONDocumentTest());
		//JMUnit-END
	}

}

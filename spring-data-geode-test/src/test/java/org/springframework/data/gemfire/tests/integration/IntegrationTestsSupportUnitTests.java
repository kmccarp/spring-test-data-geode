/*
 *  Copyright 2017-present the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 *  or implied. See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package org.springframework.data.gemfire.tests.integration;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

/**
 * Unit Tests for {@link IntegrationTestsSupport}.
 *
 * @author John Blum
 * @see org.junit.Test
 * @see org.springframework.data.gemfire.tests.integration.IntegrationTestsSupport
 * @since 1.0.0
 */
public class IntegrationTestsSupportUnitTests {

	@Test
	public void asDirectoryNameIsCorrect() {

		LocalDateTime now = LocalDateTime.now();

		String directoryName = IntegrationTestsSupport.asDirectoryName(OuterType.InnerType.class);

		assertThat(directoryName).isNotBlank();
		assertThat(directoryName).matches(String.format("%s\\.%s\\.%s-%s-",
			IntegrationTestsSupportUnitTests.class.getSimpleName(), OuterType.class.getSimpleName(), OuterType.InnerType.class.getSimpleName(),
			DateTimeFormatter.ofPattern(IntegrationTestsSupport.DATE_TIME_PATTERN).format(now)).concat("[\\w-]+"));

	}

	interface OuterType {
		interface InnerType { }
	}
}

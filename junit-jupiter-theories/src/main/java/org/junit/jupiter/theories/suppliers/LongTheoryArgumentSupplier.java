/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package org.junit.jupiter.theories.suppliers;

import static java.util.stream.Collectors.toList;
import static org.apiguardian.api.API.Status.INTERNAL;

import java.util.Arrays;
import java.util.List;

import org.apiguardian.api.API;
import org.junit.jupiter.theories.domain.DataPointDetails;
import org.junit.jupiter.theories.domain.TheoryParameterDetails;
import org.junit.platform.commons.util.Preconditions;

/**
 * Argument supplier for {@code long} arguments.
 *
 * @see LongValues
 */
@API(status = INTERNAL, since = "5.3")
public class LongTheoryArgumentSupplier extends AbstractTheoryArgumentSupplier<LongValues> {
	/**
	 * Constructor.
	 */
	public LongTheoryArgumentSupplier() {
		super(LongValues.class);
	}

	@Override
	protected List<DataPointDetails> buildArguments(TheoryParameterDetails parameterDetails,
			LongValues annotationToParse) {

		long[] valuesFromAnnotation = annotationToParse.value();
		Preconditions.condition(valuesFromAnnotation.length > 0, "Supplier annotations cannot have empty values");

		// @formatter:off
		return Arrays.stream(valuesFromAnnotation)
				.boxed()
				.map(this::toDataPointDetails)
				.collect(toList());
		// @formatter:on
	}
}

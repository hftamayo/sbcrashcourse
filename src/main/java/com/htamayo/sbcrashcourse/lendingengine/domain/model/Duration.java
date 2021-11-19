package com.htamayo.sbcrashcourse.lendingengine.domain.model;

import java.io.Serializable;
import java.math.BigInteger;

public final class Duration implements TemporalAmount, Comparable<Duration>, Serializable {

    public static final Duration ZERO = new Duration(0, 0);

    private static final long serialVersionUID = 3078945930695997490L;

    private static final BigInteger BI_NANOS_PER_SECOND = BigInteger.valueOf(NANOS_PER_SECOND);




}

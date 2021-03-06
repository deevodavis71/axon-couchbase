/*
 * The MIT License
 *
 * Copyright 2017 Bj&ouml;rn Oscarsson.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.github.haxorof.axon.couchbase.eventsourcing.eventstore;

import com.couchbase.client.java.Bucket;
import java.util.List;
import java.util.Optional;
import org.axonframework.eventhandling.EventMessage;
import org.axonframework.eventsourcing.DomainEventMessage;
import org.axonframework.eventsourcing.eventstore.DomainEventData;
import org.axonframework.eventsourcing.eventstore.TrackedEventData;
import org.axonframework.eventsourcing.eventstore.TrackingToken;
import org.axonframework.serialization.Serializer;

/**
 *
 * @author Bj&ouml;rn Oscarsson
 */
public interface CouchbaseStoreStrategy {

    public void appendEvents(Bucket bucket, List<? extends EventMessage<?>> events, Serializer serializer);

    public void appendSnapshot(Bucket bucket, DomainEventMessage<?> snapshot, Serializer serializer);

    public Optional<? extends DomainEventData<?>> findLastSnapshot(Bucket bucket, String aggregateIdentifier);

    public List<? extends DomainEventData<?>> findDomainEvents(Bucket bucket, String aggregateIdentifier, long firstSequenceNumber, int batchSize);

    public List<? extends TrackedEventData<?>> findTrackedEvents(Bucket bucket, TrackingToken lastToken, int batchSize);
    
}

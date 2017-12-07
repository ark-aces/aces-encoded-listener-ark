package com.arkaces.aces_listener_ark;

import com.arkaces.aces_server.aces_listener.event.Event;
import com.arkaces.aces_server.common.json.NiceObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * This is a helper callback endpoint to log raw events for testing purposes.
 */
@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EventLogController {

    private final NiceObjectMapper logObjectMapper;

    @PostMapping("/event-logger")
    public Event postEvent(@RequestBody Event event) {
        log.info(logObjectMapper.writeValueAsString(event));
        return event;
    }
}
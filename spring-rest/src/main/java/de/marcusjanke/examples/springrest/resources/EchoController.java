package de.marcusjanke.examples.springrest.resources;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.marcusjanke.examples.springrest.model.Echo;

@RestController
public class EchoController {

    private static final String template = "Echo of '%s'";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/echo")
    public Echo greeting(@RequestParam(value="content", defaultValue="") String content) {
        return new Echo(counter.incrementAndGet(), String.format(template, content));
    }
}
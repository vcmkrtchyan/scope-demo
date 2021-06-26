package org.esiminch;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@SessionScope
@RestController
@RequestMapping("/")
public class TestController {

    private List<Integer> cachedListItems = new ArrayList<>();

    @GetMapping("/test")
    public String test() {
        if (cachedListItems.isEmpty()) {
            for (int i = 0; i < 50000000; i++) {
                cachedListItems.add(i);
            }
        }

        return String.valueOf(cachedListItems.size());
    }

}

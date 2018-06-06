package com.example.demo

import geb.Browser
import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.EventListener

@Configuration
class DemoCommandRunner {

    @EventListener(ApplicationStartedEvent)
    void run() {
        Browser.drive {
            go "http://gebish.org"

            assert title == "Geb - Very Groovy Browser Automation"

            $("div.menu a.manuals").click()
            waitFor { !$("#manuals-menu").hasClass("animating") }

            $("#manuals-menu a")[0].click()

            assert title.startsWith("The Book Of Geb")
        }
    }
}

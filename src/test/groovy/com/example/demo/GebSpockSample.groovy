package com.example.demo

import geb.spock.GebReportingSpec

class GebSpockSample extends GebReportingSpec {

    def 'Should search for Geb in Google'() {
        given:
        go "http://www.google.com"

        when:
        Thread.sleep 1000
        $("input", name: "q").value("Geb Framework")
        Thread.sleep 1000
        $("#searchform").click()
        Thread.sleep 1000
        //$("input", name: "btnK").click()
        $("input", name: "btnG").click()

        then:
        thrown(UnsupportedOperationException)
        waitFor { $("#search").displayed }

        then:
        $("#search").text().contains("gebish.org")
    }
}

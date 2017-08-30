package com.example.demo

import groovy.transform.Canonical
import groovy.transform.CompileStatic
import org.springframework.web.bind.annotation.ResponseBody

@Canonical @CompileStatic
class Moon {

    String planet
    String name
    Date created = new Date()
    URL url

}

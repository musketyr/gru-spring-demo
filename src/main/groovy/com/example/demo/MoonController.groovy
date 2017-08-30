package com.example.demo

import groovy.transform.CompileStatic
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@CompileStatic
@RequestMapping('/moons')
class MoonController {

    @RequestMapping(value = '/{planet}/{name}', method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody Moon show(@PathVariable('planet') String planet, @PathVariable('name') String name) {
        if (planet == 'earth' && name == 'moon') {
            return new Moon(planet: 'Earth', name: 'Moon', url: new URL('https://en.wikipedia.org/wiki/Moon'))
        }
        throw new NotFoundException("Moon $name not found around $planet")
    }

}

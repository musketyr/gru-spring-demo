package com.example.demo

import com.agorapulse.gru.Gru
import com.agorapulse.gru.spring.Spring
import org.junit.Rule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

@WebMvcTest
class MoonControllerSpec extends Specification {

    @Rule Gru<Spring> gru = Gru.equip(Spring.steal(this))

    @Autowired MockMvc mvc

    void 'show the moon'() {
        expect:
            gru.test {
                get '/moons/earth/moon'
                expect {
                    json 'moonResponse.json'
                }
            }
    }

    void 'other moons not found yet'() {
        expect:
            gru.test {
                get '/moons/earth/noom'
                expect {
                    status NOT_FOUND
                }
            }
    }

}

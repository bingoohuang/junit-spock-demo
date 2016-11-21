package com.github.bingoohuang.spockdemo

import spock.lang.Specification
import spock.lang.Unroll


/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2016/11/14.
 */
@Unroll
class AddTest extends Specification {
    def "add two numbers : #a + #b = #sum"() {
        given:
        Adder adder = new Adder();

        expect:
        adder.add(a, b) == sum

        where:
        a | b | sum
        1 | 2 | 3
        2 | 4 | 6
    }
}
package com.github.bingoohuang.spockdemo

import spock.lang.Specification

class MachineServiceTest extends Specification {
    MachineDao machineDao = Mock();
    MachineService machineService = new MachineService(machineDao);

    def "should calculate and persist"() {
        when:
            int sum = machineService.calculateAndPersist(2, 3);

        then:
            1 * machineDao.save(_) >> { int x -> x + 1 }
            sum == 6
    }

    def "should fail"() {
        when:
            machineService.calculateAndPersist(2, 3);

        then:
            1 * machineDao.save(_) >> { throw new RuntimeException("disk corrupted") }
            thrown RuntimeException
    }
}

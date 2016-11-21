package com.github.bingoohuang.spockdemo;

class MachineService {
    private final MachineDao machineDao;

    public MachineService(MachineDao machineDao) {
        this.machineDao = machineDao;
    }

    public int calculateAndPersist(int x, int y) {
        int sum = Calculator.take(x).add(y).calculate();
        return machineDao.save(sum);
    }
}
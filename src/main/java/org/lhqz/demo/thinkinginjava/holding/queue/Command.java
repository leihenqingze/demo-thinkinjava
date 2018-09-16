package org.lhqz.demo.thinkinginjava.holding.queue;

class Command {

    Command(String operation) {
        this.operation = operation;
    }

    private String operation;

    String getOperation() {
        return operation;
    }

}
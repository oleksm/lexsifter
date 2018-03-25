package com.oleks.e

class Launcher {

    static int minReps = 2

    public static void main(String... args) {
        new BookReaderSensor(fn: "content/Aeschylus - Prometheus Bound.txt").listen().join();
//        new BookReaderSensor(fn: "content/cat.txt").listen().join();
        def mined = DI.ctx.all.findAll {it.count >= minReps}.sort {it.depth}.reverse()
//        println "most used ${mined.size()} : " + mined.collect { "${it}:${it.depth}:${it.count}"}
        new GraphVizGen().gen(mined)
    }
}

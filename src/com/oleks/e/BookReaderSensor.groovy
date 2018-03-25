package com.oleks.e

class BookReaderSensor {
    String fn
    Map<Character, E> roots = new HashMap<Character, E>();
    def Thread listen() {
        new Thread().start {
            new File(fn).eachLine { line ->
                println line
                line.getChars().each { c->
                    fire(c)
                }
            }
        }
    }

    def fire(char c) {
        def e = roots[c]
        if (!e) {
            e = new E(id: c, depth: 1)
            roots[c] = e
        }
        DI.ctx.fire(e)
    }
}

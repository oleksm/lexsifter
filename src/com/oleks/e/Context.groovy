package com.oleks.e

class Context {
    def all = new LinkedHashSet<E>()
    def fires = new LinkedList<FiredE>()

    long maxDepth = 100

    def fire(E e) {
        if (!all.contains(e)) {
            all.add(e)
        }
        ++e.count

        def next = [new FiredE(e: e)]
        fires.each { f ->
            def fe = f.e
            if (fe.depth < maxDepth) {
                def fer = fe.refs[e]
                if (!fer) {
                    fer = new E(id: fe.id + e.id, depth: fe.depth + 1)
                    fe.refs[e] = fer
                    all.add(fer)
                }
                next.add(new FiredE(e: fer))
                fer.count++
            }
        }
//        println "stats fires:${fires.size()} next:${next.size()}"
        fires = next
//        println "fired: ${fires}"
//        println "added: ${adds}"
//        println "removed: ${removes}"
//        println ""
    }
}

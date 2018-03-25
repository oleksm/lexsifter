package com.oleks.e

import groovy.json.StringEscapeUtils

class GraphVizGen {

    def gen(Collection<E> network) {
        def b = new StringBuilder()
        b.append("digraph prof {\n")
         .append("\tsize=\"6,4\"; ratio = fill;\n")
         .append("\tnode [style=filled];\n")

        network.each { e ->
            e.refs.findAll { ref -> network.contains(ref.value)}.each { r ->
                def src = StringEscapeUtils.escapeJava(e.id)
                def dest = StringEscapeUtils.escapeJava(r.value.id)
                b.append("\"${src}:${e.count}\" -> \"${dest}:${r.value.count}\";\n")
            }
        }
        b.append("}")
        new File("content/network.dot").write(b.toString())
    }
}


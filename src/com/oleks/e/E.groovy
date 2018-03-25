package com.oleks.e

class E {
    String id
    long count
    long depth
    Map<E, E> refs = [:]


    @Override
    int hashCode() {
        return id?.hashCode()
    }

    @Override
    String toString() {
        return "${id}"
    }

    @Override
    boolean equals(Object obj) {
        return obj instanceof E && id?.equals(((E)obj).id)
    }
}

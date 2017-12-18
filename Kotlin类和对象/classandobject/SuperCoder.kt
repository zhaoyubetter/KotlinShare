package com.sugarya.example.classandobject

class SuperCoder(name: String) : Coder(name), Writable{

    override val book: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun work() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun drink() {
//        super<Coder>.drink()
        super<Writable>.drink()
    }
}
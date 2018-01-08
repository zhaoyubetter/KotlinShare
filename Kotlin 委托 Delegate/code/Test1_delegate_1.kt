package com.better.delegate.code

interface TicketCenter {
    fun sellTicket()
}

class TrainTicketCenter : TicketCenter {
    override fun sellTicket() {
        println("TrainTicketCenter sellTicket")
    }
}

class JDTrainTicketCenter(val ticket: TicketCenter) : TicketCenter by ticket {
    override fun sellTicket() {
        if(verify()) {
            ticket.sellTicket();
        }
    }

    fun verify() :Boolean {
        return true
    }
}

fun main(args: Array<String>) {
    val ticket = TrainTicketCenter()
    JDTrainTicketCenter(ticket).sellTicket()
}
package com.ddang_.freezer.managers

import com.ddang_.freezer.Freezer
import org.bukkit.Bukkit

class LogManager {
    companion object {
        fun sendMessageToOperator(m: String) {
            Freezer.players.forEach {
                if (!it.isOp) {
                    return@forEach
                }
                it.sendMessage(m)
            }
            Bukkit.getConsoleSender().sendMessage(m)
        }
    }
}
package com.ddang_.freezer.managers

import org.bukkit.command.CommandSender

class CommandManager {
    companion object {
        fun helpMessage(sender: CommandSender) {
            sender.sendMessage("")
        }
    }
}